/*
 * Copyright 2013-2016 abuabdul.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package com.abuabdul.notedovn.document.model;

import static com.abuabdul.notedovn.util.NoteDovnUtil.getUTCDateTime;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author abuabdul
 *
 */
@Document(collection = ScratchNote.COLLECTION_NAME)
public class ScratchNote {

	public static final String COLLECTION_NAME = "scratchpad";

	@Id
	private String id;
	private String category;
	private String aboutNote;
	private String reasonNote;
	private String noteMsg;
	private String sideNote;
	private Date createdDate = getUTCDateTime();
	private Date updatedDate = getUTCDateTime();

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

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate
	 *            the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the updatedDate
	 */
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate
	 *            the updatedDate to set
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
}
