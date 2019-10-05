package application.front.sheets;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import application.back.*;
import application.back.enums.Asset;
import application.back.enums.ID;
import application.back.enums.Location;
import application.back.enums.Tag;
import application.back.managers.Handler;
import application.back.managers.InputManager;
import application.back.managers.SoundManager;
import application.front.Base;
import application.front.controllers.Controller;
import application.front.controllers.HouseController;
import application.front.controllers.LakeController;
import application.front.controllers.StartController;
import application.front.objects.Boundary;
import application.front.objects.EnvironmentObject;
import application.front.objects.GameObject;
import application.front.objects.PlayerObject;
import javafx.animation.AnimationTimer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class BeginSheet extends Sheet {
	public final long startNanoTime = System.nanoTime();
	public static double elapsedTime = Base.elapsedTime;
	
	public BeginSheet(int startX, int startY) throws FileNotFoundException {
		super(startX, startY);
		this.location = Location.START;
		
		portallist.addAll(createExitList());
		
		if (SoundManager.weird.isPlaying()) {
			SoundManager.weird.stopSong();
			SoundManager.bgins.playSong();

		}
		if (SoundManager.nftsb.isPlaying()) {
			SoundManager.nftsb.stopSong();
			SoundManager.bgins.playSong();
		}
		if (SoundManager.water.isPlaying()) {
			SoundManager.water.stopSong();
			SoundManager.bgins.playSong();
		}
		
		
		player = new PlayerObject(startX, startY, 55, 64, ID.PLAYER);
		PlayerObject.location = Location.START;
		canvas = new Canvas(768, 512);
		gc = canvas.getGraphicsContext2D();
			
        getChildren().add(canvas);
		/*
		 * set up world and world objects including the player.
		 */
		sceneImage = Asset.assetImage("GRASS");
		Image[] SMtrees = Asset.spriteFrames("SMTREES");
		Image[] LGtrees = Asset.spriteFrames("LGTREES");
		Image[] trunks = Asset.spriteFrames("TREETRUNKS");
		
		EnvironmentObject smbot = new EnvironmentObject(325, 178, 21, 17, ID.COLLIDABLE, Tag.TREE);
		EnvironmentObject smtop = new EnvironmentObject(306, 101, 64, 112, ID.ENVIRONMENT);
		EnvironmentObject lgbot = new EnvironmentObject(103, 300, 21, 17, ID.COLLIDABLE, Tag.TREE);	
		EnvironmentObject lgtop = new EnvironmentObject(80, 200, 64, 112, ID.ENVIRONMENT);
		EnvironmentObject bushsm = new EnvironmentObject(517, 12, 27, 21, ID.ENVIRONMENT);
		EnvironmentObject bushlg = new EnvironmentObject(36, 436, 50, 43, ID.ENVIRONMENT);
		EnvironmentObject winopen = new EnvironmentObject(553, 360, 38, 85, ID.COLLIDABLE, Tag.WINDOW);
		EnvironmentObject winclosed = new EnvironmentObject(684, 360, 32, 85, ID.COLLIDABLE, Tag.WINDOW);
		EnvironmentObject sign = new EnvironmentObject(200, 40, 40, 50, ID.COLLIDABLE,Tag.SIGN);
		EnvironmentObject house = new EnvironmentObject(512, -60, 248, 498, ID.COLLIDABLE, Tag.HOUSE);
		EnvironmentObject door = new EnvironmentObject(607, 382, 58, 58, ID.COLLIDABLE, Tag.DOOR);

		sign.setObjecttext("Sign: 'U suck haha'");
		winopen.setObjecttext("There's a naked man inside... it looks like he's practicing thrusting his pelvis...");
		winclosed.setObjecttext("The window is closed. You can only see window.");
		bushsm.setImage(Asset.assetImage("SMBUSH"));
		bushlg.setImage(Asset.assetImage("LGBUSH"));
		winopen.setImage(Asset.assetImage("WINOPEN"));
		winopen.setSound("boodaboo");
		winclosed.setImage(Asset.assetImage("WINCLOSED"));
		winclosed.setSound("boodaboo");
		smtop.setImage(SMtrees[1]);
		smbot.setImage(trunks[0]);
		lgtop.setImage(LGtrees[1]);
		lgbot.setImage(trunks[1]);
		sign.setImage(Asset.assetImage("SIGN", 50, 50, true, true));
		sign.setSound("boodaboo");
		house.setImage(Asset.assetImage("BLANKHOUSE"));
		door.setImage(Asset.assetImage("DOOR"));
		ArrayList<String> footsteps = new ArrayList<>();
		footsteps.add("grasstep1");
		footsteps.add("grasstep2");
		footsteps.add("grasstep3");
		footsteps.add("grasstep6");
		door.setSound("doorclick");
		player.setFrames(Asset.returnDown());
		player.setImage(Asset.findIdle("DOWN"));
		player.footsteps = footsteps;
		objectlist.add(player);
		objectlist.add(smtop);
		objectlist.add(smbot);
		objectlist.add(lgtop);
		objectlist.add(lgbot);
		objectlist.add(sign);
		objectlist.add(house);
		objectlist.add(door);
		objectlist.add(bushlg);
		objectlist.add(bushsm);
		objectlist.add(winopen);
		objectlist.add(winclosed);

		for (GameObject go : objectlist) {
			if (go.getTag() == Tag.TREE) {
				go.setObjecttext("It's a tree, idiot");
			}
		}
		
		
		Handler.setObjectlist(objectlist);
		
		new AnimationTimer() {
			public void handle(long currentNanoTime) {
				int i = 0;
				int j = 0;
				
				elapsedTime = (currentNanoTime - startNanoTime) / 1000000000.0;
				
				gc.clearRect(0, 0, 768, 512);
				gc.drawImage(sceneImage, 0, 0);

				player.setNextX(player.getX());
				player.setNextY(player.getY());
				if (player.downkey) {
					player.setFrames(Asset.returnDown());
					player.animate(elapsedTime, 0.100);
					player.setNextY(player.getNextY() + 5);
				}
				if (player.upkey) {
					player.setFrames(Asset.returnUp());
					player.animate(elapsedTime, 0.100);
					player.setNextY(player.getNextY() - 5);
				}
				if (player.leftkey) {
					player.setFrames(Asset.returnLeft());
					player.animate(elapsedTime, 0.100);
					player.setNextX(player.getNextX() - 5);
				}
				if (player.rightkey) {
					player.setFrames(Asset.returnRight());
					player.animate(elapsedTime, 0.100);
					player.setNextX(player.getNextX() + 5);
				}
				if (player.intersects(door) && player.upkey) {
					try {
						if (!door.getSound().isBlank()) {
							SoundManager.playClip(door.getSound());
						}
						
						HouseController controller = new HouseController(352, 440);
						Handler.changeScene(controller);
						this.stop();
						gc.clearRect(0, 0, 768, 512);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				}
				for (Boundary b : createExitList()) {
					if (player.intersects(b) && b.getLabel().equals("south") && player.downkey) {
						try {
							LakeController controller = new LakeController((int) player.getX(), 60);
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
						
						Handler.tick();
						render(gc);
						return;
					} 
					InputManager.intersecting = false;
				}
				player.setX(player.getNextX());
				player.setY(player.getNextY());

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
		Boundary maxx = new Boundary(Base.LOCX, Base.LOCY + 512, 768, 0, "south");
		maxx.setTag(Tag.BORDER);
		Boundary maxy = new Boundary(Base.LOCX + 768, Base.LOCY, 0, 512, "east");
		maxy.setTag(Tag.BORDER);
//		list.add(door);
		list.add(minx);
		list.add(miny);
		list.add(maxx);
		list.add(maxy);
		return list;
	}
	@Override
	public void render(GraphicsContext gc) {
		for (GameObject temp : objectlist) {
			temp.render(gc);
		}	
	}

	@Override
	public void awake() {
		// TODO Auto-generated method stub
		
	}

}
