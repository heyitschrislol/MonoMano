package application.front.objects;

import application.back.enums.ID;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;

public abstract class GameObject {
	protected ID id;
	protected int x;
	protected int y;
	protected int velX;
	protected int velY;
	protected int width;
	protected int height;
	
	
	//#########---	C O N S T R U C T O R S	---#############################################

	public GameObject(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	public GameObject(int x, int y, int width, int height, ID id) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	//#########---	G E T / S E T	---#############################################

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
	 * @return the y
	 */
	public int getVelX() {
		return velX;
	}

	/**
	 * @param y the y to set
	 */
	public void setVelX(int velX) {
		this.velX = velX;
	}
	/**
	 * @return the y
	 */
	public int getVelY() {
		return velY;
	}

	/**
	 * @param y the y to set
	 */
	public void setVelY(int velY) {
		this.velY = velY;
	}
	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	/**
	 * @param ID the id to get
	 */
	public ID getID() {
		return id;
	}
	/**
	 * @param ID the id to set
	 */
	public void setID(ID id) {
		this.id = id;
	}
	
	//#########---	M E T H O D S	---#############################################

	public abstract void tick();
	public abstract void tick(int velX, int velY);
	public abstract void tick(int velX, int velY, double time, double duration);
	public abstract void render();
	public abstract void render(GraphicsContext gc);
	public abstract Rectangle2D getBoundary();
	public abstract boolean intersects(GameObject object);

	

}
