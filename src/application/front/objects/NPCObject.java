package application.front.objects;

import application.back.enums.ID;
import application.back.enums.Tag;
import application.back.managers.Handler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class NPCObject extends GameObject {
	private String name;
	private String[] voicemap;
//	private double volume = .07;
	
	public NPCObject(double x, double y) {
		super(x, y);
		this.maxX = x + width;
		this.maxY = y + height;
		this.objecttext = "";
		this.name = "";
		this.sound = "";
		this.volume = .07;

	}

	public NPCObject(double x, double y, ID id) {
		super(x, y, id);
		this.maxX = x + width;
		this.maxY = y + height;
		this.objecttext = "";
		this.name = "";
		this.sound = "";
		this.volume = .07;

	}

	public NPCObject(double x, double y, double width, double height) {
		super(x, y, width, height);
		this.maxX = x + width;
		this.maxY = y + height;
		this.objecttext = "";
		this.name = "";
		this.sound = "";
		this.volume = .07;

	}

	public NPCObject(double x, double y, double width, double height, ID id) {
		super(x, y, width, height, id);
		this.maxX = x + width;
		this.maxY = y + height;
		this.objecttext = "";
		this.name = "";
		this.sound = "";
		this.volume = .07;

	}

	public NPCObject(double x, double y, double width, double height, ID id, Tag tag) {
		super(x, y, width, height, id, tag);
		this.maxX = x + width;
		this.maxY = y + height;
		this.objecttext = "";
		this.name = "";
		this.sound = "";
		this.volume = .07;

	}

	public NPCObject(double x, double y, double width, double height, Image image, ID id, Tag tag) {
		super(x, y, width, height, image, id, tag);
		this.maxX = x + width;
		this.maxY = y + height;
		this.objecttext = "";
		this.name = "";
		this.sound = "";
		this.volume = .07;

	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the voicemap
	 */
	public String[] getVoicemap() {
		return voicemap;
	}

	/**
	 * @param voicemap the voicemap to set
	 */
	public void setVoicemap(String[] voicemap) {
		this.voicemap = voicemap;
	}
	public void setVoicemap(String voiceA, String voiceB, String voiceC) {
		this.voicemap = new String[]{voiceA, voiceB, voiceC};
	}

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
	public void animate(double time, double duration, double playerX, double playerY) {
		int index = (int) ((time % (frames.length * duration)) / duration);
		this.image = frames[index];	
	}

	@Override
	public void render(GraphicsContext gc) {
		gc.drawImage(image, x, y);
	}

	@Override
	public Boundary getBoundary() {
		return new Boundary(x, y, width, height);
	}

	@Override
	public boolean intersects(GameObject object) {
		return object.getBoundary().intersects(this.getBoundary());
	}
	@Override
	public boolean intersects(Boundary bound) {
		return bound.intersects(this.getBoundary());
	}
	public boolean intersectsAny() {
		for (GameObject temp : Handler.objectlist) {
			if (temp.getId() == ID.COLLIDABLE) {
				if (temp.getBoundary().intersects(this.getBoundary())) {
					return true;
				}
			}
		}
		return false;
	}

}
