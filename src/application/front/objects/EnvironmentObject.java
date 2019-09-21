package application.front.objects;

import application.back.enums.ID;
import application.front.Handler;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class EnvironmentObject extends GameObject {
	private Image image;
	private Image[] frames;
	
	//#########---	C O N S T R U C T O R S	---#############################################

	public EnvironmentObject(double x, double y, ID id) {
		super(x, y, id);
	}

	public EnvironmentObject(double x, double y, double width, double height) {
		super(x, y, width, height);
		this.maxX = x + width;
		this.maxY = y + height;
	}
	public EnvironmentObject(double x, double y, double width, double height, ID id) {
		super(x, y, width, height, id);
		this.maxX = x + width;
		this.maxY = y + height;
	}

	
	//#########---	G E T / S E T	---#############################################

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
	

	//#########---	M E T H O D S	---#############################################

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
	
	@Override
	public void animate(double time, double duration) {
		int index = (int) ((time % (frames.length * duration)) / duration);
		this.image = frames[index];
	}

	@Override
	public void render(GraphicsContext gc) {
		gc.setStroke(Color.BLACK);
		gc.drawImage(image, x, y);
		gc.stroke();
	}

	@Override
	public Rectangle2D getBoundary() {
		return new Rectangle2D(x, y, width, height);
	}

	public int intersects() {
		for (GameObject temp : Handler.objectlist) {
			if (temp.getId() != ID.ENVIRONMENT) {
				if (temp.getBoundary().intersects(this.getBoundary())) {
					Handler.objectlist.indexOf(temp);
				}
			}
		}
		return -1;
	}
	@Override
	public boolean intersects(GameObject object) {
		return object.getBoundary().intersects(this.getBoundary());
	}
	
	

}
