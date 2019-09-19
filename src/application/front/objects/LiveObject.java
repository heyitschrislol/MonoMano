package application.front.objects;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class LiveObject extends GameObject {
	protected Image image;
	protected Image[] frames;
	
	//#########---	C O N S T R U C T O R S	---#############################################
	
	
	public LiveObject(int x, int y) {
		super(x, y);
	}
	public LiveObject(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	public LiveObject(int x, int y, Image image) {
		super(x, y);
		this.image = image;
	}
	
	//#########---	G E T / S E T	---#############################################

	/**
	 * @param image the image to set
	 */
	public Image getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(Image image) {
		this.image = image;
	}
	/**
	 * @return the frames
	 */
	public Image[] getFrames() {
		return frames;
	}
	/**
	 * @param frames the frames to set
	 */
	public void setFrames(Image[] frames) {
		this.frames = frames;
	}
	
	
	//#########---	M E T H O D S	---#############################################
	
	public int[] objectSize() {
		int[] size = new int[4];
		size[0] = x;
		size[1] = width;
		size[2] = y;
		size[3] = height;
		return size;
	}
	
	@Override
	public void tick(int velX, int velY) {
		this.velX = velX;
		this.velY = velY;
		x += velX;
		y += velY;
	}
	@Override
	public void tick(int velX, int velY, double time, double duration) {
		int index = (int) ((time % (frames.length * duration)) / duration);
		this.image = frames[index];
		this.velX = velX;
		this.velY = velY;
		x += velX;
		y += velY;
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
