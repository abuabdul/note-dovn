package com.abuabdul.notedovn.document.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author abuabdul
 *
 */
@Document(collection = "scratchpad")
public class ScratchNote {

	@Id
	private String id;
	private String category;
	private String aboutNote;
	private String reasonNote;
	private String noteMsg;
	private String sideNote;

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

	/**
	 * @return the aboutNote
	 */
	public String getAboutNote() {
		return aboutNote;
	}

	/**
	 * @param aboutNote
	 *            the aboutNote to set
	 */
	public void setAboutNote(String aboutNote) {
		this.aboutNote = aboutNote;
	}

	/**
	 * @return the reasonNote
	 */
	public String getReasonNote() {
		return reasonNote;
	}

	/**
	 * @param reasonNote
	 *            the reasonNote to set
	 */
	public void setReasonNote(String reasonNote) {
		this.reasonNote = reasonNote;
	}

	/**
	 * @return the noteMsg
	 */
	public String getNoteMsg() {
		return noteMsg;
	}

	/**
	 * @param noteMsg
	 *            the noteMsg to set
	 */
	public void setNoteMsg(String noteMsg) {
		this.noteMsg = noteMsg;
	}

	/**
	 * @return the sideNote
	 */
	public String getSideNote() {
		return sideNote;
	}

	/**
	 * @param sideNote
	 *            the sideNote to set
	 */
	public void setSideNote(String sideNote) {
		this.sideNote = sideNote;
	}
}
