package application.front.objects;

import application.back.enums.ID;
import application.front.Base;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class PlayerObject extends GameObject {
	private Image[] idles;
	
	
//#########---	C O N S T R U C T O R S	---#############################################

	public PlayerObject(int x, int y, ID id) {
		super(x, y, id);
	}

	public PlayerObject(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	public PlayerObject(int x, int y, int width, int height, ID id) {
		super(x, y, width, height, id);
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

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		x = Base.clamp(x, 0, Base.WIDTH - 64);
		y = Base.clamp(y, 0, Base.HEIGHT - 64);
	}

	@Override
	public void tick(int velX, int velY) {
		this.velX = velX;
		this.velY = velY;
		x += velX;
		y += velY;
		
		x = Base.clamp(x, 0, Base.WIDTH - 64);
		y = Base.clamp(y, 0, Base.HEIGHT - 64);
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
	public Rectangle2D getBoundary() {
		return new Rectangle2D(x, y, width, height);
	}

	@Override
	public boolean intersects(GameObject object) {
		return object.getBoundary().intersects(this.getBoundary());
	}

	
	
	
	
	
//	@Override
//	public void tick(int velX, int velY, double time, double duration) {
//		int index = (int) ((time % (frames.length * duration)) / duration);
//		this.image = frames[index];
//		this.velX = velX;
//		this.velY = velY;
//		x += velX;
//		y += velY;
//	}
}
