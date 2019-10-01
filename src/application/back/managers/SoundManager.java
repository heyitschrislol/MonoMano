package application.back.managers;

import java.util.HashMap;
import java.util.Map;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javafx.concurrent.Task;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class SoundManager {

	private AudioClip clip;
	private Media music;
	private MediaPlayer player;
	// Change file name to match yours, of course
	public static Map<String, AudioClip> soundEffectsMap = new HashMap<>();
	public static Map<String, Media> bgMusicMap = new HashMap<>();
	public static SoundManager bgins = new SoundManager(2, "Bgins", "/application/assets/audio/Bgins.wav");
	public static SoundManager nftsb = new SoundManager(2, "NFTSB", "/application/assets/audio/Nothing For the Swim Back.wav");
	public static SoundManager grunt = new SoundManager(1, "grunt", "/application/assets/audio/Male Grunt.wav");
	public static SoundManager pendrop = new SoundManager(1, "pendrop", "/application/assets/audio/pendrop.mp3");
	public static SoundManager milkshake = new SoundManager(1, "milkshake", "/application/assets/audio/milkshake.mp3");
	public static SoundManager heeya = new SoundManager(1, "heeya", "/application/assets/audio/hee-ya.mp3");

	public SoundManager(int type, String name, String url) {
		try {
			if (type == 1) {
				clip = new AudioClip(getClass().getResource(url).toExternalForm());
				soundEffectsMap.put(name, clip);
			} else if (type == 2) {
				music = new Media(getClass().getResource(url).toExternalForm());
				bgMusicMap.put(name, music);
				player = new MediaPlayer(music);
			} else {
				System.out.println("please put 1 for sound effect, 2 for music.");
			}
			
	        

	        
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void playClip() {
		try {
			if (clip != null) {
				new Thread() {
					public void run() {
						synchronized (clip) {
							clip.stop();
							
							clip.play();
						}
					}
				}.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void playMusic() {
		try {
			if (music != null) {
					player.setOnReady(new Runnable() {
			    		@Override
			    		 public void run() {
			    			player.play();
			    		}
			    	});
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void stopMusic() {
		if (music == null) {
			return;
		}
		player.stop();
	}

	public void stopClip() {
		if (clip == null)
			return;
		clip.stop();
	}
	public void loopClip() {
		try {
			if (clip != null) {
				new Thread() {
					public void run() {
						synchronized (clip) {
							clip.stop();
							clip.setCycleCount(AudioClip.INDEFINITE);
						}
					}
				}.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void loopMusic() {
		try {
			if (music != null) {
				player.setCycleCount(MediaPlayer.INDEFINITE);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isActive() {
		return clip.isPlaying();
	}
}
