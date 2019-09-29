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

	private final ImageView imageView;
	private final int count;
	private final int columns;
	private Asset asset;
    //space between LEFT edge of image and first FRAME start
	private final int offsetX;
    //space between TOP edge of image and first ROW start
	private final int offsetY;
    //width of each frame
	private final int width;
    //height of each frame
	private final int height;

	private int lastIndex;
	
	public Animator(String sheetname, Duration duration, int count, int columns, int offsetX, int offsetY, int width,
			int height) {
		imageView = new ImageView(sheetname);
		this.count = count;
		this.columns = columns;
		this.offsetX = offsetX;
		this.offsetY = offsetY;
		this.width = width;
		this.height = height;
		setCycleDuration(duration);
		setInterpolator(Interpolator.LINEAR);
	}
	public Animator(String sheetname, Duration duration, Asset asset, int width, int height) {
		imageView = new ImageView(Asset.assetImage(sheetname));
		this.asset = asset;
		this.count = asset.getCount();
		this.columns = asset.getCount();
		this.offsetX = asset.getOffsetX();
		this.offsetY = asset.getOffsetY();
		this.width = width;
		this.height = height;
		setCycleDuration(duration);
		setInterpolator(Interpolator.LINEAR);
	}

	protected void interpolate(double k) {
		final int index = Math.min((int) Math.floor(k * count), count - 1);
		if (index != lastIndex) {
			final int x = (index % columns) * width + offsetX;
			final int y = (index / columns) * height + offsetY;
			imageView.setViewport(new Rectangle2D(x, y, width, height));
			lastIndex = index;
		}
	}

	public ImageView[] animate(int row) throws FileNotFoundException {

		ImageView[] frames = new ImageView[asset.getCount()];
		
		int minx = 0 + offsetX;
		int miny = row * height;
		int maxy = miny + height;
		int maxx = asset.getSheetWidth();
		
		for (int i = 0; i < asset.getCount(); i++ ) {
			imageView.setViewport(new Rectangle2D(minx, miny, width, height));
			frames[i] = imageView;
			minx += width + offsetX;
		}
		
		return frames;
	}
}
