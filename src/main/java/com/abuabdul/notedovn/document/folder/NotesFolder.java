package com.abuabdul.notedovn.document.folder;

import com.abuabdul.notedovn.document.model.ScratchNote;

/**
 * @author abuabdul
 *
 */
public class NotesFolder {

	private ScratchNote oneInTrioNote;
	private ScratchNote twoInTrioNote;
	private ScratchNote threeInTrioNote;

	public NotesFolder() {
	}

	public ScratchNote get(int seq) {
		return seq == 1 ? oneInTrioNote : seq == 2 ? twoInTrioNote : seq == 3 ? threeInTrioNote : new ScratchNote();
	}

	public void set(int seq, ScratchNote note) {
		switch (seq) {
		case 1:
			setOneInTrioNote(note);
			break;
		case 2:
			setTwoInTrioNote(note);
			break;
		case 3:
			setThreeInTrioNote(note);
			break;
		default:
		}
	}

	/**
	 * @return the oneInTrioNote
	 */
	public ScratchNote getOneInTrioNote() {
		return oneInTrioNote != null ? oneInTrioNote : new ScratchNote();
	}

	/**
	 * @param oneInTrioNote
	 *            the oneInTrioNote to set
	 */
	public void setOneInTrioNote(ScratchNote oneInTrioNote) {
		this.oneInTrioNote = oneInTrioNote;
	}

	/**
	 * @return the twoInTrioNote
	 */
	public ScratchNote getTwoInTrioNote() {
		return twoInTrioNote != null ? twoInTrioNote : new ScratchNote();
	}

	/**
	 * @param twoInTrioNote
	 *            the twoInTrioNote to set
	 */
	public void setTwoInTrioNote(ScratchNote twoInTrioNote) {
		this.twoInTrioNote = twoInTrioNote;
	}

	/**
	 * @return the threeInTrioNote
	 */
	public ScratchNote getThreeInTrioNote() {
		return threeInTrioNote != null ? threeInTrioNote : new ScratchNote();
	}

	/**
	 * @param threeInTrioNote
	 *            the threeInTrioNote to set
	 */
	public void setThreeInTrioNote(ScratchNote threeInTrioNote) {
		this.threeInTrioNote = threeInTrioNote;
	}
}
