package application.front.sheets;

import java.util.ArrayList;

import application.back.managers.SoundManager;
import application.front.objects.Boundary;
import application.front.objects.PlayerObject;
import javafx.collections.ObservableList;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class StartSheet extends Sheet {

	public StartSheet() {
		ImageView startscene = new ImageView();
        startscene.setImage(new Image(this.getClass().getResource("/application/assets/sprites/startscene.gif").toExternalForm()));
        SoundManager.nftsb.playSong();
        
		getChildren().add(startscene);
			
        
	}

	public StartSheet(int startX, int startY) {
		super(startX, startY);

	}

	public StartSheet(PlayerObject player) {
		super(player);

	}

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
