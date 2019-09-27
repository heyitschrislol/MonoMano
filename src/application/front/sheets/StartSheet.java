package application.front.sheets;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import application.back.*;
import application.back.enums.ID;
import application.back.enums.Tag;
import application.front.Base;
import application.front.objects.EnvironmentObject;
import application.front.objects.GameObject;
import application.front.objects.PlayerObject;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class StartSheet extends Sheet {
	public final long startNanoTime = System.nanoTime();
	public static double elapsedTime = Base.elapsedTime;
	
	public StartSheet(int startX, int startY) throws FileNotFoundException {
		super(startX, startY);
		player = new PlayerObject(startX, startY, 64, 64, ID.PLAYER);

		canvas = new Canvas(768, 512);
		gc = canvas.getGraphicsContext2D();
		
        getChildren().add(canvas);
		/*
		 * set up world and world objects including the player.
		 */
		sceneImage = new Image(AssetManager.GRASS);
		player = new PlayerObject(352, 224, 64, 64, ID.PLAYER);

		
		Image[][] cutscenes = AssetManager.makeScene(sceneImage, 768, 512);
		Image houseBLK = new Image(AssetManager.HOUSENODOOR);
		Image doorOP = new Image(AssetManager.DOOR);
		Image topSM = new Image(AssetManager.SMTREETOP);
		Image trunkSM = new Image(AssetManager.SMTREETRUNK);
		Image topLG = new Image(AssetManager.LGTREETOP);
		Image trunkLG = new Image(AssetManager.LGTREETRUNK);
		Image newsign = new Image(AssetManager.SIGN, 50, 50, true, true);
		EnvironmentObject smbot = new EnvironmentObject(325, 178, 21, 17, ID.COLLIDABLE, Tag.TREE);
		EnvironmentObject smtop = new EnvironmentObject(306, 101, 64, 112, ID.ENVIRONMENT);
		EnvironmentObject lgbot = new EnvironmentObject(103, 300, 21, 17, ID.COLLIDABLE, Tag.TREE);	
		EnvironmentObject lgtop = new EnvironmentObject(80, 200, 64, 112, ID.ENVIRONMENT);
		EnvironmentObject sign = new EnvironmentObject(200, 50, 50, 50, ID.COLLIDABLE,Tag.SIGN);
		EnvironmentObject house = new EnvironmentObject(512, -60, 248, 498, ID.COLLIDABLE, Tag.HOUSE);
		EnvironmentObject door = new EnvironmentObject(607, 384, 58, 58, ID.COLLIDABLE, Tag.DOOR);

		sign.setObjecttext("Sign: 'U suck haha'");
		door.setObjecttext("Someone's spreading peanut butter on their pee pee... better not go in...");
		smtop.setImage(topSM);
		smbot.setImage(trunkSM);
		lgtop.setImage(topLG);
		lgbot.setImage(trunkLG);
		sign.setImage(newsign);
		house.setImage(houseBLK);
		door.setImage(doorOP);
		player.setFrames(AssetManager.returnDown());
		player.setImage(AssetManager.findIdle("DOWN"));
		objectlist.add(player);
		objectlist.add(smtop);
		objectlist.add(smbot);
		objectlist.add(lgtop);
		objectlist.add(lgbot);
		objectlist.add(sign);
		objectlist.add(house);
		objectlist.add(door);

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
				if (player.intersects(door)) {
					try {
						HouseController controller = new HouseController();
						Base.changeScene(controller);
						this.stop();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
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
		// TODO Auto-generated method stub
		return null;
	}

}
