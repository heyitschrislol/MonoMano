package application.front.objects;

import application.back.enums.*;
import javafx.geometry.Rectangle2D;

public class Boundary extends Rectangle2D {
	private ID id;
	private Tag tag;
	private GameObject obj;
	private String label;
	

	public Boundary(double minX, double minY, double width, double height) {
		super(minX, minY, width, height);
	}
	public Boundary(double minX, double minY, double width, double height, String label) {
		super(minX, minY, width, height);
		this.label = label;
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

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}
}
