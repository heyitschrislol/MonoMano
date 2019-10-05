package application.front.sheets;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import application.back.enums.Asset;
import application.back.enums.ID;
import application.back.enums.Location;
import application.back.enums.Tag;
import application.back.managers.Handler;
import application.back.managers.InputManager;
import application.back.managers.SoundManager;
import application.front.Base;
import application.front.controllers.LakeController;
import application.front.controllers.StartController;
import application.front.objects.Boundary;
import application.front.objects.EnvironmentObject;
import application.front.objects.GameObject;
import application.front.objects.NPCObject;
import application.front.objects.PlayerObject;
import javafx.animation.AnimationTimer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class LakeSheet extends Sheet {
	public final long startNanoTime = System.nanoTime();
	public static double elapsedTime = Base.elapsedTime;
	public Image[] sceneFrames;
	public LakeSheet(int startX, int startY) throws FileNotFoundException {
		super(startX, startY);
		this.location = Location.LAKE;
		SoundManager.bgins.stopSong();
		SoundManager.water.playSong();
		
		portallist.addAll(createExitList());
		
		sceneImage = Asset.assetImage("LAKE");
		PlayerObject.location = Location.LAKE;
		player = new PlayerObject(startX, startY, 64, 64, ID.PLAYER);
		
		canvas = new Canvas(768, 512);
		gc = canvas.getGraphicsContext2D();


        getChildren().add(canvas);

        sceneFrames = new Image[3];
        sceneFrames[0] = Asset.assetImage("WATER1");
        sceneFrames[1] = Asset.assetImage("WATER2");
        sceneFrames[2] = Asset.assetImage("WATER3");
        
        
        
        
//        NPCObject nudeman = new NPCObject(369, 169, 55, 64, ID.NPC, Tag.CHARACTER);
        EnvironmentObject lake = new EnvironmentObject(0, 215, 768, 297, ID.COLLIDABLE, Tag.WATER);
//        EnvironmentObject crateLG = new EnvironmentObject(200, 175, 42, 47, ID.COLLIDABLE, Tag.CRATE);
//        EnvironmentObject indoor = new EnvironmentObject(335, 500, 98, 16, ID.COLLIDABLE, Tag.DOOR);
//        EnvironmentObject backwall = new EnvironmentObject(0, 0, 768, 64, ID.COLLIDABLE, Tag.BORDER);
//        EnvironmentObject leftwall = new EnvironmentObject(0, 64, 16, 448, ID.COLLIDABLE, Tag.BORDER);
//        EnvironmentObject rightwall = new EnvironmentObject(752, 64, 16, 448, ID.COLLIDABLE, Tag.DOOR);
        lake.setFrames(sceneFrames);
//        nudeman.setName("Fully-Erect Nude Man");
//        nudeman.setImage(nudemanframes[3]);
//        nudeman.setSound("grunt");
//        nudeman.setVolume(0.07);
//        nudeman.setFrames(nudeframes);
//        indoor.setSound("doorclick");
//        crateSM.setImage(Asset.assetImage("SMCRATE"));
//		crateSM.setSound("boodaboo");
//        crateLG.setImage(Asset.assetImage("LGCRATE"));
//		crateLG.setSound("boodaboo");
//        indoor.setImage(Asset.assetImage("INDOOR"));
//        backwall.setImage(Asset.assetImage("BACKWALL"));
//        leftwall.setImage(Asset.assetImage("LEFTWALL"));
//        rightwall.setImage(Asset.assetImage("RIGHTWALL"));
        player.setFrames(Asset.returnDown());
		player.setImage(Asset.findIdle("DOWN"));
//        nudeman.setObjecttext("My milkshake brings all the boys to th- whaa agh!");
//        crateSM.setObjecttext("This crate is full of empty peanut butter jars...");
//        crateLG.setObjecttext("It looks like a small animal was kept in here...");
		objectlist.add(lake);
        objectlist.add(player);
//        objectlist.add(nudeman);
//        objectlist.add(crateSM);
//        objectlist.add(crateLG);
//        objectlist.add(indoor);
//        objectlist.add(backwall);
//        objectlist.add(leftwall);
//        objectlist.add(rightwall);
        
        Handler.setObjectlist(objectlist);
        
        
		

        new AnimationTimer() {
			public void handle(long currentNanoTime) {
				int i = 0;
				int j = 0;
				
				elapsedTime = (currentNanoTime - startNanoTime) / 1000000000.0;

				gc.clearRect(0, 0, 768, 512);
//				animate(elapsedTime, .9);
				gc.drawImage(sceneImage, 0, 0);
				
				
				player.setNextX(player.getX());
				player.setNextY(player.getY());
				if (player.downkey) {
					player.setFrames(Asset.returnDown());
					player.animate(elapsedTime, 0.100);
					player.setNextY(player.getNextY() + 5);
					lake.animate(elapsedTime, .9);

				}
				if (player.upkey) {
					player.setFrames(Asset.returnUp());
					player.animate(elapsedTime, 0.100);
					player.setNextY(player.getNextY() - 5);
					lake.animate(elapsedTime, .9);

				}
				if (player.leftkey) {
					player.setFrames(Asset.returnLeft());
					player.animate(elapsedTime, 0.100);
					player.setNextX(player.getNextX() - 5);
					lake.animate(elapsedTime, .9);

				}
				if (player.rightkey) {
					player.setFrames(Asset.returnRight());
					player.animate(elapsedTime, 0.100);
					player.setNextX(player.getNextX() + 5);
					lake.animate(elapsedTime, .9);

				}
//				if (player.intersects(indoor) && player.downkey) {
//					try {
//						if (!indoor.getSound().isBlank()) {
//							SoundManager.playClip(indoor.getSound());
//						}
//						StartController controller = new StartController(607, 445);
//						Handler.changeScene(controller);
//						lake.animate(elapsedTime, .9);
//						this.stop();
//						gc.clearRect(0, 0, 768, 512);
//					} catch (FileNotFoundException e) {
//						e.printStackTrace();
//					}
//				}
				for (Boundary b : createExitList()) {
					if (player.intersects(b) && b.getLabel().equals("north") && player.upkey) {
						try {
							StartController controller = new StartController((int) player.getX(), 465);
							Handler.changeScene(controller);
							this.stop();
							gc.clearRect(0, 0, 768, 512);
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}
					}
				}
				for (Boundary bound : objectBoundaries()) {
					if (bound.intersects(player.getNextX(), player.getNextY() + 15, 64, 34)) {
						if (bound.getTag() != Tag.BORDER) {
							InputManager.intersecting = true;
							InputManager.actionobject = bound.getObj();
						} 
//							else if (bound.getTag() == Tag.BORDER) {
//							if (player.upkey) {
//								StartController controller;
//								try {
//									controller = new StartController((int) player.getX(), 460);
//									Handler.changeScene(controller);
//
//								} catch (FileNotFoundException e) {
//									e.printStackTrace();
//								}
//							}
//						}
						lake.animate(elapsedTime, .9);
						Handler.tick();
						render(gc);
						return;
					}
					lake.animate(elapsedTime, .9);
					InputManager.intersecting = false;
				}
				player.setX(player.getNextX());
				player.setY(player.getNextY());

				lake.animate(elapsedTime, .9);
				Handler.tick();
				render(gc);
			}
		}.start();
	}
	
	
	@Override
	public void enter() {
		gc.drawImage(sceneImage, startX, startY);
		Handler.tick();
		render(gc);
	}
	@Override
	public ObservableList<Boundary> objectBoundaries() {
		ObservableList<Boundary> bounds = FXCollections.observableArrayList();
		Boundary minx = new Boundary(Base.LOCX, Base.LOCY, 768, 0);
		minx.setTag(Tag.BORDER);
		Boundary miny = new Boundary(Base.LOCX, Base.LOCY, 0, 512);
		miny.setTag(Tag.BORDER);
		Boundary maxx = new Boundary(Base.LOCX, Base.LOCY + 512, 768, 0);
		maxx.setTag(Tag.BORDER);
		Boundary maxy = new Boundary(Base.LOCX + 768, Base.LOCY, 0, 512);
		maxy.setTag(Tag.BORDER);
		for (GameObject temp : objectlist) {
			if (temp.getId() == ID.COLLIDABLE || temp.getId() == ID.ITEM || temp.getId() == ID.NPC) {
				Boundary b = temp.getBoundary();
				b.setObj(temp);
				b.setId(temp.getId());
				b.setTag(temp.getTag());
				bounds.add(b);
			}
		}
		bounds.add(minx);
		bounds.add(miny);
		bounds.add(maxx);
		bounds.add(maxy);
//		bounds.addAll(createExitList());
		return bounds;
	}
	@Override
	public ArrayList<Boundary> createExitList() {
		ArrayList<Boundary> list = new ArrayList<>();
		Boundary minx = new Boundary(Base.LOCX, Base.LOCY, 768, 0, "north");
		minx.setTag(Tag.BORDER);
		Boundary miny = new Boundary(Base.LOCX, Base.LOCY, 0, 512, "west");
		miny.setTag(Tag.BORDER);
//		Boundary maxx = new Boundary(Base.LOCX, Base.LOCY + 512, 768, 0, "south");
//		maxx.setTag(Tag.BORDER);
		Boundary maxy = new Boundary(Base.LOCX + 768, Base.LOCY, 0, 512, "east");
		maxy.setTag(Tag.BORDER);
//		list.add(door);
		list.add(minx);
		list.add(miny);
//		list.add(maxx);
		list.add(maxy);
		return list;
	}
	@Override
	public void render(GraphicsContext gc) {
		for (GameObject temp : objectlist) {
			temp.render(gc);
		}	
	}

	public void animate(double time, double duration) {
		int index = (int) ((time % (sceneFrames.length * duration)) / duration);
		this.sceneImage = sceneFrames[index];
	}
	
	/**
	 * @return the objectlist
	 */
	public ObservableList<GameObject> getObjectlist() {
		return objectlist;
	}

	/**
	 * @param objectlist the objectlist to set
	 */
	public void setObjectlist(ObservableList<GameObject> objectlist) {
		this.objectlist = objectlist;
	}


	@Override
	public void awake() {
		// TODO Auto-generated method stub
		
	}

}
