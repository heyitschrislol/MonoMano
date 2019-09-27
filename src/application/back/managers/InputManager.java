package application.back.managers;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

import application.back.enums.*;
import application.back.managers.AssetManager;
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
//			if (!input.contains("DOWN"))input.add("DOWN");
		}
		if (key.contains("UP")) {
			Handler.findPlayer().upkey = true;
//			if (!input.contains("UP"))input.add("UP");
		}
		if (key.contains("LEFT")) {
			Handler.findPlayer().leftkey = true;
//			if (!input.contains("LEFT"))input.add("LEFT");
		}
		if (key.contains("RIGHT")) {
			Handler.findPlayer().rightkey = true;
		}
		if (key.contains("X")) {
			if (intersecting) {
				if (!popup) {
					if (!actionobject.getObjecttext().isBlank()) {
						Base.showPopup((EnvironmentObject) actionobject);
						popup = true;
					}
					
				} else {
					Base.clearPopup();
					popup = false;
				}

			} else {
				Base.clearPopup();
				intersecting = false;
				popup = false;
			}
		}
		
//		if (key.contains("SPACE")) {
//			Rectangle2D bounds = temp.getBoundary();
//			System.out.println("Player Min X: " + bounds.getMinX() + " Max X: " + (bounds.getMinX() + bounds.getWidth()) + " Min Y: " + bounds.getMinY() + " Max Y: " + (bounds.getMinY() + bounds.getHeight()));
//		}
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
//	public void actionKey(KeyEvent e) {
//		String key = e.getCode().toString();
//		
//	}
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
	
//	public GraphicsContext popup(GraphicsContext ogc, EnvironmentObject eo) {
//		ogc.setStroke(Color.BROWN);
//		ogc.setLineWidth(4);
//		ogc.strokeRoundRect(134, 70, 500, 270, 10, 10);
//        // Draw a filled rounded Rectangle
//		ogc.setFill(Color.ANTIQUEWHITE);
//        ogc.fillRoundRect(138, 74, 494, 264, 10, 10);
//        ogc.setFill(Color.BLACK);
//        ogc.fillText(eo.getObjecttext(),170, 110, 482);
//         return ogc;
//	}
//	public void clearPopup(GraphicsContext ogc) {
//		ogc.clearRect(0, 0, 768, 512);
//	}
}
