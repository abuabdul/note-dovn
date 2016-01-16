package com.abuabdul.notedovn.service;

import java.util.LinkedList;

import com.abuabdul.notedovn.dao.NoteDovnDAO;
import com.abuabdul.notedovn.document.model.ScratchNote;
import com.abuabdul.notedovn.exception.NoteDovnServiceException;

/**
 * @author abuabdul
 */
public class NoteDovnServiceImpl implements NoteDovnService {

	private final NoteDovnDAO noteDovnDAO;

	public NoteDovnServiceImpl(NoteDovnDAO noteDovnDAO) {
		this.noteDovnDAO = noteDovnDAO;
	}

	@Override
	public void makeScratchNote(ScratchNote note) throws NoteDovnServiceException {
		noteDovnDAO.saveNote(note);
	}

	@Override
	public void strikeScratchNote(ScratchNote note) throws NoteDovnServiceException {
		noteDovnDAO.removeNote(note);
	}

	@Override
	public LinkedList<ScratchNote> publishAllScratchNotes() throws NoteDovnServiceException {
		return new LinkedList<ScratchNote>(noteDovnDAO.findAll());
	}

	@Override
	public void updateScratchNote(String id, String key, String value) throws NoteDovnServiceException {
		noteDovnDAO.updateNote(id, key, value);
	}
}
