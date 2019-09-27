package application.front.sheets;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import application.back.*;
import application.back.enums.*;
import application.back.managers.AssetManager;
import application.back.managers.Handler;
import application.back.managers.InputManager;
import application.front.Base;
import application.front.controllers.StartController;
import application.front.objects.*;
import javafx.animation.AnimationTimer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class HouseSheet extends Sheet {
	public final long startNanoTime = System.nanoTime();
	public static double elapsedTime = Base.elapsedTime;

	public HouseSheet(int startX, int startY) throws FileNotFoundException {
		super(startX, startY);
		
		portallist.addAll(createExitList());
		
		player = new PlayerObject(startX, startY, 64, 64, ID.PLAYER);

		canvas = new Canvas(768, 512);
		gc = canvas.getGraphicsContext2D();


        getChildren().add(canvas);
       
        
        sceneImage = new Image(AssetManager.STONEFLOOR);
        
        Image crate1 = new Image(AssetManager.SMCRATE);
        Image crate2 = new Image(AssetManager.LGCRATE);
        Image door = new Image(AssetManager.INDOOR);
        Image bwall = new Image(AssetManager.BACKWALL);
        Image rwall = new Image(AssetManager.RIGHTWALL);
        Image lwall = new Image(AssetManager.LEFTWALL);
        
        
        EnvironmentObject crateSM = new EnvironmentObject(100, 100, 32, 37, ID.COLLIDABLE, Tag.CRATE);
        EnvironmentObject crateLG = new EnvironmentObject(200, 175, 42, 47, ID.COLLIDABLE, Tag.CRATE);
        EnvironmentObject indoor = new EnvironmentObject(335, 500, 98, 16, ID.COLLIDABLE, Tag.DOOR);
        EnvironmentObject backwall = new EnvironmentObject(0, 0, 768, 64, ID.COLLIDABLE, Tag.BORDER);
        EnvironmentObject leftwall = new EnvironmentObject(0, 64, 16, 448, ID.COLLIDABLE, Tag.BORDER);
        EnvironmentObject rightwall = new EnvironmentObject(752, 64, 16, 448, ID.COLLIDABLE, Tag.DOOR);
        
        crateSM.setImage(crate1);
        crateLG.setImage(crate2);
        indoor.setImage(door);
        backwall.setImage(bwall);
        leftwall.setImage(lwall);
        rightwall.setImage(rwall);
        player.setFrames(AssetManager.returnUp());
		player.setImage(AssetManager.findIdle("UP"));
        crateSM.setObjecttext("This crate is full of empty peanut butter jars...");
        crateLG.setObjecttext("It looks like a small animal was kept in here...");
        objectlist.add(player);
        objectlist.add(crateSM);
        objectlist.add(crateLG);
        objectlist.add(indoor);
        objectlist.add(backwall);
        objectlist.add(leftwall);
        objectlist.add(rightwall);
        
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
					player.setFrames(AssetManager.returnDown());
					player.animate(elapsedTime, 0.100);
					player.setNextY(player.getNextY() + 5);
				}
				if (player.upkey) {
					player.setFrames(AssetManager.returnUp());
					player.animate(elapsedTime, 0.100);
					player.setNextY(player.getNextY() - 5);
				}
				if (player.leftkey) {
					player.setFrames(AssetManager.returnLeft());
					player.animate(elapsedTime, 0.100);
					player.setNextX(player.getNextX() - 5);
				}
				if (player.rightkey) {
					player.setFrames(AssetManager.returnRight());
					player.animate(elapsedTime, 0.100);
					player.setNextX(player.getNextX() + 5);
				}
				if (player.intersects(indoor) && player.downkey) {
					try {
						StartController controller = new StartController(607, 445);
						Base.changeScene(controller);
						this.stop();
						gc.clearRect(0, 0, 768, 512);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
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
			if (temp.getId() == ID.COLLIDABLE || temp.getId() == ID.ITEM) {
				Boundary b = temp.getBoundary();
				b.setObj(temp);
				b.setId(temp.getId());
				b.setTag(temp.getTag());
				bounds.add(b);
			}
		}
//		bounds.add(minx);
//		bounds.add(miny);
//		bounds.add(maxx);
//		bounds.add(maxy);
//		bounds.addAll(createExitList());
		return bounds;
	}
	@Override
	public ArrayList<Boundary> createExitList() {
		ArrayList<Boundary> list = new ArrayList<>();
		Boundary door = new Boundary(352, 490, 60, 11, "door");
		list.add(door);
		return list;
	}
	@Override
	public void render(GraphicsContext gc) {
		for (GameObject temp : objectlist) {
			temp.render(gc);
		}	
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


	

}
