package application.front.sheets;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import application.back.managers.Handler;
import application.back.managers.SoundManager;
import application.front.controllers.StartController;
import application.front.objects.Boundary;
import application.front.objects.PlayerObject;
import javafx.collections.ObservableList;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

public class IntroSheet extends Sheet {

	public IntroSheet() {
		ImageView startscene = new ImageView();
        startscene.setImage(new Image(this.getClass().getResource("/application/assets/sprites/startscene.gif").toExternalForm()));
        SoundManager.nftsb.playSong();
        
		getChildren().add(startscene);
		
		
        
	}

	
	public IntroSheet(int startX, int startY) {
		super(startX, startY);

	}

	public IntroSheet(PlayerObject player) {
		super(player);

	}

//	public void startMenu(KeyEvent k) throws FileNotFoundException {
//		String key = k.getCode().toString();
//		if (key.contains("ENTER")) {
//			StartController starter = new StartController(352, 244);
//			Handler.changeScene(starter);
//			
//			Handler.setObjectlist(starter.sheet.getObjectlist());
//		}
//	}
	@Override
	public void enter() {

		
	}

	@Override
	public ObservableList<Boundary> objectBoundaries() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Boundary> createExitList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void render(GraphicsContext gc) {
		// TODO Auto-generated method stub

	}

	@Override
	public void awake() {
		// TODO Auto-generated method stub

	}

}
