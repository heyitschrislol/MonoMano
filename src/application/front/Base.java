package application.front;

import java.util.ArrayList;

import application.back.AssetManager;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;

public class Base extends Application {
	private Scene scene;
	private ArrayList<String> input;
	private String lastInput;
	private int x, y;
	private int velX, velY;

	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Mono Mano");

			Group root = new Group();
			scene = new Scene(root);
			primaryStage.setScene(scene);

			input = new ArrayList<String>();
			lastInput = "DOWN";
			final long startNanoTime = System.nanoTime();

			Canvas canvas = new Canvas(512, 512);
			root.getChildren().add(canvas);
			GraphicsContext gc = canvas.getGraphicsContext2D();

			keyPress();
			keyRelease();

			ObjectAnimation anims = new ObjectAnimation();
			Image grass = new Image(AssetManager.GRASS);
			Player player = new Player(224, 224);
//			Image idledown = new Image(AssetManager.PLAYER_0);
//			Image[] walkdown = AssetManager.returnDown();
//			Image idleup = new Image(AssetManager.PLAYER_3);
//			Image[] walkup = AssetManager.returnUp();
//			Image idleleft = new Image(AssetManager.PLAYER_6);
//			Image[] walkleft = AssetManager.returnLeft();
//			Image idleright = new Image(AssetManager.PLAYER_9);
//			Image[] walkright = AssetManager.returnRight();
			anims.frames = player.getWalkdown();
			anims.duration = 0.300;

			new AnimationTimer() {
				public void handle(long currentNanoTime) {

					double t = (currentNanoTime - startNanoTime) / 1000000000.0;

					gc.clearRect(0, 0, 512, 512);
					gc.drawImage(grass, 0, 0);
					if (input.contains("DOWN")) {
						lastInput = "DOWN";
						velY = 5;
						y += velY;
						anims.frames = player.getWalkdown();
						anims.duration = 0.300;
						gc.drawImage(anims.getFrame(t), x, y);
					} else if (input.contains("UP")) {
						lastInput = "UP";
						velY = -5;
						y += velY;
						anims.frames = player.getWalkup();
						anims.duration = 0.300;
						gc.drawImage(anims.getFrame(t), x, y);
					} else if (input.contains("RIGHT")) {
						lastInput = "RIGHT";
						velX = 5;
						x += velX;
						anims.frames = player.getWalkright();
						anims.duration = 0.300;
						gc.drawImage(anims.getFrame(t), x, y);
					} else if (input.contains("LEFT")) {
						lastInput = "LEFT";
						velX = -5;
						x += velX;
						anims.frames = player.getWalkleft();
						anims.duration = 0.300;
						gc.drawImage(anims.getFrame(t), x, y);
					} else {
						velX = 0;
						velY = 0;
						gc.drawImage(AssetManager.findIdle(lastInput), x, y);
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

	public static void main(String[] args) {
		launch(args);
	}
}
