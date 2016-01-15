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
import org.springframework.web.bind.annotation.PathVariable;
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
		try {
			model.addAttribute("scratchPadForm", new ScratchNote());
			List<NotesFolder> allNotesInFolder = wrapInFolder(noteDovnService.publishAllScratchNotes());
			model.addAttribute("notesFolder", allNotesInFolder);
			return "notedovnPad";
		} catch (NoteDovnServiceException ndse) {
			log.debug("NoteDovnServiceException - " + ndse.getMessage());
			throw new NoteDovnException(ndse.getMessage());
		}
	}

	@RequestMapping(value = "/secure/scratch/makeNotes.go")
	public String makeScratchNotes(@ModelAttribute("scratchPadForm") ScratchNote scratchNote, ModelMap model) {
		log.debug("Entering makeScratchNotes() in " + this.getClass().getName());
		try {
			noteDovnService.makeScratchNote(scratchNote);
			model.addAttribute("scratchPadForm", new ScratchNote());
			model.addAttribute("saveNoteDetails", true);
			List<NotesFolder> allNotesInFolder = wrapInFolder(noteDovnService.publishAllScratchNotes());
			// TEST
			throw new NoteDovnException();
			/*
			 * model.addAttribute("notesFolder", allNotesInFolder); return
			 * "notedovnPad";
			 */
		} catch (NoteDovnServiceException ndse) {
			log.debug("NoteDovnServiceException - " + ndse.getMessage());
			throw new NoteDovnException(ndse.getMessage());
		}
	}

	@RequestMapping(value = "/secure/scratch/{id}/removeNotes.go")
	public String removeScratchNotes(@PathVariable String id, ModelMap model,
			@ModelAttribute("scratchPadForm") ScratchNote scratchNote) {
		log.debug("Entering removeScratchNotes() in " + this.getClass().getName());
		try {
			scratchNote.setId(id);
			noteDovnService.strikeScratchNote(scratchNote);
			model.addAttribute("scratchPadForm", new ScratchNote());
			List<NotesFolder> allNotesInFolder = wrapInFolder(noteDovnService.publishAllScratchNotes());
			model.addAttribute("notesFolder", allNotesInFolder);
			return "notedovnPad";
		} catch (NoteDovnServiceException ndse) {
			log.debug("NoteDovnServiceException - " + ndse.getMessage());
			throw new NoteDovnException(ndse.getMessage());
		}
	}

	protected List<NotesFolder> wrapInFolder(List<ScratchNote> notes) {
		int size = notes.size();
		int folderSize = (size % 3) == 0 ? size / 3 : size / 3 + 1;
		List<NotesFolder> notesFolders = new ArrayList<>(folderSize);
		if (!isEmpty(notes)) {
			for (int j = 0; j < folderSize; j++) {
				NotesFolder folder = new NotesFolder();
				for (int i = 1; i <= 3; i++) {
					folder.set(i, when(size - 1, notes));
					size--;
				}
				notesFolders.add(folder);
			}
		}
		return notesFolders;
	}

	private ScratchNote when(int actual, List<ScratchNote> notes) {
		if (actual >= 0 && actual < notes.size()) {
			return notes.get(actual);
		}
		return new ScratchNote();
	}

}
