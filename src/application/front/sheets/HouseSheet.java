package application.front.sheets;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
		
		portals = FXCollections.observableMap(createExitMap());
		
		player = new PlayerObject(startX, startY, 64, 64, ID.PLAYER);

		canvas = new Canvas(768, 512);
		gc = canvas.getGraphicsContext2D();


        getChildren().add(canvas);
       
        
        sceneImage = new Image(AssetManager.STONEFLOOR);
        
        Image crate1 = new Image(AssetManager.SMCRATE);
        Image crate2 = new Image(AssetManager.LGCRATE);
        
        EnvironmentObject crateSM = new EnvironmentObject(100, 100, 32, 37, crate1, ID.COLLIDABLE, Tag.CRATE);
        EnvironmentObject crateLG = new EnvironmentObject(100, 100, 42, 47, crate2, ID.COLLIDABLE, Tag.CRATE);
        

        crateSM.setObjecttext("This crate appears to be full of peanut butter...");
        crateLG.setObjecttext("It looks like a small animal was kept in here...");
        objectlist.add(player);
        objectlist.add(crateSM);
        objectlist.add(crateLG);
        
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
				Boundary bounderee = new Boundary(244, 510, 64, 10);
				if (player.intersects(bounderee)) {
					try {
						StartController controller = new StartController();
						Base.changeScene(controller);
						this.stop();

					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				}
				for (Boundary bound : Handler.objectBoundaries()) {
					if (bound.intersects(player.getNextX(), player.getNextY() + 15, 64, 34)) {
						if (bound.getTag() != Tag.BORDER) {
							InputManager.intersecting = true;
							InputManager.actionobject = bound.getObj();
						}
						Handler.tick();
						Handler.render(gc);
						return;
					}
					InputManager.intersecting = false;
				}
				player.setX(player.getNextX());
				player.setY(player.getNextY());

				Handler.tick();
				Handler.render(gc);
			}
		}.start();
	}
	
	
	@Override
	public void enter() {
		gc.drawImage(sceneImage, startX, startY);
		Handler.tick();
		Handler.render(gc);
	}
	@Override
	public Sheet exitSheet(Boundary bound) {
		return null;
	}
	@Override
	public Map<String, Boundary> createExitMap() {
		HashMap<String, Boundary> map = new HashMap<>();
		
		return map;
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
