package com.abuabdul.notedovn.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author abuabdul
 *
 */
public class NoteDovnPadControllerTest {

	@InjectMocks
	private NoteDovnPadController noteDovnPadController;

	private MockMvc mockMvc;

	@BeforeClass
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
		mockMvc = standaloneSetup(noteDovnPadController).build();
	}

	@Test(groups = "integration")
	public void testNotedovnPad() throws Exception {
		mockMvc.perform(post("/scratch/notedovnPad.go")).andExpect(status().isOk())
				.andExpect(view().name("notedovnPad"));
	}
}
