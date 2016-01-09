package com.abuabdul.notedovn.service;

import java.util.List;

import com.abuabdul.notedovn.dao.NoteDovnDAO;
import com.abuabdul.notedovn.document.model.ScratchNote;
import com.abuabdul.notedovn.exception.NoteDovnServiceException;

/**
 * @author abuabdul
 *
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
	public List<ScratchNote> publishAllScratchNotes() throws NoteDovnServiceException {
		return noteDovnDAO.findAll();
	}

}
