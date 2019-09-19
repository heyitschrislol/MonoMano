package application.front.objects;

import java.util.ArrayList;

import application.front.Base;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class PlayerObject extends LiveObject {
	private Image[] idles;
	private ArrayList<String> boundaries = new ArrayList<>();
	
	//#########---	C O N S T R U C T O R S	---#############################################

	public PlayerObject(int x, int y) {
		super(x, y);
	}
	
	public PlayerObject(int x, int y, Image image) {
		super(x, y);
		this.image = image;
	}

	public PlayerObject(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
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
	/**
	 * @return the boundaries
	 */
	public ArrayList<String> getBoundaries() {
		return boundaries;
	}

	/**
	 * @param boundaries the boundaries to set
	 */
	public void setBoundaries(ArrayList<String> boundaries) {
		this.boundaries = boundaries;
	}
	
	
	


	//#########---	M E T H O D S	---#############################################
	public void addBoundary(String direction) {
		if (!boundaries.contains(direction))
		boundaries.add(direction);
	}
	public void removeBoundary(String direction) {
		if (boundaries.contains(direction))
		boundaries.remove(direction);
	}
	
	@Override
	public int[] objectSize() {
		int[] size = new int[4];
		size[0] = x;
		size[1] = width;
		size[2] = y;
		size[3] = height;
		return size;
	}

	@Override
	public void tick(int velX, int velY, double time, double duration) {
		int index = (int) ((time % (frames.length * duration)) / duration);
		this.image = frames[index];
		this.velX = velX;
		this.velY = velY;
		
		
		x += velX;
		y += velY;
		
		x = Base.clamp(x, 0, Base.WIDTH - 64);
		y = Base.clamp(y, 0, Base.HEIGHT - 64);
		
	}
	
	@Override
	public void render(GraphicsContext gc) {
		gc.drawImage(image, x, y);
	}

	@Override
	public Rectangle2D getBoundary() {
		return new Rectangle2D(x, y, width, height);
	}

	@Override
	public boolean intersects(GameObject object) {
		return object.getBoundary().intersects(this.getBoundary());
	}

}
