package application.front.controllers;

import java.io.FileNotFoundException;

import application.back.managers.InputManager;

import application.front.sheets.BeginSheet;
import javafx.scene.Scene;

public class StartController extends Controller {
	public BeginSheet sheet;
	public Scene scene;
	public final String music = "bgins";
	public final double volume = .07;
	
	public StartController(int exitX, int exitY) throws FileNotFoundException {
		super(exitX, exitY);
//		SoundManager.nftsb.stopMusic();
//		manager = SoundManager.windy;
//		SoundManager.windy.playMusic(volume);
//		MusicManager.playMusic("windy", 0.05);

		sheet = new BeginSheet(exitX, exitY);

		scene = new Scene(sheet);
		sheet.enter();
		
		InputManager manager = new InputManager();
		scene.setOnKeyPressed(e -> {
			manager.keyPress(e);
		});
		scene.setOnKeyReleased(e -> {
			manager.keyRelease(e);
		});
	}
	/**
	 * @return the sheet
	 */
	public BeginSheet getSheet() {
		return sheet;
	}
	/**
	 * @param sheet the sheet to set
	 */
	public void setSheet(BeginSheet sheet) {
		this.sheet = sheet;
	}
	/**
	 * @return the scene
	 */
	public Scene getScene() {
		return scene;
	}
	/**
	 * @param scene the scene to set
	 */
	public void setScene(Scene scene) {
		this.scene = scene;
	}


}
