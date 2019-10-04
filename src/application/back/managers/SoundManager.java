package application.back.managers;

import java.util.HashMap;

import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import javafx.concurrent.Task;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.media.MediaView;

public class SoundManager implements Runnable {
	private MediaPlayer player;
	private String id;
	protected ObservableMap<String, Media> musicmap = FXCollections.observableMap(new HashMap<>());
	protected static ObservableMap<String, AudioClip> soundmap = FXCollections.observableMap(new HashMap<>());
	private MediaView mediaview;
	public static SoundManager soundmanager = new SoundManager("bgins");
	
	
	public SoundManager() {
//		this.id = id;
		loadBGM("bgins", "/application/assets/audio/bgins.mp3");
		loadBGM("windy", "/application/assets/audio/windy.mp3");
		loadBGM("forest", "/application/assets/audio/forest.mp3");
		loadBGM("water", "/application/assets/audio/awaterlap.mp3");
		loadBGM("nftsb", "/application/assets/audio/nftsb.mp3");
		
		loadSound("grunt", "/application/assets/audio/Male Grunt.wav");
		loadSound("pendrop", "/application/assets/audio/pendrop.mp3");
		loadSound("milkshake", "/application/assets/audio/milkshake.mp3");
		loadSound("blooblee", "/application/assets/audio/blooblee.wav");
		loadSound("boodaboo", "/application/assets/audio/boodaboo.wav");
		loadSound("doorclick", "/application/assets/audio/doorhclick.mp3");
		loadSound("swords12", "/application/assets/audio/swords/swords12.mp3");
		loadSound("failnegative", "/application/assets/audio/retrogameincorrect_fail_negative.mp3");
		player = new MediaPlayer(musicmap.get(id));
		mediaview = new MediaView(player);
		
		playMusic();
		

		
	}
	public SoundManager(String id) {
		this.id = id;
		loadBGM("bgins", "/application/assets/audio/bgins.mp3");
		loadBGM("windy", "/application/assets/audio/windy.mp3");
		loadBGM("forest", "/application/assets/audio/forest.mp3");
		loadBGM("water", "/application/assets/audio/awaterlap.mp3");
		loadBGM("nftsb", "/application/assets/audio/nftsb.mp3");
		
		loadSound("grunt", "/application/assets/audio/Male Grunt.wav");
		loadSound("pendrop", "/application/assets/audio/pendrop.mp3");
		loadSound("milkshake", "/application/assets/audio/milkshake.mp3");
		loadSound("blooblee", "/application/assets/audio/blooblee.wav");
		loadSound("boodaboo", "/application/assets/audio/boodaboo.wav");
		loadSound("doorclick", "/application/assets/audio/doorhclick.mp3");
		loadSound("swords12", "/application/assets/audio/swords/swords12.mp3");
		loadSound("failnegative", "/application/assets/audio/retrogameincorrect_fail_negative.mp3");
		player = new MediaPlayer(musicmap.get(id));
		mediaview = new MediaView(player);
		
		playMusic();
		

		
	}
	
	public void playMusic() {
		
		Status status = mediaview.getMediaPlayer().getStatus();
		 
		if (status == Status.PAUSED || status == Status.READY || status == Status.STOPPED) {
			
			mediaview.getMediaPlayer().setVolume(0.02);
			mediaview.getMediaPlayer().setCycleCount(MediaPlayer.INDEFINITE);
			mediaview.getMediaPlayer().play();
	        return;
	         
		} else {
			player = new MediaPlayer(musicmap.get(id));
			mediaview.setMediaPlayer(player);
			mediaview.getMediaPlayer().setVolume(0.05);
			mediaview.getMediaPlayer().setCycleCount(MediaPlayer.INDEFINITE);
			mediaview.getMediaPlayer().play();
		}
	}
	public void playMusic(String id) {
		
		Status status = mediaview.getMediaPlayer().getStatus();
		 
		if (status == Status.PAUSED || status == Status.READY || status == Status.STOPPED) {
			
			mediaview.getMediaPlayer().setVolume(0.02);
			mediaview.getMediaPlayer().setCycleCount(MediaPlayer.INDEFINITE);
			mediaview.getMediaPlayer().play();
	        return;
	         
		} else {
			player = new MediaPlayer(musicmap.get(id));
			mediaview.setMediaPlayer(player);
			mediaview.getMediaPlayer().setVolume(0.02);
			mediaview.getMediaPlayer().setCycleCount(MediaPlayer.INDEFINITE);
			mediaview.getMediaPlayer().play();
		}
	}
	public static void playClip(String id) {
		soundmap.get(id).play();
	}
	
	public void loadBGM(String id, String url) {
		Media track = new Media(getClass().getResource(url).toExternalForm());
		musicmap.put(id, track);
	}
	public void loadSound(String id, String url) {
		AudioClip clip = new AudioClip(getClass().getResource(url).toExternalForm());
		soundmap.put(id, clip);
	}


	@Override
	public void run() {
		// DOESNT NEED ANYTHING
	}


	/**
	 * @return the player
	 */
	@SuppressWarnings("exports")
	public MediaPlayer getPlayer() {
		return player;
	}


	/**
	 * @param player the player to set
	 */
	@SuppressWarnings("exports")
	public void setPlayer(MediaPlayer player) {
		this.player = player;
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
	@SuppressWarnings("exports")
	public ObservableMap<String, Media> getMusicmap() {
		return musicmap;
	}
	/**
	 * @param musicmap the musicmap to set
	 */
	@SuppressWarnings("exports")
	public void setMusicmap(ObservableMap<String, Media> musicmap) {
		this.musicmap = musicmap;
	}


	/**
	 * @return the soundmap
	 */
	@SuppressWarnings("exports")
	public static ObservableMap<String, AudioClip> getSoundmap() {
		return soundmap;
	}


	/**
	 * @param soundmap the soundmap to set
	 */
	@SuppressWarnings("exports")
	public static void setSoundmap(ObservableMap<String, AudioClip> soundmap) {
		SoundManager.soundmap = soundmap;
	}


	/**
	 * @return the mediaview
	 */
	@SuppressWarnings("exports")
	public MediaView getMediaview() {
		return mediaview;
	}


	/**
	 * @param mediaview the mediaview to set
	 */
	@SuppressWarnings("exports")
	public void setMediaview(MediaView mediaview) {
		this.mediaview = mediaview;
	}
}
