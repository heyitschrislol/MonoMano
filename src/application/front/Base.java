package application.front;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;

import application.back.enums.ID;
import application.back.enums.Tag;
import application.back.managers.AssetManager;
import application.back.managers.AudioManager;
import application.back.managers.Handler;
import application.back.managers.InputManager;
import application.front.controllers.Controller;
import application.front.controllers.HouseController;
import application.front.controllers.StartController;
import application.front.objects.Boundary;
import application.front.objects.EnvironmentObject;
import application.front.objects.GameObject;
import application.front.objects.PlayerObject;
import application.front.sheets.HouseSheet;
import application.front.sheets.Sheet;
import application.front.sheets.StartSheet;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
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
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
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
	public Image sceneImage;
	
	public static Stage primaryStage;
	public static Scene scene;
	private Scene scene2;
	private Sheet sheet;
	private StartSheet start;
	private Group root;
	private Group root2;
	private Canvas canvas;
	private static Canvas overlay;
	private static GraphicsContext ogc;
	private GraphicsContext ngc;
	private Handler handler;
	public static InputManager manager;
	public static AudioManager audiomanager;
	public static Font regfont;
	public static Font boldfont;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			Base.primaryStage = primaryStage;
			
			overlay = new Canvas(768, 512);
			ogc = overlay.getGraphicsContext2D();
	        
			regfont = Font.loadFont(new FileInputStream(new File("src/application/resources/fonts/AmaticSC-Regular.ttf")), 40);
	        boldfont = Font.loadFont(new FileInputStream(new File("src/application/resources/fonts/AmaticSC-Bold.ttf")), 44);
			
	        ogc.setFont(regfont);
	        primaryStage.setTitle("Mono Mano");
						
			StartController starter = new StartController(352, 244);
			changeScene(starter);
			

			/*
			 * instantiate and activate custom classes, methods, and variables.
			 */

			handler = new Handler(starter.sheet.getObjectlist());

			audiomanager = new AudioManager(3);
			audiomanager.loadBGMusic("Bgins", "Bgins.wav");
			audiomanager.loadBGMusic("NFTSB", "Nothing For the Swim Back.wav");
			audiomanager.loadSoundEffects("grunt", "Male grunt.wav");
			audiomanager.loadSoundEffects("wah", "wachhg.mp3");
			audiomanager.loadSoundEffects("pendrop", "pendrop.mp3");
			audiomanager.loadSoundEffects("mailshake", "shakymail.mp3");
			audiomanager.loadSoundEffects("milkshake", "milkshake.mp3");
			audiomanager.loadSoundEffects("heeya", "Hee-ya.mp3");
			
			audiomanager.playMusic("Bgins");
			primaryStage.setOnCloseRequest(e -> {
				AudioManager.soundPool.shutdown();
			});
//			AudioManager.changeMusic("/application/assets/Bgins.wav");
			primaryStage.setResizable(false);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void playMusic(final String id) {
    	audiomanager.playMusic(id);
	}
	public static void showPopup(GameObject eo) {
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
	        int xlet = 150;
	        int ylet = 356;
	        
	        String[] lines = new String[] { "", "", "", "" };
	        String[]words = eo.getObjecttext().split(" ");
	        for (String word : words) {
	        	 linect += word.length();
	        	 if (linect < 35) {
		        	 lines[index] = lines[index].concat(" " + word);
	        	 } else {
	        		 index++;
	        		 linect = 0;
		        	 lines[index] = lines[index].concat(" " + word);
	        	 }
	        }
	        boolean isfirst = true;
	        for (int i = 0; i < lines.length; i++) {
	        	if (!lines[i].isBlank()) {
	        		if (isfirst && !eo.getName().isBlank()) {
	        			ogc.setFont(boldfont);
	        			ogc.fillText(eo.getName() + ":", xlet, ylet);
		        		ylet += 35; 
		        		ogc.setFont(regfont);
	        			ogc.fillText(lines[i], xlet, ylet);
		        		ylet += 35; 
		        		isfirst = false;
	        		} else {
	        			ogc.fillText(lines[i], xlet, ylet);
		        		ylet += 35;
	        		}
	        		
	        	}
	        }
	       
		}
	}
	public static void clearPopup() {
		ogc.clearRect(0, 0, 768, 512);
	}

	public static void changeScene(Controller controller) throws FileNotFoundException {
		Sheet sheet = controller.getSheet();
		sheet.getChildren().add(overlay);
		sheet.player.render(sheet.gc);
		
		Handler.setObjectlist(sheet.getObjectlist());
		Handler.render(sheet.gc);
		Scene scene = controller.getScene();
		scene.setRoot(sheet);
		primaryStage.setScene(scene);
	}
	
	public static AudioClip startMusic() {
		AudioClip music = new AudioClip("src/application/assets/Bgins.wav");
        music.setVolume(0.5f);
        music.setCycleCount(1000);
        music.play();
        return null;
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

	/**
	 * @return the handler
	 */
	public Handler getHandler() {
		return handler;
	}
	/**
	 * @param handler the handler to set
	 */
	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	/**
	 * @return the manager
	 */
	public InputManager getManager() {
		return manager;
	}
	/**
	 * @param manager the manager to set
	 */
	public void setManager(InputManager manager) {
		this.manager = manager;
	}
	public static void main(String[] args) {
		launch(args);
	}
	
	
	/*
	 * VERSION 1:
	 * 
	 * Prevents the player from moving beyond the edges of the screen.
	 * 
	 * @param clamp the method used to keep the player inside the window viewport.
	 */
//	public static double clamp(double var, double min, double max) {
//		if (var >= max) {
//			return var = max;
//		} else if (var <= min) {
//			return var = min;
//		} else
//			return var;
//	}
}
