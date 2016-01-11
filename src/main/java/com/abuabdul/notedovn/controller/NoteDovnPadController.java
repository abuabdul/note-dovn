package com.abuabdul.notedovn.controller;

import static org.springframework.util.CollectionUtils.isEmpty;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.abuabdul.notedovn.document.folder.NotesFolder;
import com.abuabdul.notedovn.document.model.ScratchNote;
import com.abuabdul.notedovn.exception.NoteDovnException;
import com.abuabdul.notedovn.exception.NoteDovnServiceException;
import com.abuabdul.notedovn.service.NoteDovnService;

/**
 * @author abuabdul
 *
 */
@Controller
public class NoteDovnPadController {

	private static final Logger log = LogManager.getLogger(NoteDovnPadController.class.getName());

	@Autowired
	private NoteDovnService noteDovnService;

	@RequestMapping(value = "/scratch/notedovnPad.go")
	public String notedovnPad(ModelMap model) {
		log.debug("Entering notedovnPad() in " + this.getClass().getName());
		model.addAttribute("scratchPadForm", new ScratchNote());
		return "notedovnPad";
	}

	@RequestMapping(value = "/secure/scratch/makeNotes.go")
	public String makeScratchNotes(@ModelAttribute("scratchPadForm") ScratchNote scratchNote, ModelMap model) {
		log.debug("Entering makeScratchNotes() in " + this.getClass().getName());
		try {
			noteDovnService.makeScratchNote(scratchNote);
			model.addAttribute("scratchPadForm", new ScratchNote());
			model.addAttribute("saveNoteDetails", true);
			List<NotesFolder> allNotesInFolder = wrapInFolder(noteDovnService.publishAllScratchNotes());
			model.addAttribute("notesFolder", allNotesInFolder);
			return "notedovnPad";
		} catch (NoteDovnServiceException ndse) {
			log.debug("NoteDovnServiceException - " + ndse.getMessage());
			throw new NoteDovnException(ndse.getMessage());
		}
	}

	@RequestMapping(value = "/secure/scratch/publishNotes.go")
	public String publishNotes(@ModelAttribute("scratchPadForm") ScratchNote scratchNote, ModelMap model) {
		log.debug("Entering publishNotes() in " + this.getClass().getName());
		try {
			model.addAttribute("scratchPadForm", new ScratchNote());
			List<NotesFolder> allNotesInFolder = wrapInFolder(noteDovnService.publishAllScratchNotes());
			// TODO temp arrangement
			ScratchNote note = new ScratchNote();
			note.setCategory("sdfdsf");
			note.setAboutNote("about");
			note.setNoteMsg("message");
			note.setReasonNote("reason");
			note.setSideNote("sidenote");
			NotesFolder notesFolder = new NotesFolder();
			notesFolder.set(1, note);
			ScratchNote note1 = new ScratchNote();
			note1.setCategory("abbucsdfdsf");
			notesFolder.set(2, note1);
			ScratchNote note2 = new ScratchNote();
			note2.setCategory("12323sdfdsf");
			notesFolder.set(3, note2);
			allNotesInFolder.add(notesFolder);
			model.addAttribute("notesFolder", allNotesInFolder);
			return "notedovnPad";
		} catch (NoteDovnServiceException ndse) {
			log.debug("NoteDovnServiceException - " + ndse.getMessage());
			throw new NoteDovnException(ndse.getMessage());
		}
	}

	protected List<NotesFolder> wrapInFolder(List<ScratchNote> notes) {
		List<NotesFolder> notesFolders = null;
		if (!isEmpty(notes)) {
			int size = notes.size();
			notesFolders = new ArrayList<>((size % 3) == 0 ? size / 3 : size / 3 + 1);
			for (NotesFolder notesFolder : notesFolders) {
				for (int i = 1; i <= 3; i++) {
					notesFolder.set(i, when(size - 1, notes));
					size--;
				}
			}
		}
		return notesFolders;
	}

	private ScratchNote when(int actual, List<ScratchNote> notes) {
		if (actual >= 0) {
			return notes.get(actual);
		}
		return new ScratchNote();
	}

}
