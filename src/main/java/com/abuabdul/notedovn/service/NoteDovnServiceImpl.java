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
