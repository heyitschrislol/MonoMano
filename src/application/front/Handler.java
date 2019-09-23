package application.front;

import java.awt.Graphics;
import java.util.LinkedList;

import application.back.Boundary;
import application.back.enums.ID;
import application.back.enums.Tag;
import application.front.objects.EnvironmentObject;
import application.front.objects.GameObject;
import application.front.objects.PlayerObject;
import javafx.collections.FXCollections;
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
				if (temp.getID() != ID.PLAYER) {
					temp.tick();
				}
			}
		}
		public void render(GraphicsContext gc) {
			for (GameObject temp : objectlist) {
//				PlayerObject player;
				temp.render(gc);
//				if (temp.getID() == ID.PLAYER) {
//					player = (PlayerObject) temp;
//					
//				}
//				if (temp.getID() == ID.ENVIRONMENT) {
//					
//				}
			}
		}
		
		public ObservableList<Boundary> objectBoundaries() {
			ObservableList<Boundary> bounds = FXCollections.observableArrayList();
			Boundary minx = new Boundary(Base.LOCX, Base.LOCY, 768, 0);
			minx.setTag(Tag.BORDER);
			Boundary miny = new Boundary(Base.LOCX, Base.LOCY, 0, 512);
			miny.setTag(Tag.BORDER);
			Boundary maxx = new Boundary(Base.LOCX, Base.LOCY + 512, 768, 0);
			maxx.setTag(Tag.BORDER);
			Boundary maxy = new Boundary(Base.LOCX + 768, Base.LOCY, 0, 512);
			maxy.setTag(Tag.BORDER);
			for (GameObject temp : objectlist) {
				if (temp.getId() == ID.COLLIDABLE || temp.getId() == ID.ITEM) {
					Boundary b = temp.getBoundary();
					b.setObj(temp);
					b.setId(temp.getId());
					b.setTag(temp.getTag());
					bounds.add(b);
				}
			}
			bounds.add(minx);
			bounds.add(miny);
			bounds.add(maxx);
			bounds.add(maxy);
			return bounds;
		}
		public void addObject(GameObject temp) {
			this.objectlist.add(temp);
		}
		public void removeObject(GameObject temp) {
			this.objectlist.remove(temp);
		}
		public PlayerObject findPlayer() {
			PlayerObject player;
			for (int i = 0; i < objectlist.size(); i++) {
				if (objectlist.get(i).getId() == ID.PLAYER) {
					return player = (PlayerObject) objectlist.get(i);
				}
			}
			return null;	
		}
}

