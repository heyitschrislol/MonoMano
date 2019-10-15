package application.front;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

import application.back.managers.Handler;
import application.back.managers.InputManager;
import application.back.managers.SoundManager;
import application.front.controllers.Controller;
import application.front.controllers.StartController;

import application.front.objects.GameObject;
import application.front.objects.PlayerObject;
import application.front.sheets.Sheet;
import application.front.sheets.IntroSheet;
import application.front.sheets.StartSheet;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

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
	private MediaPlayer mp;
	private String id;
	protected ObservableMap<String, Media> musicmap = FXCollections.observableMap(new HashMap<>());
	private MediaView mediaview;	
	public static Stage primaryStage;
	public static Scene scene;
	public Handler handler;
	public static InputManager manager;
	private Thread thread;
	public SoundManager sm;
	
	@Override
	public void start(Stage primaryStage) {
		try {

			IntroSheet start = new IntroSheet();
			
			mediaview = new MediaView(mp);
			Scene startscene = new Scene(start);
			
			startscene.setOnKeyPressed(e -> {
				try {
					startMenu(e);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				
			});
			Base.primaryStage = primaryStage;
			Base.primaryStage.setScene(startscene);
	        Base.primaryStage.setTitle("Mono Mano");
	        
			sm = new SoundManager("nftsb");		
			
			Base.primaryStage.setResizable(false);
			Base.primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void startMenu(KeyEvent k) throws FileNotFoundException {
		String key = k.getCode().toString();
		if (key.contains("ENTER")) {
			StartController starter = new StartController(355, 314);
			Handler.changeScene(starter);
			
			Handler.setObjectlist(starter.sheet.getObjectlist());
		}
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
	/**
	 * @return the thread
	 */
	public Thread getThread() {
		return thread;
	}

	/**
	 * @param thread the thread to set
	 */
	public void setThread(Thread thread) {
		this.thread = thread;
	}

	/**
	 * @return the sm
	 */
	public SoundManager getSm() {
		return sm;
	}

	/**
	 * @param sm the sm to set
	 */
	public void setSm(SoundManager sm) {
		this.sm = sm;
	}



	/**
	 * @return the mp
	 */
	public MediaPlayer getMp() {
		return mp;
	}



	/**
	 * @param mp the mp to set
	 */
	public void setMp(MediaPlayer mp) {
		this.mp = mp;
	}



	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}



	/**
	 * @return the musicmap
	 */
	public ObservableMap<String, Media> getMusicmap() {
		return musicmap;
	}



	/**
	 * @param musicmap the musicmap to set
	 */
	public void setMusicmap(ObservableMap<String, Media> musicmap) {
		this.musicmap = musicmap;
	}



	/**
	 * @return the mediaview
	 */
	public MediaView getMediaview() {
		return mediaview;
	}



	/**
	 * @param mediaview the mediaview to set
	 */
	public void setMediaview(MediaView mediaview) {
		this.mediaview = mediaview;
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
