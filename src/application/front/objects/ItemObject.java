package application.front.objects;

import application.back.enums.ID;
import application.back.enums.Location;
import application.back.enums.Tag;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class ItemObject extends GameObject {

	public ItemObject(double x, double y) {
		super(x, y);

	}

	public ItemObject(double x, double y, ID id) {
		super(x, y, id);

	}

	public ItemObject(double x, double y, double width, double height) {
		super(x, y, width, height);

	}

	public ItemObject(double x, double y, double width, double height, ID id) {
		super(x, y, width, height, id);

	}

	public ItemObject(double x, double y, double width, double height, ID id, Tag tag) {
		super(x, y, width, height, id, tag);

	}

	public ItemObject(double x, double y, double width, double height, Image image, ID id, Tag tag) {
		super(x, y, width, height, image, id, tag);

	}

	public ItemObject(double x, double y, double width, double height, Image image, ID id, Tag tag, Location location) {
		super(x, y, width, height, image, id, tag, location);

	}

	@Override
	public void tick() {
		

	}

	@Override
	public void tick(GameObject obj) {
		
	}

	@Override
	public void animate(double time, double duration) {
		
	}

	@Override
	public void animate(double time, double duration, double playerX, double playerY) {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(GraphicsContext gc) {
		// TODO Auto-generated method stub

	}

	@Override
	public Boundary getBoundary() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean intersects(GameObject object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean intersects(Boundary bound) {
		// TODO Auto-generated method stub
		return false;
	}

}
