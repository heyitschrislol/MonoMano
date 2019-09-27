package application.front.objects;

import java.util.ArrayList;

import application.back.enums.ID;
import application.back.managers.Handler;
import application.back.managers.InputManager;
import application.front.Base;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class PlayerObject extends GameObject {
	private Image[] idles;
	private double nextX;
	private double nextY;
	public boolean upkey = false;
	public boolean downkey = false;
	public boolean leftkey = false;
	public boolean rightkey = false;
	
	
	
//#########---	C O N S T R U C T O R S	---#############################################

	public PlayerObject(double x, double y, ID id) {
		super(x, y, id);
		this.objecttext = "";
	}

	public PlayerObject(double x, double y, double width, double height) {
		super(x, y, width, height);
		this.maxX = x + width;
		this.maxY = y + height;
		this.objecttext = "";
	}

	public PlayerObject(double x, double y, double width, double height, ID id) {
		super(x, y, width, height, id);
		this.maxX = x + width;
		this.maxY = y + height;
		this.objecttext = "";
	}

	
	//#########---	G E T / S E T	---#############################################

	/**
	 * @return the idles
	 */
	public Image[] getIdles() {
		return idles;
	}

	/**
	 * @param idles the idles to set
	 */
	public void setIdles(Image[] idles) {
		this.idles = idles;
	}

	
	//#########---	M E T H O D S	---#############################################

	/**
	 * @return the lastX
	 */
	public double getNextX() {
		return nextX;
	}

	/**
	 * @param lastX the lastX to set
	 */
	public void setNextX(double lastX) {
		this.nextX = lastX;
	}

	/**
	 * @return the lastY
	 */
	public double getNextY() {
		return nextY;
	}

	/**
	 * @param lastY the lastY to set
	 */
	public void setNextY(double lastY) {
		this.nextY = lastY;
	}

	/**
	 * @return the inputsnag
	 */
	

	@Override
	public void tick() {
		x += velX;
		y += velY;


	}

	@Override
	public void tick(GameObject obj) {
		x += velX;
		y += velY;
		
		
	}

	public void animate(double time, double duration) {
		int index = (int) ((time % (frames.length * duration)) / duration);
		this.image = frames[index];	
	}

	@Override
	public void render(GraphicsContext gc) {
		gc.drawImage(image, x, y);
	}

	@Override
	public Boundary getBoundary() {
		return new Boundary(x, y, width, height);
	}

	public boolean intersects() {
		for (GameObject temp : Handler.objectlist) {
			if (temp.getId() == ID.COLLIDABLE) {
				if (temp.getBoundary().intersects(this.getBoundary())) {
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public boolean intersects(GameObject object) {
		return object.getBoundary().intersects(this.getBoundary());
	}
	@Override
	public boolean intersects(Boundary bound) {
		return bound.intersects(this.getBoundary());
	}
	

//	public int intersects() {
//	for (GameObject temp : Handler.objectlist) {
//		if (temp.getId() != ID.PLAYER) {
//			if (temp.getBoundary().intersects(this.getBoundary())) {
//				return Handler.objectlist.indexOf(temp);
//			}
//		}
//	}
//	return -1;
//}
//	public GameObject intersects() {
//	for (GameObject temp : Handler.objectlist) {
//		if (temp.getId() != ID.PLAYER) {
//			if (temp.getBoundary().intersects(this.getBoundary())) {
//				return temp;
//			}
//		}
//	}
//	return null;
//}
	
	
	
	

}
