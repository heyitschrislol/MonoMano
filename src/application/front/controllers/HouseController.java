package application.front.controllers;

import java.io.FileNotFoundException;

import application.back.managers.InputManager;
import application.front.sheets.HouseSheet;
import javafx.scene.Scene;

public class HouseController extends Controller {
	public HouseSheet sheet;
	public Scene scene;
	
	
	public HouseController() throws FileNotFoundException {
		sheet = new HouseSheet(352, 420);
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
	public HouseSheet getSheet() {
		return sheet;
	}
	/**
	 * @param sheet the sheet to set
	 */
	public void setSheet(HouseSheet sheet) {
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
