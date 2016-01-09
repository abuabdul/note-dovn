package com.abuabdul.notedovn.document.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author abuabdul
 *
 */
@Document(collection = "scratchpad")
public class ScratchNote {

	private String id;
	private String category;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
}
