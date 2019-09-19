package application.front;

import java.util.ArrayList;

import application.back.enums.ID;
import application.front.objects.GameObject;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

public class InputManager {

	public Handler handler;
	public static ArrayList<String> input;

	public InputManager(Handler handler) {
		this.handler = handler;
	}

	public void keyPress(KeyEvent e) {
		String key = e.getCode().toString();
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getID() == ID.PLAYER) {
				if (key.contains("UP") || key.equals("W"))
					tempObject.setVelY(-5);
				if (key.contains("DOWN") || key.equals("S"))
					tempObject.setVelY(5);
				if (key.contains("LEFT") || key.equals("A"))
					tempObject.setVelX(-5);
				if (key.contains("RIGHT") || key.equals("D"))
					tempObject.setVelX(5);
			}

		}
	}

	public void keyRelease(KeyEvent e) {
		String key = e.getCode().toString();
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getID() == ID.PLAYER) {
				if (key.contains("UP") || key.equals("W"))
					tempObject.setVelY(0);
				if (key.contains("DOWN") || key.equals("S"))
					tempObject.setVelY(0);
				if (key.contains("LEFT") || key.equals("A"))
					tempObject.setVelX(0);
				if (key.contains("RIGHT") || key.equals("D"))
					tempObject.setVelX(0);
			}
			
		}
	}
}
