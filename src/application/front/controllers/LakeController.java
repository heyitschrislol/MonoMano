package application.front.controllers;

import java.io.FileNotFoundException;

import application.back.managers.InputManager;
import application.front.sheets.LakeSheet;
import javafx.scene.Scene;

public class LakeController extends Controller {
	public LakeSheet sheet;
	public Scene scene;
	public final String music = "nftsb";
	public final double volume = .02;
	public LakeController() {

	}
	

	public LakeController(int exitX, int exitY) throws FileNotFoundException {
		super(exitX, exitY);

		sheet = new LakeSheet(exitX, exitY);
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
	public LakeSheet getSheet() {
		return sheet;
	}


	/**
	 * @param sheet the sheet to set
	 */
	public void setSheet(LakeSheet sheet) {
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
