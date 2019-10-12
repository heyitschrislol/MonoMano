package application.front.objects;

import java.util.ArrayList;

import application.back.enums.ID;
import application.back.enums.Location;
import application.back.enums.Tag;
import application.back.managers.Animator;
import application.front.sheets.Sheet;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class GameObject {
	public ArrayList<String> footsteps;
	protected static GameObject instance;
	protected Animator animator;
	protected String name;
	protected String[] voicemap;
	protected String sound;
	protected double volume;
	protected ID id;
	public Location location;
	protected Tag tag;
	protected double x;
	protected double y;
	protected double maxX;
	protected double maxY;
	protected double velX;
	protected double velY;
	protected double width;
	protected double height;
	protected String objecttext;
	protected Image image;
	protected Image[] frames;
	
	
	//#########---	C O N S T R U C T O R S	---#############################################

	public GameObject(double x, double y) {
		this.x = x;
		this.y = y;
		this.objecttext = "";
		this.sound = "";
		
	}
	public GameObject(double x, double y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
		this.objecttext = "";
		this.sound = "";


	}
	public GameObject(double x, double y, double width, double height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.maxX = x + width;
		this.maxY = y + height;
		this.objecttext = "";
		this.sound = "";

	}
	public GameObject(double x, double y, double width, double height, ID id) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.maxX = x + width;
		this.maxY = y + height;
		this.id = id;
		this.objecttext = "";
		this.sound = "";

	}
	public GameObject(double x, double y, double width, double height, ID id, Tag tag) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.maxX = x + width;
		this.maxY = y + height;
		this.id = id;
		this.tag = tag;
		this.objecttext = "";
		this.sound = "";

	}
	public GameObject(double x, double y, double width, double height, Image image, ID id, Tag tag) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.maxX = x + width;
		this.maxY = y + height;
		this.id = id;
		this.tag = tag;
		this.image = image;
		this.objecttext = "";
		this.sound = "";

	}
	public GameObject(double x, double y, double width, double height, Image image, ID id, Tag tag, Location location) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.maxX = x + width;
		this.maxY = y + height;
		this.id = id;
		this.tag = tag;
		this.image = image;
		this.location = location;
		this.objecttext = "";
		this.sound = "";
	}

	//#########---	G E T / S E T	---#############################################

	/**
	 * @return the footsteps
	 */
	public ArrayList<String> getFootsteps() {
		return footsteps;
	}
	/**
	 * @param footsteps the footsteps to set
	 */
	public void setFootsteps(ArrayList<String> footsteps) {
		this.footsteps = footsteps;
	}
	/**
	 * @return the animator
	 */
	public Animator getAnimator() {
		return animator;
	}
	/**
	 * @param animator the animator to set
	 */
	public void setAnimator(Animator animator) {
		this.animator = animator;
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
	/**
	 * @return the sound
	 */
	public String getSound() {
		return sound;
	}
	/**
	 * @param sound the sound to set
	 */
	public void setSound(String sound) {
		this.sound = sound;
	}
	/**
	 * @return the volume
	 */
	public double getVolume() {
		return volume;
	}
	/**
	 * @param volume the volume to set
	 */
	public void setVolume(double volume) {
		this.volume = volume;
	}
	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public double getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(double y) {
		this.y = y;
	}
	/**
	 * @return the y
	 */
	public double getVelX() {
		return velX;
	}

	/**
	 * @param y the y to set
	 */
	public void setVelX(double velX) {
		this.velX = velX;
	}
	/**
	 * @return the y
	 */
	public double getVelY() {
		return velY;
	}

	/**
	 * @param y the y to set
	 */
	public void setVelY(double velY) {
		this.velY = velY;
	}
	/**
	 * @return the width
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(double width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}
	/**
	 * @param ID the id to get
	 */
	public ID getID() {
		return id;
	}
	/**
	 * @param ID the id to set
	 */
	public void setID(ID id) {
		this.id = id;
	}
	/**
	 * @return the id
	 */
	public ID getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(ID id) {
		this.id = id;
	}
	/**
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(Location location) {
		this.location = location;
	}
	/**
	 * @return the maxX
	 */
	public double getMaxX() {
		return maxX;
	}
	/**
	 * @param maxX the maxX to set
	 */
	public void setMaxX(double maxX) {
		this.maxX = maxX;
	}
	/**
	 * @return the maxY
	 */
	public double getMaxY() {
		return maxY;
	}
	/**
	 * @param maxY the maxY to set
	 */
	public void setMaxY(double maxY) {
		this.maxY = maxY;
	}
	/**
	 * @return the objecttext
	 */
	public String getObjecttext() {
		return objecttext;
	}
	/**
	 * @param objecttext the objecttext to set
	 */
	public void setObjecttext(String objecttext) {
		this.objecttext = objecttext;
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


	
	
	
	public abstract void tick();
	public abstract void tick(GameObject obj);
	public abstract void animate(double time, double duration);
	public abstract void animate(double time, double duration, double playerX, double playerY);
//	public abstract void awake();
//	public abstract void clearpopup(GraphicsContext gc);
	public abstract void render(GraphicsContext gc);
	public abstract Boundary getBoundary();
	public abstract boolean intersects(GameObject object);
	public abstract boolean intersects(Boundary bound);

	
//	public abstract void tick(double velX, double velY, double time, double duration);

}
