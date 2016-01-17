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

import static org.mockito.Mockito.verify;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.abuabdul.notedovn.dao.NoteDovnDAO;
import com.abuabdul.notedovn.document.model.ScratchNote;
import com.abuabdul.notedovn.exception.NoteDovnServiceException;

/**
 * @author abuabdul
 *
 */
public class NoteDovnServiceTest {

	@Mock
	private NoteDovnDAO noteDovnDAO;

	@InjectMocks
	private NoteDovnServiceImpl noteDovnService;

	@Mock
	private ScratchNote note;

	@BeforeClass
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test(groups = "integration")
	public void testMakeScratchNote() throws NoteDovnServiceException {
		noteDovnService.makeScratchNote(note);
		verify(noteDovnDAO).saveNote(note);
	}

	@Test(groups = "integration")
	public void testStrikeScratchNote() throws NoteDovnServiceException {
		noteDovnService.strikeScratchNote(note);
		verify(noteDovnDAO).removeNote(note);
	}

	@Test(groups = "integration")
	public void testPublishAllScratchNotes() throws NoteDovnServiceException {
		noteDovnService.publishAllScratchNotes();
		verify(noteDovnDAO).findAll();
	}

	@Test(groups = "integration")
	public void testUpdateScratchNote() throws NoteDovnServiceException {
		noteDovnService.updateScratchNote("pk", "name", "someValue");
		verify(noteDovnDAO).updateNote("pk", "name", "someValue");
	}
}
