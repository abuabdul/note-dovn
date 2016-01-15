package com.abuabdul.notedovn.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.abuabdul.notedovn.document.model.ScratchNote;
import com.abuabdul.notedovn.service.NoteDovnService;

/**
 * @author abuabdul
 *
 */
public class NoteDovnPadControllerTest {

	@Mock
	private NoteDovnService noteDovnService;

	@InjectMocks
	private NoteDovnPadController noteDovnPadController;

	private MockMvc mockMvc;

	@BeforeMethod
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
		mockMvc = standaloneSetup(noteDovnPadController).build();
	}

	@Test(groups = "integration")
	public void testNotedovnPad() throws Exception {
		mockMvc.perform(post("/scratch/notedovnPad.go")).andExpect(status().isOk())
				.andExpect(view().name("notedovnPad"));
	}

	@Test(groups = "integration")
	public void testMakeScratchNotes() throws Exception {
		mockMvc.perform(post("/secure/scratch/makeNotes.go").sessionAttr("scratchPadForm", new ScratchNote()))
				.andExpect(status().isOk()).andExpect(model().attributeExists("scratchPadForm"))
				.andExpect(model().attributeExists("saveNoteDetails")).andExpect(model().attributeExists("notesFolder"))
				.andExpect(view().name("notedovnPad"));
	}

	@Test(groups = "integration")
	public void testRemoveScratchNotes() throws Exception {
		mockMvc.perform(post("/secure/scratch/345676/removeNotes.go").sessionAttr("scratchPadForm", new ScratchNote()))
				.andExpect(status().isOk()).andExpect(model().attributeExists("scratchPadForm"))
				.andExpect(model().attributeExists("notesFolder")).andExpect(view().name("notedovnPad"));
	}
}
