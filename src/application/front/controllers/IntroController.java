package application.front.controllers;

import java.io.FileNotFoundException;

import application.back.managers.Handler;
import application.front.sheets.IntroSheet;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

public class IntroController extends Controller {
	public IntroSheet sheet;
	public Scene scene;
	public IntroController() {
		sheet = new IntroSheet();
		scene = new Scene(sheet);
		scene.setOnKeyPressed(e -> {
			try {
//				SoundManager.bgins.playClip("start");

				startMenu(e);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		});
	}

	public IntroController(int exitX, int exitY) {
		super(exitX, exitY);
		// TODO Auto-generated constructor stub
	}

	public void startMenu(KeyEvent k) throws FileNotFoundException {
		String key = k.getCode().toString();
		if (key.contains("ENTER")) {
			StartController starter = new StartController(352, 244);
			Handler.changeScene(starter);
			
			Handler.setObjectlist(starter.sheet.getObjectlist());
		}
		
		
	}
}
