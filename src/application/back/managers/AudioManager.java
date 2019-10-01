package application.back.managers;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import application.front.Base;
import javafx.concurrent.Task;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class AudioManager {
	public static ExecutorService soundPool = Executors.newFixedThreadPool(2);
	static Map<String, AudioClip> soundEffectsMap = new HashMap<>();
	static Map<String, String> bgMusicMap = new HashMap<>();

	/**
	 * Constructor to create a simple thread pool.
	 *
	 * @param numberOfThreads - number of threads to use media players in the map.
	 */
	public AudioManager(int numberOfThreads) {
		soundPool = Executors.newFixedThreadPool(numberOfThreads);
	}

	/**
	 * Load a sound into a map to later be played based on the id.
	 *
	 * @param id  - The identifier for a sound.
	 * @param url - The url location of the media or audio resource. Usually in
	 *            src/main/resources directory.
	 */
	public void loadSoundEffects(String id, String url) {
        AudioClip sound = new AudioClip(getClass().getResource("/application/assets/audio/" + url).toExternalForm());
		soundEffectsMap.put(id, sound);
	}
	public void loadBGMusic(String id, String url) {
		bgMusicMap.put(id, url);
	}

	/**
	 * Lookup a name resource to play sound based on the id.
	 *
	 * @param id identifier for a sound to be played.
	 */
	public static void playSound(final String id) {
		Runnable soundPlay = new Runnable() {
			@Override
			public void run() {
				soundEffectsMap.get(id).play();
			}
		};
		soundPool.execute(soundPlay);
	}

	public void playMusic(String id) {
    	Media media = new Media(getClass().getResource("/application/assets/audio/" + bgMusicMap.get(id)).toExternalForm());
    	
    	
    	MediaPlayer player = new MediaPlayer(media);
    	Runnable musicplay = new Runnable() {
			@Override
			public void run() {
				player.play();
			}
		};
		
		soundPool.execute(musicplay);
		
//    	player.setOnReady(new Runnable() {
//    		@Override
//    		 public void run() {
//    			player.play();
//    		}
//    	});
//    	soundpool.execute()
	}
//	public static void changeMusic(String url) {
//		final Task task = new Task() {
//
//	        @Override
//	        protected Object call() throws Exception {
//	            AudioClip audio = new AudioClip(getClass().getResource(url).toExternalForm());
//	            audio.setVolume(0.5f);
//	            audio.setCycleCount(AudioClip.INDEFINITE);
//	            audio.play();
//	            return null;
//	        }
//	    };
//	    soundPool.execute(task);
////	    thread.start();
//	}

	/**
	 * Stop all threads and media players.
	 */
	public void shutdown() {
		soundPool.shutdown();
	}

}
