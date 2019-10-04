package application.front.controllers;

import java.io.FileNotFoundException;

import application.front.sheets.Sheet;
import javafx.scene.Scene;

public abstract class Controller {
	public Sheet sheet;
	public Scene scene;
	public int exitX;
	public int exitY;
//	public SoundManager manager;
	public String music;
	public double volume;
	
	public Controller() {

	}
	public Controller(int exitX, int exitY) {
		this.exitX = exitX;
		this.exitY = exitY;
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
	/**
	 * @return the exitX
	 */
	public int getExitX() {
		return exitX;
	}
	/**
	 * @param exitX the exitX to set
	 */
	public void setExitX(int exitX) {
		this.exitX = exitX;
	}
	/**
	 * @return the exitY
	 */
	public int getExitY() {
		return exitY;
	}
	/**
	 * @param exitY the exitY to set
	 */
	public void setExitY(int exitY) {
		this.exitY = exitY;
	}
//	/**
//	 * @return the manager
//	 */
//	public SoundManager getManager() {
//		return manager;
//	}
//	/**
//	 * @param manager the manager to set
//	 */
//	public void setManager(SoundManager manager) {
//		this.manager = manager;
//	}
	/**
	 * @return the music
	 */
	public String getMusic() {
		return music;
	}
	/**
	 * @param music the music to set
	 */
	public void setMusic(String music) {
		this.music = music;
	}
	/**
	 * @return the volume
	 */
	public double getVolume() {
		return volume;
	}
	/**
	 * @param volume the volume to set
	 */
	public void setVolume(double volume) {
		this.volume = volume;
	}
	
}
