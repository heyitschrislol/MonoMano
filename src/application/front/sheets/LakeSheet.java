package application.front.sheets;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import application.front.objects.Boundary;
import javafx.collections.ObservableList;
import javafx.scene.canvas.GraphicsContext;

public class LakeSheet extends Sheet {

	public LakeSheet(int startX, int startY) throws FileNotFoundException {
		super(startX, startY);
		
		
	}
	
	@Override
	public void enter() {


	}

	@Override
	public ObservableList<Boundary> objectBoundaries() {

		return null;
	}

	@Override
	public ArrayList<Boundary> createExitList() {

		return null;
	}

	@Override
	public void render(GraphicsContext gc) {


	}

	@Override
	public void awake() {
		// TODO Auto-generated method stub
		
	}

}
