package application.front;

import java.util.ArrayList;

import application.back.AssetManager;
import application.back.enums.ID;
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
	public ObservableList<GameObject> objectlist = FXCollections.observableArrayList();

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
			Image newtree = new Image(AssetManager.TREE_1);
			player = new PlayerObject(224, 224, 64, 64, ID.PLAYER);
			EnvironmentObject tree1 = new EnvironmentObject(372, 250, 64, 128, ID.ENVIRONMENT);
			EnvironmentObject tree2 = new EnvironmentObject(120, 100, 64, 128, ID.ENVIRONMENT);
			tree1.setImage(newtree);
			tree2.setImage(newtree);
			player.setFrames(AssetManager.returnDown());
			player.setImage(AssetManager.findIdle("DOWN"));
			objectlist.add(player);
			objectlist.add(tree1);
			objectlist.add(tree2);
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

					if (InputManager.input.contains("DOWN")) {
						player.setFrames(AssetManager.returnDown());
						player.animate(Base.elapsedTime, 0.250);
						if (player.intersects()) {
							if (InputManager.inputsnag.isEmpty()) {
								InputManager.deactivateMove("DOWN");
							} else if (InputManager.inputsnag.contains("DOWN")) {
								player.setVelY(-5);
							} else {
								if (player.getY() < tree1.getMaxY() || player.getMaxY() > tree1.getY()) {
									player.setVelY(5);
								}
							}
						} else {
							player.setVelY(5);
							InputManager.activateMove("DOWN");
						}
					} else if (InputManager.input.contains("UP")) {
						player.setFrames(AssetManager.returnUp());
						player.animate(Base.elapsedTime, 0.250);
						if (player.intersects()) {
							if (InputManager.inputsnag.isEmpty()) {
								InputManager.deactivateMove("UP");
							} else if (InputManager.inputsnag.contains("UP")) {
								player.setVelY(5);
							} else {
								if (player.getY() > tree1.getMaxY() || player.getMaxY() < tree1.getY()) {
									player.setVelY(-5);
								}
							}

						} else {
							player.setVelY(-5);
							InputManager.activateMove("UP");
						}
					} else if (InputManager.input.contains("LEFT")) {
						player.setFrames(AssetManager.returnLeft());
						player.animate(Base.elapsedTime, 0.100);
						if (player.intersects()) {
							if (InputManager.inputsnag.isEmpty()) {
								InputManager.deactivateMove("LEFT");
							} else if (InputManager.inputsnag.contains("LEFT")) {
								player.setVelX(5);
							} else {
								if (player.getX() < tree1.getMaxX() || player.getMaxX() > tree1.getX()) {
									player.setVelX(-5);
								}
							}
						} else {
							player.setVelX(-5);
							InputManager.activateMove("LEFT");
						}
					} else if (InputManager.input.contains("RIGHT")) {
						player.setFrames(AssetManager.returnRight());
						player.animate(Base.elapsedTime, 0.100);
						if (player.intersects()) {
							if (InputManager.inputsnag.isEmpty()) {
								InputManager.deactivateMove("RIGHT");
							} else if (InputManager.inputsnag.contains("RIGHT")) {
								player.setVelX(-5);
							} else {
								if (player.getX() > tree1.getMaxX() || player.getMaxX() < tree1.getX()) {
									player.setVelX(5);
								}
							}
						} else {
							player.setVelX(5);
							InputManager.activateMove("RIGHT");
						}
					}

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

	/**
	 * @param objectlist the objectlist to set
	 */
	public void setObjectlist(ObservableList<GameObject> objectlist) {
		this.objectlist = objectlist;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
