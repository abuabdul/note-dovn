package com.abuabdul.notedovn.dao;

import java.util.List;

import com.abuabdul.notedovn.document.model.ScratchNote;
import com.abuabdul.notedovn.exception.NoteDovnServiceException;

/**
 * @author abuabdul
 *
 */
public interface NoteDovnDAO {

	void saveNote(ScratchNote note) throws NoteDovnServiceException;

	ScratchNote findNote(String id) throws NoteDovnServiceException;

	List<ScratchNote> findAll() throws NoteDovnServiceException;

	void updateNote(String id, String key, Object value) throws NoteDovnServiceException;

	void removeNote(ScratchNote note) throws NoteDovnServiceException;
}
