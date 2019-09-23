package application.front;

import java.util.ArrayList;
import java.util.HashMap;

import application.back.AssetManager;
import application.back.Boundary;
import application.back.enums.*;
import application.front.objects.*;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;

public class InputManager {

	public Handler handler;
	public GraphicsContext gc;
	public static ArrayList<String> input;
	public static ArrayList<String> inputsnag;
	public int lastpress;
	public GameObject actionobject;
	public boolean intersecting;
	
	public InputManager(Handler handler) {
		this.handler = handler;
		input = new ArrayList<>();
		inputsnag = new ArrayList<>();
	}
	public InputManager(Handler handler, GraphicsContext gc) {
		this.handler = handler;
		this.gc = gc;
		input = new ArrayList<>();
		inputsnag = new ArrayList<>();
	}

	public void keyPress(KeyEvent e) {
		int p = 0;
		String key = e.getCode().toString();
		if (key.contains("DOWN")) {
			handler.findPlayer().downkey = true;
//			if (!input.contains("DOWN"))input.add("DOWN");
		}
		if (key.contains("UP")) {
			handler.findPlayer().upkey = true;
//			if (!input.contains("UP"))input.add("UP");
		}
		if (key.contains("LEFT")) {
			handler.findPlayer().leftkey = true;
//			if (!input.contains("LEFT"))input.add("LEFT");
		}
		if (key.contains("RIGHT")) {
			handler.findPlayer().rightkey = true;
		}
		if (key.contains("X")) {
			if (intersecting) {
				actionobject.popup(gc);
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
			handler.findPlayer().downkey = false;
			handler.findPlayer().setVelY(0);

		}
		if (key.contains("UP")) {
			handler.findPlayer().upkey = false;
			handler.findPlayer().setVelY(0);

		}
		
		if (key.contains("LEFT")) {
			handler.findPlayer().leftkey = false;
			handler.findPlayer().setVelX(0);

		}
		if (key.contains("RIGHT")) {
			handler.findPlayer().rightkey = false;
			handler.findPlayer().setVelX(0);

		}
	}
//	public void actionKey(KeyEvent e) {
//		String key = e.getCode().toString();
//		
//	}
	
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
