package application.front;

import java.awt.Graphics;
import java.util.LinkedList;

import application.back.enums.ID;
import application.front.objects.GameObject;
import javafx.scene.canvas.GraphicsContext;

public class Handler {
	public LinkedList<GameObject> object = new LinkedList<GameObject>();

	// #########---	M E T H O D S	---#############################################

		public void tick() {
			for (int i = 0; i < object.size(); i++) {
				// function of LinkedList that allows us to get object id of our current object (i)
				GameObject temp = object.get(i);
				temp.tick();
			}
		}
		public void render(GraphicsContext gc) {
			for (int i = 0; i < object.size(); i++) {
				// function of LinkedList that allows us to get object id of our current object (i)
				GameObject tempObject = object.get(i);
				tempObject.render(gc);
			}
		}
		
		public void addObject(GameObject object) {
			this.object.add(object);
		}
		public void removeObject(GameObject object) {
			this.object.remove(object);
		}
	
}

