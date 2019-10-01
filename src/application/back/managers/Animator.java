package application.back.managers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Animator extends Transition {

	private Image image;
	private int count;
	private int rows;
	private Asset asset;
    //space between LEFT edge of image and first FRAME start
	private int offsetX;
    //space between TOP edge of image and first ROW start
	private int offsetY;
    //width of each frame
	private int width;
    //height of each frame
	private int height;

	private int lastIndex;
	
	public Animator(String sheetname, Duration duration, int count, int rows, int offsetX, int offsetY, int width,
			int height) {
		image = new Image(sheetname);
		this.count = count;
		this.rows = rows;
		this.offsetX = offsetX;
		this.offsetY = offsetY;
		this.width = width;
		this.height = height;
		setCycleDuration(duration);
		setInterpolator(Interpolator.LINEAR);
	}
	public Animator(String sheetname, Duration duration, int width, int height) {
		Asset asset = Asset.findAsset(sheetname);
		image = new Image(asset.getUrl());
		this.count = asset.getCount();
		this.rows = asset.getRows();
		this.offsetX = asset.getOffsetX();
		this.offsetY = asset.getOffsetY();
		this.width = width;
		this.height = height;
		setCycleDuration(duration);
		setInterpolator(Interpolator.LINEAR);
	}
	@Override
	protected void interpolate(double arg0) {
		// TODO Auto-generated method stub
		
	}

//	protected void interpolate(double k) {
//		final int index = Math.min((int) Math.floor(k * count), count - 1);
//		if (index != lastIndex) {
//			final int x = (index % columns) * width + offsetX;
//			final int y = (index / columns) * height + offsetY;
//			imageView.setViewport(new Rectangle2D(x, y, width, height));
//			lastIndex = index;
//		}
//	}

//	public Image[] sprites() {
//		
//	}
}
