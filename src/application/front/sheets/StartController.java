package application.front.sheets;

import java.io.FileNotFoundException;

import application.back.InputManager;
import javafx.scene.Scene;

public class StartController extends Controller {
	public StartSheet sheet;
	public Scene scene;
	
	public StartController() throws FileNotFoundException {
		sheet = new StartSheet(244, 244);
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
	public StartSheet getSheet() {
		return sheet;
	}
	/**
	 * @param sheet the sheet to set
	 */
	public void setSheet(StartSheet sheet) {
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
