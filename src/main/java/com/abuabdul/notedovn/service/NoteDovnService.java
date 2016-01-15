package com.abuabdul.notedovn.service;

import java.util.List;

import com.abuabdul.notedovn.document.model.ScratchNote;
import com.abuabdul.notedovn.exception.NoteDovnServiceException;

/**
 * @author abuabdul
 *
 */
public interface NoteDovnService {

	void makeScratchNote(ScratchNote note) throws NoteDovnServiceException;

	void strikeScratchNote(ScratchNote note) throws NoteDovnServiceException;

	void updateScratchNote(String id, String key, String value) throws NoteDovnServiceException;

	List<ScratchNote> publishAllScratchNotes() throws NoteDovnServiceException;

}
