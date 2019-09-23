package application.back;

import application.back.enums.*;
import application.front.objects.GameObject;
import javafx.geometry.Rectangle2D;

public class Boundary extends Rectangle2D {
	private ID id;
	private Tag tag;
	private GameObject obj;
	

	public Boundary(double minX, double minY, double width, double height) {
		super(minX, minY, width, height);
		// TODO Auto-generated constructor stub
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

	/**
	 * @return the object
	 */
	public GameObject getObj() {
		return obj;
	}

	/**
	 * @param object the object to set
	 */
	public void setObj(GameObject object) {
		this.obj = object;
	}
}
