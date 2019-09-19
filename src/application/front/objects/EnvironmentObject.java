package application.front.objects;

import application.back.enums.ID;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class EnvironmentObject extends GameObject {
	private Image image;
	private Image[] frames;
	
	public EnvironmentObject(int x, int y, ID id) {
		super(x, y, id);
	}
	public EnvironmentObject(int x, int y, Image image) {
		super(x, y);
		this.image = image;
	}

	public EnvironmentObject(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	/**
	 * @return the image
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
	

	@Override
	public void tick() {
		x += velX;
		y += velY;
	}
	
	@Override
	public void tick(int velX, int velY) {
		this.velX = velX;
		this.velY = velY;
		x += velX;
		y += velY;
	}
	
	@Override
	public void animate(double time, double duration) {
		int index = (int) ((time % (frames.length * duration)) / duration);
		this.image = frames[index];
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
