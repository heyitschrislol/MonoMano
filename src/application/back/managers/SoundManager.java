package application.back.managers;

import java.util.HashMap;
import java.util.Random;

import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.media.MediaView;

public class SoundManager implements Runnable {
	
	private boolean playing = false;
	private MediaPlayer player;
	private String id;
	protected ObservableMap<String, Media> musicmap = FXCollections.observableMap(new HashMap<>());
	protected static ObservableMap<String, AudioClip> soundmap = FXCollections.observableMap(new HashMap<>());
	private MediaView mediaview;
	public static SoundManager nftsb = new SoundManager("nftsb");
	public static SoundManager bgins = new SoundManager("bgins");
	public static SoundManager forest = new SoundManager("forest");
	public static SoundManager windy = new SoundManager("windy");
	public static SoundManager water = new SoundManager("water");
	public static SoundManager horror = new SoundManager("horror");
	public static SoundManager weird = new SoundManager("weird");

//	public SoundManager() {
////		this.id = id;
////		loadBGM("bgins", "/application/assets/audio/bgins.mp3");
////		loadBGM("windy", "/application/assets/audio/windy.mp3");
////		loadBGM("forest", "/application/assets/audio/forest.mp3");
////		loadBGM("water", "/application/assets/audio/awaterlap.mp3");
////		loadBGM("nftsb", "/application/assets/audio/nftsb.mp3");
////		
////		loadSound("grunt", "/application/assets/audio/Male Grunt.wav");
////		loadSound("pendrop", "/application/assets/audio/pendrop.mp3");
////		loadSound("milkshake", "/application/assets/audio/milkshake.mp3");
////		loadSound("blooblee", "/application/assets/audio/blooblee.wav");
////		loadSound("boodaboo", "/application/assets/audio/boodaboo.wav");
////		loadSound("doorclick", "/application/assets/audio/doorhclick.mp3");
////		loadSound("swords12", "/application/assets/audio/swords/swords12.mp3");
////		loadSound("failnegative", "/application/assets/audio/retrogameincorrect_fail_negative.mp3");
//		player = new MediaPlayer(musicmap.get(id));
//		mediaview = new MediaView(player);
//		
//		playMusic();
//		
//
//		
//	}
	public SoundManager(String id) {
		this.id = id;
		loadBGM("bgins", "/application/assets/audio/bgins.mp3");
		loadBGM("windy", "/application/assets/audio/windy.mp3");
		loadBGM("forest", "/application/assets/audio/forest.mp3");
		loadBGM("water", "/application/assets/audio/awaterlap.mp3");
		loadBGM("nftsb", "/application/assets/audio/nftsb.mp3");
		loadBGM("horror", "/application/assets/audio/unseenhorrors.mp3");
		loadBGM("weird", "/application/assets/audio/weirdman.mp3");
		
		loadSound("grunt", "/application/assets/audio/Male Grunt.wav");
		loadSound("doodoodoo", "/application/assets/audio/doodoodoo.mp3");
		loadSound("bizwhacker", "/application/assets/audio/suchabizwhacker.mp3");
		loadSound("brother1", "/application/assets/audio/hellobrother.mp3");
		loadSound("brother2", "/application/assets/audio/hellobrother2.mp3");
		loadSound("hmm1", "/application/assets/audio/jordan-hmm.mp3");
		loadSound("hmm2", "/application/assets/audio/jordan-hmmm2.mp3");
		loadSound("idk", "/application/assets/audio/jordan-idk.mp3");
		loadSound("start.mp3", "/application/assets/audio/press start.mp3");
		loadSound("start2.mp3", "/application/assets/audio/press start2.mp3");
		loadSound("pendrop", "/application/assets/audio/pendrop.mp3");
		loadSound("milkshake", "/application/assets/audio/milkshake.mp3");
		loadSound("blooblee", "/application/assets/audio/blooblee.wav");
		loadSound("boodaboo", "/application/assets/audio/boodaboo.wav");
		loadSound("doorclick", "/application/assets/audio/doorhclick.mp3");
		loadSound("swords12", "/application/assets/audio/swords/swords12.mp3");
		loadSound("failnegative", "/application/assets/audio/retrogameincorrect_fail_negative.mp3");

		

	}
	public void playSong() {
		player = new MediaPlayer(musicmap.get(id));
		mediaview = new MediaView(player);
		mediaview.getMediaPlayer().setVolume(0.07);
		mediaview.getMediaPlayer().setCycleCount(MediaPlayer.INDEFINITE);
		mediaview.getMediaPlayer().setAutoPlay(true);
		playing = true;
	}
	public void stopSong() {
//		player= new MediaPlayer(musicmap.get(id));
//		mediaview = new MediaView(player);
		Status status = mediaview.getMediaPlayer().getStatus();
		
		if (status == Status.PLAYING) {
			mediaview.getMediaPlayer().stop();
			playing = false;
		} else {
			return;
		}
	}
//	public void playMusic() {
//		Status status = mediaview.getMediaPlayer().getStatus();
//		 
//		if (status == Status.PLAYING) {
//			mediaview.getMediaPlayer().stop();
//			MediaPlayer pp = new MediaPlayer(musicmap.get(id));
//			mediaview.setMediaPlayer(pp);
//			mediaview.getMediaPlayer().setVolume(0.02);
//			mediaview.getMediaPlayer().setCycleCount(MediaPlayer.INDEFINITE);
//			mediaview.getMediaPlayer().play();
//	        return;
//	         
//		} else {
//			player = new MediaPlayer(musicmap.get(id));
//			mediaview.setMediaPlayer(player);
//			mediaview.getMediaPlayer().setVolume(0.05);
//			mediaview.getMediaPlayer().setCycleCount(MediaPlayer.INDEFINITE);
//			mediaview.getMediaPlayer().play();
//		}
//	}
//	public void playMusic(String id) {
//		
//		Status status = mediaview.getMediaPlayer().getStatus();
//		 
//		if (status == Status.PAUSED || status == Status.READY || status == Status.STOPPED) {
//			
//			mediaview.getMediaPlayer().setVolume(0.02);
//			mediaview.getMediaPlayer().setCycleCount(MediaPlayer.INDEFINITE);
//			mediaview.getMediaPlayer().play();
//	        return;
//	         
//		} else {
//			player = new MediaPlayer(musicmap.get(id));
//			mediaview.setMediaPlayer(player);
//			mediaview.getMediaPlayer().setVolume(0.02);
//			mediaview.getMediaPlayer().setCycleCount(MediaPlayer.INDEFINITE);
//			mediaview.getMediaPlayer().play();
//		}
//	}
//	public ObservableMap<String, AudioClip> voiceMap(String[] names) {
//		ObservableMap<String, AudioClip> voices = 
//	}
	public static void playClip(String id) {
		soundmap.get(id).play();
	}
	public static void playClip(String id, double volume) {
		soundmap.get(id).setVolume(volume);
		soundmap.get(id).play();
	}
	public static void playRandomClip(String[] ids) {
		int x;
		Random rando = new Random();
		x = rando.nextInt(ids.length);
		soundmap.get(ids[x]).play();
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
		loadBGM("bgins", "/application/assets/audio/bgins.mp3");
		loadBGM("windy", "/application/assets/audio/windy.mp3");
		loadBGM("forest", "/application/assets/audio/forest.mp3");
		loadBGM("water", "/application/assets/audio/awaterlap.mp3");
		loadBGM("nftsb", "/application/assets/audio/nftsb.mp3");
		loadBGM("horror", "/application/assets/audio/unseenhorrors.mp3");
		loadBGM("weird", "/application/assets/audio/weirdman.mp3");


		loadSound("wellhello", "/application/assets/audio/wellhello.mp3");
		loadSound("doodoodoo", "/application/assets/audio/doodoodoo.mp3");
		loadSound("bizwhacker", "/application/assets/audio/suchabizwhacker.mp3");
		loadSound("brother1", "/application/assets/audio/hellobrother.mp3");
		loadSound("brother2", "/application/assets/audio/hellobrother2.mp3");
		loadSound("hmm1", "/application/assets/audio/jordan-hmm.mp3");
		loadSound("hmm2", "/application/assets/audio/jordan-hmmm2.mp3");
		loadSound("idk", "/application/assets/audio/jordan-idk.mp3");
		loadSound("grunt", "/application/assets/audio/Male Grunt.wav");
		loadSound("start", "/application/assets/audio/press start.mp3");
		loadSound("start2", "/application/assets/audio/press start2.mp3");
		loadSound("pendrop", "/application/assets/audio/pendrop.mp3");
		loadSound("milkshake", "/application/assets/audio/milkshake.mp3");
		loadSound("blooblee", "/application/assets/audio/blooblee.wav");
		loadSound("boodaboo", "/application/assets/audio/boodaboo.wav");
		loadSound("doorclick", "/application/assets/audio/doorhclick.mp3");
		loadSound("swords12", "/application/assets/audio/swords/swords12.mp3");
		loadSound("failnegative", "/application/assets/audio/retrogameincorrect_fail_negative.mp3");
//		player = new MediaPlayer(musicmap.get(id));
//		mediaview.getMediaPlayer().setVolume(0.02);
//		mediaview.getMediaPlayer().setCycleCount(MediaPlayer.INDEFINITE);
//		mediaview = new MediaView(player);
		playSong();
		
//		mediaview.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
//
//			@Override
//			public void handle(ActionEvent arg0) {
//				player = new MediaPlayer(musicmap.get(id));
//				mediaview = new MediaView(player);
//				playMusic();
//			}
//			
//		});
//		playMusic();
		
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
		player = new MediaPlayer(musicmap.get(id));
		
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
	/**
	 * @return the playing
	 */
	public boolean isPlaying() {
		return playing;
	}
	/**
	 * @param playing the playing to set
	 */
	public void setPlaying(boolean playing) {
		this.playing = playing;
	}
}
