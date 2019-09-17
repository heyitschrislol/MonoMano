package application.front;

import java.util.ArrayList;

import application.back.AssetManager;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Player extends GameObject{
	private double duration;
	private Image[] walkdown;
	private Image[] walkup;
	private Image[] walkleft;
	private Image[] walkright;
	private Image[] idles;
	
	public Player(int x, int y) {
		super(x, y);
		
		idles = new Image[4];
		
		Image i1 = new Image(AssetManager.PLAYER_0);
		idles[0] = i1;
		walkdown = AssetManager.returnDown();
		Image i2 = new Image(AssetManager.PLAYER_3);
		idles[1] = i2;
		walkup = AssetManager.returnUp();
		Image i3 = new Image(AssetManager.PLAYER_6);
		idles[2] = i3;
		walkleft = AssetManager.returnLeft();
		Image i4 = new Image(AssetManager.PLAYER_9);
		idles[3] = i4;
		walkright = AssetManager.returnRight();
	}

	/**
	 * @return the duration
	 */
	public double getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(double duration) {
		this.duration = duration;
	}

	/**
	 * @return the walkdown
	 */
	public Image[] getWalkdown() {
		return walkdown;
	}

	/**
	 * @param walkdown the walkdown to set
	 */
	public void setWalkdown(Image[] walkdown) {
		this.walkdown = walkdown;
	}

	/**
	 * @return the walkup
	 */
	public Image[] getWalkup() {
		return walkup;
	}

	/**
	 * @param walkup the walkup to set
	 */
	public void setWalkup(Image[] walkup) {
		this.walkup = walkup;
	}

	/**
	 * @return the walkleft
	 */
	public Image[] getWalkleft() {
		return walkleft;
	}

	/**
	 * @param walkleft the walkleft to set
	 */
	public void setWalkleft(Image[] walkleft) {
		this.walkleft = walkleft;
	}

	/**
	 * @return the walkright
	 */
	public Image[] getWalkright() {
		return walkright;
	}

	/**
	 * @param walkright the walkright to set
	 */
	public void setWalkright(Image[] walkright) {
		this.walkright = walkright;
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

	
	
	
	
	
	@Override
	public void tick(int velX, int velY) {
		x += velX;
		y += velY;
	}
	public void tick(GraphicsContext gc, ArrayList<String> input, String last) {
		if (input.contains("DOWN")) {
			last = "DOWN";
			velY = 5;
			y += velY;
			
		} else if (input.contains("UP")) {
			last = "UP";
			velY = -5;
			y += velY;
			
		} else if (input.contains("RIGHT")) {
			last = "RIGHT";
			velX = 5;
			x += velX;
		
		} else if (input.contains("LEFT")) {
			last = "LEFT";
			velX = -5;
			x += velX;
			
		} else {
			velX = 0;
			velY = 0;
			gc.drawImage(AssetManager.findIdle(last), x, y);
		}
	}
	
	
}
