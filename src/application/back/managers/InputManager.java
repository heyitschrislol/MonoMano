package application.back.managers;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

import application.back.enums.*;
import application.front.Base;
import application.front.controllers.Controller;
import application.front.objects.*;
import application.front.sheets.Sheet;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class InputManager {

	public static Controller controller;
	public static Handler handler;
	public static GraphicsContext gc;
	public static ArrayList<String> input;
	public static ArrayList<String> inputsnag;
	public static int lastpress;
	public static GameObject actionobject;
	public static boolean intersecting;
	public static boolean popup;
	public static Sheet sheet;
	
	public InputManager() {
		input = new ArrayList<>();
		inputsnag = new ArrayList<>();
	}
	public InputManager(Handler handler) {
		this.handler = handler;
		input = new ArrayList<>();
		inputsnag = new ArrayList<>();
	}

	public void keyPress(KeyEvent e) {
		int p = 0;
		String key = e.getCode().toString();
		if (key.contains("DOWN")) {
			Handler.findPlayer().downkey = true;
		}
		if (key.contains("UP")) {
			Handler.findPlayer().upkey = true;
		}
		if (key.contains("LEFT")) {
			Handler.findPlayer().leftkey = true;
		}
		if (key.contains("RIGHT")) {
			Handler.findPlayer().rightkey = true;
		}
		if (key.contains("X")) {
			if (intersecting) {
				if (!popup) {
					if (!actionobject.getObjecttext().isBlank()) {
						Handler.showPopup(actionobject);
						popup = true;
					}
					if (!actionobject.getSound().isBlank()) {
						if (actionobject.getSound().equals("boodaboo")) {
							SoundManager.playClip(actionobject.getSound(), actionobject.getVolume());
						} else {
							SoundManager.playClip(actionobject.getSound(), actionobject.getVolume());

						}
					}
					
				} else {
					Handler.clearPopup();
					popup = false;
				}

			} else {
				Handler.clearPopup();
				intersecting = false;
				popup = false;
			}
		}
		
	}

	public void keyRelease(KeyEvent e) {
		String key = e.getCode().toString();
		if (key.contains("DOWN")) {
			Handler.findPlayer().downkey = false;
			Handler.findPlayer().setVelY(0);

		}
		if (key.contains("UP")) {
			Handler.findPlayer().upkey = false;
			Handler.findPlayer().setVelY(0);

		}
		if (key.contains("LEFT")) {
			Handler.findPlayer().leftkey = false;
			Handler.findPlayer().setVelX(0);

		}
		if (key.contains("RIGHT")) {
			Handler.findPlayer().rightkey = false;
			Handler.findPlayer().setVelX(0);

		}
	}

	/**
	 * @return the Handler
	 */
	public static Handler getHandler() {
		return handler;
	}
	/**
	 * @param handler the handler to set
	 */
	public static void setHandler(Handler handler) {
		InputManager.handler = handler;
	}
	

}
