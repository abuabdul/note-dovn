package com.abuabdul.notedovn.controller;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author abuabdul
 *
 */
@Controller
public class NoteDovnPadController {

	private static final Logger log = LogManager.getLogger(NoteDovnPadController.class.getName());

	@RequestMapping(value = "/scratch/notedovnPad.go")
	public String notedovnPad(ModelMap model, HttpSession session) {
		log.debug("Entering notedovnPad() in " + this.getClass().getName());
		// try {
		// super.bootstrapRefData(session, model);
		// model.addAttribute("resourceTaskTrackerForm", new
		// ResourceTask());
		return "notedovnPad";
		/*
		 * } catch (NoteDovnServiceException ndse) { log.debug(
		 * "NoteDovnServiceException - " + ndse.getMessage()); throw new
		 * NoteDovnException(ndse.getMessage()); }
		 */
	}
}
