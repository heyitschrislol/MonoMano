package application.front.sheets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import application.back.managers.Handler;
import application.front.objects.Boundary;
import application.front.objects.EnvironmentObject;
import application.front.objects.GameObject;
import application.front.objects.PlayerObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public abstract class Sheet extends Group {
	public static final int WIDTH = 768;
	public static final int HEIGHT = 512;
	public PlayerObject player;
	public ObservableList<GameObject> objectlist = FXCollections.observableArrayList();
	public ObservableList<Boundary> portallist = FXCollections.observableArrayList();
	public Handler handler;
	public Image sceneImage;
	public int startX;
	public int startY;
	
	
	public Canvas canvas;
//	public Canvas overlay;
	public GraphicsContext gc;
//	public GraphicsContext ogc;
	
	public Sheet() {

	}
	public Sheet(int startX, int startY) {
		this.startX = startX;
		this.startY = startY;

	}
	public Sheet(PlayerObject player) {
		this.player = player;

	}
	
	public abstract void enter();
	public abstract ObservableList<Boundary> objectBoundaries();
	public abstract ArrayList<Boundary> createExitList();
	public abstract void render(GraphicsContext gc);
	
	

	/**
	 * @return the player
	 */
	public PlayerObject getPlayer() {
		return player;
	}

	/**
	 * @param player the player to set
	 */
	public void setPlayer(PlayerObject player) {
		this.player = player;
	}

	/**
	 * @return the objectlist
	 */
	public ObservableList<GameObject> getObjectlist() {
		return objectlist;
	}

	/**
	 * @param objectlist the objectlist to set
	 */
	public void setObjectlist(ObservableList<GameObject> objectlist) {
		this.objectlist = objectlist;
	}

	/**
	 * @return the portallist
	 */
	public ObservableList<Boundary> getPortallist() {
		return portallist;
	}
	/**
	 * @param portallist the portallist to set
	 */
	public void setPortallist(ObservableList<Boundary> portallist) {
		this.portallist = portallist;
	}
	/**
	 * @return the handler
	 */
	public Handler getHandler() {
		return handler;
	}
	/**
	 * @param handler the handler to set
	 */
	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	/**
	 * @return the sceneImage
	 */
	public Image getSceneImage() {
		return sceneImage;
	}

	/**
	 * @param sceneImage the sceneImage to set
	 */
	public void setSceneImage(Image sceneImage) {
		this.sceneImage = sceneImage;
	}

	/**
	 * @return the sTARTX
	 */
	public int getStartX() {
		return startX;
	}

	/**
	 * @param sTARTX the sTARTX to set
	 */
	public void setStartX(int sTARTX) {
		startX = sTARTX;
	}

	/**
	 * @return the sTARTY
	 */
	public int getStartY() {
		return startY;
	}

	/**
	 * @param sTARTY the sTARTY to set
	 */
	public void setStartY(int sTARTY) {
		startY = sTARTY;
	}

	/**
	 * @return the canvas
	 */
	public Canvas getCanvas() {
		return canvas;
	}

	/**
	 * @param canvas the canvas to set
	 */
	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}

	/**
	 * @return the overlay
	 */
	

	/**
	 * @return the gc
	 */
	public GraphicsContext getGc() {
		return gc;
	}

	/**
	 * @param gc the gc to set
	 */
	public void setGc(GraphicsContext gc) {
		this.gc = gc;
	}




}
