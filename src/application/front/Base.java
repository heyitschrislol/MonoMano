package application.front;

import java.util.ArrayList;

import application.back.AssetManager;
import application.back.enums.ID;
import application.front.objects.EnvironmentObject;
import application.front.objects.PlayerObject;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
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
	private static ArrayList<String> input;
	private String lastInput;
	private Scene scene;
	
	private Handler handler;
	public static int sceneX = 0;
	public static int sceneY = 0;

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
			 * set up fields and properties initial values.
			 */
			input = new ArrayList<String>();
			lastInput = "DOWN";
			final long startNanoTime = System.nanoTime();

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
			PlayerObject player = new PlayerObject(224, 224);
			EnvironmentObject tree = new EnvironmentObject(372, 250, newtree);
			player.setFrames(AssetManager.returnDown());
			player.setImage(AssetManager.findIdle("DOWN"));
			player.setID(ID.PLAYER);
			tree.setID(ID.ENVIRONMENT);

			/*
			 * instantiate and activate custom classes, methods, and variables.
			 */
			handler = new Handler();
			handler.addObject(player);
			handler.addObject(tree);
			scene.setOnKeyPressed(e -> {
				new InputManager(handler).keyPress(e);
			});
			scene.setOnKeyReleased(e -> {
				new InputManager(handler).keyRelease(e);
			});
			
			
			

			new AnimationTimer() {
				public void handle(long currentNanoTime) {

					double elapsedTime = (currentNanoTime - startNanoTime) / 1000000000.0;

					gc.clearRect(0, 0, 512, 512);
					gc.drawImage(grass, sceneX, sceneY);
					gc.drawImage(tree.getImage(), tree.getX(), tree.getY());
					if (input.contains("DOWN")) {
						lastInput = "DOWN";
						player.setFrames(AssetManager.returnDown());
						player.tick(0, 5, elapsedTime, 0.300);
						player.render(gc);

					} else if (input.contains("UP")) {
						lastInput = "UP";
						player.setFrames(AssetManager.returnUp());
						player.tick(0, -5, elapsedTime, 0.300);
						player.render(gc);

					} else if (input.contains("RIGHT")) {
						lastInput = "RIGHT";
						player.setFrames(AssetManager.returnRight());
						player.tick(5, 0, elapsedTime, 0.100);
						player.render(gc);

					} else if (input.contains("LEFT")) {
						lastInput = "LEFT";
						player.setFrames(AssetManager.returnLeft());
						player.tick(-5, 0, elapsedTime, 0.100);
						player.render(gc);
					} else {
						player.tick(0, 0, elapsedTime, 0.100);
						gc.drawImage(AssetManager.findIdle(lastInput), player.getX(), player.getY());
					}
				}
			}.start();

			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void keyPress() {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent e) {
				String code = e.getCode().toString();

				if (!input.contains(code))
					input.add(code);
			}
		});
	}

	public void keyRelease() {
		scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent e) {
				String code = e.getCode().toString();
				input.remove(code);
			}
		});
	}

	/*
	 * VERSION 1:
	 * 
	 * Prevents the player from moving beyond the edges of the screen.
	 * 
	 * @param clamp the method used to keep the player inside the window viewport.
	 */
//	public static int clamp(int var, int min, int max) {
//		if (var >= max) {
//			if (input.contains("LEFT") || input.contains("RIGHT")) {
//				sceneX += max;
//			} else if (input.contains("UP") || input.contains("DOWN")) {
//				sceneY += max;
//			}
//			return var = min;
//		}
//		else if (var <= min) {
//			if (input.contains("LEFT") || input.contains("RIGHT")) {
//				sceneX -= max;
//			} else if (input.contains("UP") || input.contains("DOWN")) {
//				sceneY -= max;
//			}
//			return var = max;
//		}
//		else
//			return var;
//	}
	/*
	 * VERSION 2:
	 * 
	 * Returns the player to the opposite end of the window upon reaching the edge.
	 * 
	 * @param clamp the method used to keep the player inside the window viewport.
	 */
	public static int clamp(int var, int min, int max) {
		if (var >= max) {
//			if (input.contains("LEFT") || input.contains("RIGHT")) {
//				
//			} else if (input.contains("UP") || input.contains("DOWN")) {
//
//			}
			return var = min;
		}
		else if (var <= min) {
//			if (input.contains("LEFT") || input.contains("RIGHT")) {
//
//			} else if (input.contains("UP") || input.contains("DOWN")) {
//				
//			}
			return var = max;
		}
		else
			return var;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
