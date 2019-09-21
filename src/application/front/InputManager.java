package application.front;

import java.util.ArrayList;
import java.util.HashMap;

import application.back.AssetManager;
import application.back.enums.ID;
import application.front.objects.*;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

public class InputManager {

	public Handler handler;
	public static ArrayList<String> input;
	public static ArrayList<String> inputsnag;
	public int lastpress;
	
	public InputManager(Handler handler) {
		this.handler = handler;
		input = new ArrayList<>();
		inputsnag = new ArrayList<>();
	}

	public void keyPress(KeyEvent e) {
		String key = e.getCode().toString();
		for (GameObject temp : handler.objectlist) {
			if (temp.getID() == ID.PLAYER) {
				if (key.contains("DOWN")) {
					if (!input.contains("DOWN"))input.add("DOWN");
				}
				if (key.contains("UP")) {
					if (!input.contains("UP"))input.add("UP");
				}
				if (key.contains("LEFT")) {
					if (!input.contains("LEFT"))input.add("LEFT");
				}
				if (key.contains("RIGHT")) {
					if (!input.contains("RIGHT"))input.add("RIGHT");
				}
				if (key.contains("SPACE")) {
					Rectangle2D bounds = temp.getBoundary();
					System.out.println("Player Min X: " + bounds.getMinX() + " Max X: " + (bounds.getMinX() + bounds.getWidth()) + " Min Y: " + bounds.getMinY() + " Max Y: " + (bounds.getMinY() + bounds.getHeight()));
				}
			} else if (temp.getID() == ID.ENVIRONMENT) {
				if (key.contains("SPACE")) {
					Rectangle2D bounds = temp.getBoundary();
					System.out.println("Tree Min X: " + bounds.getMinX() + " Max X: " + (bounds.getMinX() + bounds.getWidth()) + " Min Y: " + bounds.getMinY() + " Max Y: " + (bounds.getMinY() + bounds.getHeight()));
					System.out.println(temp.getWidth() + " " + temp.getHeight());
				
				}
			}
		}
	}

	public void keyRelease(KeyEvent e) {
		String key = e.getCode().toString();
		for (GameObject temp : handler.objectlist) {
			if (temp.getID() == ID.PLAYER) {
				if (key.contains("DOWN")) {
					if (input.contains("DOWN"))input.remove("DOWN");
					temp.setImage(AssetManager.returnIdles()[0]);
					temp.setVelY(0);
				}
				if (key.contains("UP")) {
					if (input.contains("UP"))input.remove("UP");
					temp.setImage(AssetManager.returnIdles()[1]);
					temp.setVelY(0);
				}
				
				if (key.contains("LEFT")) {
					if (input.contains("LEFT"))input.remove("LEFT");
					temp.setImage(AssetManager.returnIdles()[2]);
					temp.setVelX(0);
				}
				if (key.contains("RIGHT")) {
					if (input.contains("RIGHT"))input.remove("RIGHT");
					temp.setImage(AssetManager.returnIdles()[3]);
					temp.setVelX(0);
				}
			}
		}
	}
	
	public static void activateMove(String key) {
		if (inputsnag.contains(key)) {
			inputsnag.remove(key);
		}
	}
	public static void deactivateMove(String key) {
		if (!inputsnag.contains(key)) {
			inputsnag.add(key);
		}
	}
}
