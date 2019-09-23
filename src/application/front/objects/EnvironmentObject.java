package application.front.objects;

import java.util.ArrayList;

import application.back.Boundary;
import application.back.enums.ID;
import application.back.enums.Tag;
import application.front.Handler;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class EnvironmentObject extends GameObject {
	private Image image;
	private Image[] frames;
	private Tag tag;
	private boolean popup = false;
	
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

	/**
	 * @return the tag
	 */
	public Tag getTag() {
		return tag;
	}

	/**
	 * @param tag the tag to set
	 */
	public void setTag(Tag tag) {
		this.tag = tag;
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
	public void popup(GraphicsContext gc) {
//		if (!popup) {
//			gc.setFill(Color.LIGHTSALMON);
//			gc.fillRoundRect(128.0, 258.0, 512.0, 256.0, 0, 0);
//			gc.fillText(getObjecttext(), 256, 256);
//		} else {
//			gc.clearRect(128.0,  258.0, 512.0, 256.0);
//		}
		System.out.println(getObjecttext());
		
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
	
	

}
