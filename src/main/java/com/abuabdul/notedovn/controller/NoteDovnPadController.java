package com.abuabdul.notedovn.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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
			return "notedovnPad";
		} catch (NoteDovnServiceException ndse) {
			log.debug("NoteDovnServiceException - " + ndse.getMessage());
			throw new NoteDovnException(ndse.getMessage());
		}
	}
}
