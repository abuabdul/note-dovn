package com.abuabdul.notedovn.controller;

import static com.abuabdul.notedovn.util.NoteDovnUtil.isRestrictedField;
import static com.abuabdul.notedovn.util.NoteDovnUtil.wrapInFolder;
import static org.apache.commons.lang3.StringUtils.isEmpty;

import java.util.LinkedList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

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
	public String notedovnPad(ModelMap model, HttpServletRequest request) {
		log.debug("Entering notedovnPad() in " + this.getClass().getName());
		try {
			Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
			if (inputFlashMap != null) {
				model.addAttribute("saveNoteDetails", inputFlashMap.get("saveNoteDetails"));
			}
			model.addAttribute("scratchPadForm", new ScratchNote());
			LinkedList<NotesFolder> allNotesInFolder = wrapInFolder(noteDovnService.publishAllScratchNotes());
			model.addAttribute("notesFolder", allNotesInFolder);
			return "notedovnPad";
		} catch (NoteDovnServiceException ndse) {
			log.debug("NoteDovnServiceException - " + ndse.getMessage());
			throw new NoteDovnException(ndse.getMessage());
		}
	}

	@RequestMapping(value = "/secure/scratch/makeNotes.go")
	public String makeScratchNotes(@ModelAttribute("scratchPadForm") ScratchNote scratchNote, ModelMap model,
			RedirectAttributes redirectAttrs) {
		log.debug("Entering makeScratchNotes() in " + this.getClass().getName());
		try {
			noteDovnService.makeScratchNote(scratchNote);
			redirectAttrs.addFlashAttribute("saveNoteDetails", true);
			return "redirect:/scratch/notedovnPad.go";
		} catch (NoteDovnServiceException ndse) {
			log.debug("NoteDovnServiceException - " + ndse.getMessage());
			throw new NoteDovnException(ndse.getMessage());
		}
	}

	@RequestMapping(value = "/secure/scratch/{id}/removeNotes.go")
	public String removeScratchNotes(@PathVariable String id,
			@ModelAttribute("scratchPadForm") ScratchNote scratchNote) {
		log.debug("Entering removeScratchNotes() in " + this.getClass().getName());
		try {
			scratchNote.setId(id);
			noteDovnService.strikeScratchNote(scratchNote);
			return "notedovnPad";
		} catch (NoteDovnServiceException ndse) {
			log.debug("NoteDovnServiceException - " + ndse.getMessage());
			throw new NoteDovnException(ndse.getMessage());
		}
	}

	@RequestMapping(value = "/secure/scratch/updateNote.go", produces = "application/json")
	@ResponseBody
	public String updateScratchNotes(HttpServletResponse response, @RequestParam String pk, @RequestParam String name,
			@RequestParam String value) {
		log.debug("Entering updateScratchNotes() in " + this.getClass().getName());
		try {
			response.setStatus(HttpServletResponse.SC_OK);
			JSONObject json = new JSONObject();
			if (isEmpty(pk) || isEmpty(name)) {
				json.put("status", "error");
				json.put("msg", "cannot update now");
				return json.toString();
			}
			if (isRestrictedField(name) && isEmpty(value)) {
				json.put("status", "error");
				json.put("msg", "cannot be empty");
				return json.toString();
			}
			noteDovnService.updateScratchNote(pk, name, value);
			json.put("status", "success");
			return json.toString();
		} catch (NoteDovnServiceException ndse) {
			log.debug("NoteDovnServiceException - " + ndse.getMessage());
			throw new NoteDovnException(ndse.getMessage());
		}
	}
}
