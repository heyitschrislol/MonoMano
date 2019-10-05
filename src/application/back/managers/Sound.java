package application.back.managers;

import java.util.HashMap;

import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;

public class Sound {
	protected ObservableMap<String, Media> musicmap = FXCollections.observableMap(new HashMap<>());
	protected static ObservableMap<String, AudioClip> soundmap = FXCollections.observableMap(new HashMap<>());
	
	public Sound() {

	}

	public void loadBGM(String id, String url) {
		Media track = new Media(getClass().getResource(url).toExternalForm());
		musicmap.put(id, track);
	}
	public void loadSound(String id, String url) {
		AudioClip clip = new AudioClip(getClass().getResource(url).toExternalForm());
		soundmap.put(id, clip);
	}
	
}
