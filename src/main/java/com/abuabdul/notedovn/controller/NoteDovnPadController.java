package com.abuabdul.notedovn.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.abuabdul.notedovn.document.model.ScratchNote;

/**
 * @author abuabdul
 *
 */
@Controller
public class NoteDovnPadController {

	private static final Logger log = LogManager.getLogger(NoteDovnPadController.class.getName());

	@RequestMapping(value = "/scratch/notedovnPad.go")
	public String notedovnPad(ModelMap model) {
		log.debug("Entering notedovnPad() in " + this.getClass().getName());
		model.addAttribute("scratchPadForm", new ScratchNote());
		return "notedovnPad";
	}

	@RequestMapping(value = "/scratch/makeNotes.go")
	public String makeScratchNotes(ModelMap model) {
		log.debug("Entering makeScratchNotes() in " + this.getClass().getName());
		// try {
		model.addAttribute("scratchPadForm", new ScratchNote());
		return "notedovnPad";
		/*
		 * } catch (NoteDovnServiceException ndse) { log.debug(
		 * "NoteDovnServiceException - " + ndse.getMessage()); throw new
		 * NoteDovnException(ndse.getMessage()); }
		 */
	}
}
