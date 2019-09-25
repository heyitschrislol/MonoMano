package application.front;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import application.back.AssetManager;
import application.back.Boundary;
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
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Base extends Application {
	public static final int WIDTH = 768;
	public static final int HEIGHT = 512;
	public static int LOCX;
	public static int LOCY;
	public static double elapsedTime;
	public final long startNanoTime = System.nanoTime();
	@SuppressWarnings("exports")
	public static PlayerObject player;
	public static ObservableList<GameObject> objectlist = FXCollections.observableArrayList();

	private Scene scene;
	private Group root;
	private Canvas overlay;
	private static GraphicsContext ogc;
	private Handler handler;

	@Override
	public void start(Stage primaryStage) {
		try {
			/*
			 * set up stage, scene, and pane.
			 */
			primaryStage.setTitle("Mono Mano");
			root = new Group();
			scene = new Scene(root);
			primaryStage.setScene(scene);

			/*
			 * set up the canvas and graphics context for drawing things on.
			 */
			Canvas canvas = new Canvas(768, 512);
			overlay = new Canvas(768, 512);
			root.getChildren().add(canvas);
			root.getChildren().add(overlay);
			GraphicsContext gc = canvas.getGraphicsContext2D();
			ogc = overlay.getGraphicsContext2D();
	        ogc.setFont(Font.loadFont(new FileInputStream(new File("src/application/resources/fonts/AmaticSC-Bold.ttf")), 40));



			/*
			 * set up world and world objects including the player.
			 */
			Image world = new Image(AssetManager.GRASS);
			
			Image[][] cutscenes = AssetManager.makeScene(world, 768, 512);
			Image houseBLK = new Image(AssetManager.HOUSENODOOR);
			Image doorOP = new Image(AssetManager.DOOR);
			Image topSM = new Image(AssetManager.SMTREETOP);
			Image trunkSM = new Image(AssetManager.SMTREETRUNK);
			Image topLG = new Image(AssetManager.LGTREETOP);
			Image trunkLG = new Image(AssetManager.LGTREETRUNK);
			Image newsign = new Image(AssetManager.SIGN, 50, 50, true, true);
			player = new PlayerObject(224, 224, 64, 64, ID.PLAYER);
			EnvironmentObject smbot = new EnvironmentObject(325, 178, 21, 17, ID.COLLIDABLE, Tag.TREE);
			EnvironmentObject smtop = new EnvironmentObject(306, 101, 64, 112, ID.ENVIRONMENT);
			EnvironmentObject lgbot = new EnvironmentObject(103, 300, 21, 17, ID.COLLIDABLE, Tag.TREE);	
			EnvironmentObject lgtop = new EnvironmentObject(80, 200, 64, 112, ID.ENVIRONMENT);
			EnvironmentObject sign = new EnvironmentObject(200, 50, 50, 50, ID.COLLIDABLE,Tag.SIGN);
			EnvironmentObject house = new EnvironmentObject(512, -60, 248, 498, ID.COLLIDABLE, Tag.HOUSE);
			EnvironmentObject door = new EnvironmentObject(607, 382, 58, 58, ID.COLLIDABLE, Tag.DOOR);

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
//			Rectangle2D mytree = tree1.getBoundary();
//			double maxx = mytree.getMinX() + mytree.getWidth();
//			double maxy = mytree.getMinY() + mytree.getHeight();
			for (GameObject go : objectlist) {
				if (go.getTag() == Tag.TREE) {
					go.setObjecttext("It's a tree, idiot");
				}
			}

			/*
			 * instantiate and activate custom classes, methods, and variables.
			 */

			handler = new Handler(objectlist);
			InputManager manager = new InputManager(handler, gc);
			scene.setOnKeyPressed(e -> {
				manager.keyPress(e);
			});
			scene.setOnKeyReleased(e -> {
				manager.keyRelease(e);
			});
//			scene.setOnKeyPressed(e -> {
//				manager.actionKey(e);
//			});

			new AnimationTimer() {
				public void handle(long currentNanoTime) {
					int i = 0;
					int j = 0;
					Image startimage;
					elapsedTime = (currentNanoTime - startNanoTime) / 1000000000.0;
					startimage = cutscenes[i][j];
					gc.clearRect(0, 0, 768, 512);
					gc.drawImage(startimage, LOCX, LOCY);

					player.setNextX(player.getX());
					player.setNextY(player.getY());
					if (player.downkey) {
						player.setFrames(AssetManager.returnDown());
						player.animate(Base.elapsedTime, 0.100);
						player.setNextY(player.getNextY() + 5);
					}
					if (player.upkey) {
						player.setFrames(AssetManager.returnUp());
						player.animate(Base.elapsedTime, 0.100);
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
					for (Boundary bound : handler.objectBoundaries()) {
						if (bound.intersects(player.getNextX(), player.getNextY() + 15, 64, 34)) {
							if (bound.getTag() != Tag.BORDER) {
								manager.intersecting = true;
								manager.actionobject = bound.getObj();
//								manager.popup(ogc, (EnvironmentObject) bound.getObj());
							}
							handler.tick();
							handler.render(gc);
							return;
						}
						manager.intersecting = false;
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
	public static void showPopup(EnvironmentObject eo) {
		if (!eo.getObjecttext().isBlank()) {
			ogc.setStroke(Color.BROWN);
			ogc.setLineWidth(4);
			ogc.strokeRoundRect(134, 302, 500, 200, 10, 10);
	        // Draw a filled rounded Rectangle
			ogc.setFill(Color.ANTIQUEWHITE);
	        ogc.fillRoundRect(138, 306, 494, 194, 10, 10);
	        ogc.setFill(Color.BLACK);
	        int index = 0;
	        int linect = 0;
	        int xlet = 160;
	        int ylet = 356;
	        
	        String[] lines = new String[] { "", "", "", "" };
	        String[]words = eo.getObjecttext().split(" ");
	        for (String word : words) {
//	        	 for (char c : word.toCharArray()) {
//	 	        	linect++;
//	        	 }
	        	 linect += word.length();
	        	 if (linect < 35) {
		        	 lines[index] = lines[index].concat(" " + word);
	        	 } else {
	        		 index++;
	        		 linect = 0;
		        	 lines[index] = lines[index].concat(" " + word);
	        	 }
	        }
	        for (int i = 0; i < lines.length; i++) {
	        	if (!lines[i].isBlank()) {
	        		ogc.fillText(lines[i], xlet, ylet);
	        		ylet += 35;
	        	}
	        }
	       
		}
	}
	public static void clearPopup() {
		ogc.clearRect(0, 0, 768, 512);
	}

	public static PlayerObject getPlayer() {
		return player;
	}

	public static void setPlayer(PlayerObject player) {
		Base.player = player;
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
