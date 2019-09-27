package application.back.managers;

import application.back.enums.ID;
import application.back.enums.Tag;
import application.front.objects.EnvironmentObject;
import application.front.objects.GameObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class SceneManager {
	public ObservableList<GameObject> objectlist = FXCollections.observableArrayList();
	public SceneManager() {
		
	}
	public void changeScene(GraphicsContext ngc, Canvas canvas) {
		
	}

}
