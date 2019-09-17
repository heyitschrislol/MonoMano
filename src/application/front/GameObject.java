package application.front;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;

public abstract class GameObject {
	protected int x;
	protected int y;
	protected int velX, velY;
	
	
	//#########---	C O N S T R U C T O R S	---#############################################

	public GameObject(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public GameObject(int x, int y, int velX, int velY) {
		this.x = x;
		this.y = y;
		this.velX = velX;
		this.velY = velY;
	}
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	/**
	 * @return the velX
	 */
	public int getVelX() {
		return velX;
	}
	/**
	 * @param velX the velX to set
	 */
	public void setVelX(int velX) {
		this.velX = velX;
	}
	/**
	 * @return the velY
	 */
	public int getVelY() {
		return velY;
	}
	/**
	 * @param velY the velY to set
	 */
	public void setVelY(int velY) {
		this.velY = velY;
	}
	
	
	//#########---	M E T H O D S	---#############################################

	public abstract void tick(int velX, int velY);
	public abstract void tick(GraphicsContext gc, ArrayList<String> input, String last);
}
