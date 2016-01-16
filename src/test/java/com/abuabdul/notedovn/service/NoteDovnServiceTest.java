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

public class NoteDovnServiceTest {

	@Mock
	private NoteDovnDAO noteDovnDAO;

	@InjectMocks
	private NoteDovnServiceImpl noteDovnService;

	@BeforeClass
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test(groups = "integration")
	public void testMakeScratchNote() throws NoteDovnServiceException {
		ScratchNote note = new ScratchNote();
		noteDovnService.makeScratchNote(note);
		verify(noteDovnDAO).saveNote(note);
	}

	@Test(groups = "integration")
	public void testStrikeScratchNote() throws NoteDovnServiceException {
		ScratchNote note = new ScratchNote();
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
