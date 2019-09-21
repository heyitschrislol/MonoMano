package application.front;

import java.awt.Graphics;
import java.util.LinkedList;

import application.back.enums.ID;
import application.front.objects.EnvironmentObject;
import application.front.objects.GameObject;
import application.front.objects.PlayerObject;
import javafx.collections.ObservableList;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;

public class Handler {
	public static ObservableList<GameObject> objectlist;

	public Handler(ObservableList<GameObject> objectlist) {
		Handler.objectlist = objectlist;
	}
	// #########---	M E T H O D S	---#############################################

		public void tick() {
			for (GameObject temp : objectlist) {
				temp.tick();
			}
		}
		public void render(GraphicsContext gc) {
			for (GameObject temp : objectlist) {
				PlayerObject player;
				temp.render(gc);
				if (temp.getID() == ID.PLAYER) {
					player = (PlayerObject) temp;
					
				}
				if (temp.getID() == ID.ENVIRONMENT) {
					
				}
			}
		}
		
		
		public void addObject(GameObject temp) {
			this.objectlist.add(temp);
		}
		public void removeObject(GameObject temp) {
			this.objectlist.remove(temp);
		}
//		if (temp.getID() != ID.PLAYER) {
//		if (Base.player.intersects(temp)) {
//			System.out.println("colliding at X: " + Base.player.getX() + " and Y: " + Base.player.getY());
//		}
//	}
}

