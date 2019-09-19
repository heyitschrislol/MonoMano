package application.front;

import java.util.ArrayList;
import java.util.HashMap;

import application.back.AssetManager;
import application.back.enums.ID;
import application.front.objects.*;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

public class InputManager {

	public Handler handler;
	public static ArrayList<String> input;
	public int lastpress;
	
	public InputManager(Handler handler) {
		this.handler = handler;
		input = new ArrayList<>();
	}

	public void keyPress(KeyEvent e) {
		String key = e.getCode().toString();
		for (GameObject temp : handler.object) {
			if (temp.getID() == ID.PLAYER) {
				if (key.contains("DOWN")) {
					if (!input.contains("DOWN"))input.add("DOWN");
					if (input.contains(key)) {
//						temp.setVelY(5);
					}
				}
				if (key.contains("UP")) {
					if (!input.contains("UP"))input.add("UP");
					if (input.contains(key)) {
//						temp.setVelY(-5);
					}
				}
				if (key.contains("LEFT")) {
					if (!input.contains("LEFT"))input.add("LEFT");
					if (input.contains(key)) {
//						temp.setVelX(-5);
					}
				}
				if (key.contains("RIGHT")) {
					if (!input.contains("RIGHT"))input.add("RIGHT");
					if (input.contains(key)) {
//						temp.setVelX(5);
					}
				}
			}
		}
	}

	public void keyRelease(KeyEvent e) {
		String key = e.getCode().toString();
		for (GameObject temp : handler.object) {
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
}
