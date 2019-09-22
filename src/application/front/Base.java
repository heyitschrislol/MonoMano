package application.front;

import java.util.ArrayList;

import application.back.AssetManager;
import application.back.enums.ID;
import application.back.enums.Tag;
import application.front.objects.EnvironmentObject;
import application.front.objects.GameObject;
import application.front.objects.PlayerObject;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

public class Base extends Application {
	public static final int WIDTH = 512;
	public static final int HEIGHT = 512;
	public static double elapsedTime;
	public final long startNanoTime = System.nanoTime();
	@SuppressWarnings("exports")
	public PlayerObject player;
	public static ObservableList<GameObject> objectlist = FXCollections.observableArrayList();

	private Scene scene;
	private Handler handler;

	@Override
	public void start(Stage primaryStage) {
		try {
			/*
			 * set up stage, scene, and pane.
			 */
			primaryStage.setTitle("Mono Mano");
			Group root = new Group();
			scene = new Scene(root);
			primaryStage.setScene(scene);

			/*
			 * set up the canvas and graphics context for drawing things on.
			 */
			Canvas canvas = new Canvas(512, 512);
			root.getChildren().add(canvas);
			GraphicsContext gc = canvas.getGraphicsContext2D();

			/*
			 * set up world and world objects including the player.
			 */
			Image grass = new Image(AssetManager.GRASS);
			Image top = new Image(AssetManager.TREETOP);
			Image trunk = new Image(AssetManager.TREETRUNK);
			Image dtree = new Image(AssetManager.DRIEDTREE);
			Image newsign = new Image(AssetManager.SIGN);
			player = new PlayerObject(224, 224, 64, 64, ID.PLAYER);
			EnvironmentObject treetop = new EnvironmentObject(327, 105, 64, 112, ID.ENVIRONMENT);
			EnvironmentObject treetrunk = new EnvironmentObject(350, 215, 21, 17, ID.COLLIDABLE);
			EnvironmentObject treetop2 = new EnvironmentObject(97, 190, 64, 112, ID.ENVIRONMENT);
			EnvironmentObject treetrunk2 = new EnvironmentObject(120, 300, 21, 17, ID.COLLIDABLE);			
			EnvironmentObject sign = new EnvironmentObject(200, 50, 19, 22, ID.COLLIDABLE);			
			treetop.setImage(top);
			treetrunk.setImage(trunk);
			treetop2.setImage(top);
			treetrunk2.setImage(trunk);
			sign.setImage(newsign);
//			sign.addTag(Tag.SIGN);
			player.setFrames(AssetManager.returnDown());
			player.setImage(AssetManager.findIdle("DOWN"));
			objectlist.add(player);
			objectlist.add(treetop);
			objectlist.add(treetrunk);
			objectlist.add(treetop2);
			objectlist.add(treetrunk2);
			objectlist.add(sign);
//			Rectangle2D mytree = tree1.getBoundary();
//			double maxx = mytree.getMinX() + mytree.getWidth();
//			double maxy = mytree.getMinY() + mytree.getHeight();

			/*
			 * instantiate and activate custom classes, methods, and variables.
			 */

			handler = new Handler(objectlist);
			InputManager manager = new InputManager(handler);
			scene.setOnKeyPressed(e -> {
				manager.keyPress(e);
			});
			scene.setOnKeyReleased(e -> {
				manager.keyRelease(e);
			});

			new AnimationTimer() {
				public void handle(long currentNanoTime) {

					elapsedTime = (currentNanoTime - startNanoTime) / 1000000000.0;
					
					gc.clearRect(0, 0, 512, 512);
					gc.drawImage(grass, 0, 0);

					player.setNextX(player.getX());
					player.setNextY(player.getY());
					if (player.downkey) {
						player.setFrames(AssetManager.returnDown());
						player.animate(Base.elapsedTime, 0.150);
						player.setNextY(player.getNextY() + 5);
					}
					if (player.upkey) {
						player.setFrames(AssetManager.returnUp());
						player.animate(Base.elapsedTime, 0.150);
						player.setNextY(player.getNextY() - 5);
					}
					if (player.leftkey) {
						player.setFrames(AssetManager.returnLeft());
						player.animate(Base.elapsedTime, 0.100);
						player.setNextX(player.getNextX() - 5);
					}
					if (player.rightkey) {
						player.setFrames(AssetManager.returnRight());
						player.animate(Base.elapsedTime, 0.100);
						player.setNextX(player.getNextX() + 5);
					}
					for (Rectangle2D bound : handler.objectBoundaries()) {
						if (bound.intersects(player.getNextX() + 4, player.getNextY() + 25, 64, 34)) {
							handler.tick();
							handler.render(gc);
							return;
						}
					}
					player.setX(player.getNextX());
					player.setY(player.getNextY());

					handler.tick();
					handler.render(gc);
				}
			}.start();

			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * VERSION 1:
	 * 
	 * Prevents the player from moving beyond the edges of the screen.
	 * 
	 * @param clamp the method used to keep the player inside the window viewport.
	 */
	public static double clamp(double var, double min, double max) {
		if (var >= max) {
			return var = max;
		} else if (var <= min) {
			return var = min;
		} else
			return var;
	}
	public static double[] collider(double x, double y, GameObject temp) {
		double[] xy = new double[2];
		if (x >= temp.getMaxX()) {
			xy[0] = temp.getMaxX();
		} else if (x <= temp.getX()) {
			xy[0] = temp.getX();
		} else {
			xy[0] = x;
		}
		if (y >= temp.getMaxY()) {
			xy[1] = temp.getMaxY();
		} else if (y <= temp.getY()) {
			xy[1] = temp.getY();
		} else {
			xy[1] = y;
		}
		
		return xy;
	}

	public PlayerObject getPlayer() {
		return player;
	}

	public void setPlayer(PlayerObject player) {
		this.player = player;
	}

	/**
	 * @return the objectlist
	 */
	public ObservableList<GameObject> getObjectlist() {
		return objectlist;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
