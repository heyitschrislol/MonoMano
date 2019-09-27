package application.front.controllers;

import java.io.FileNotFoundException;

import application.front.sheets.Sheet;
import javafx.scene.Scene;

public abstract class Controller {
	public Sheet sheet;
	public Scene scene;
	
	
	public Controller() {

	}
	/**
	 * @return the sheet
	 */
	public Sheet getSheet() {
		return sheet;
	}
	/**
	 * @param sheet the sheet to set
	 */
	public void setSheet(Sheet sheet) {
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
