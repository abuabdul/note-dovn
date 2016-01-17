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
package com.abuabdul.notedovn.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.flash;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.web.servlet.DispatcherServlet.INPUT_FLASH_MAP_ATTRIBUTE;

import java.util.Map;

import org.json.JSONObject;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.abuabdul.notedovn.document.model.ScratchNote;
import com.abuabdul.notedovn.service.NoteDovnService;
import com.beust.jcommander.internal.Maps;

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
				.andExpect(model().attributeDoesNotExist("saveNoteDetails"))
				.andExpect(model().attributeExists("scratchPadForm", "notesFolder"))
				.andExpect(view().name("notedovnPad"));
	}

	@Test(groups = "integration")
	public void testNotedovnPadRedirect() throws Exception {
		Map<String, Object> inputFlashMap = Maps.newHashMap();
		inputFlashMap.put("saveNoteDetails", Boolean.TRUE);
		mockMvc.perform(post("/scratch/notedovnPad.go").requestAttr(INPUT_FLASH_MAP_ATTRIBUTE, inputFlashMap))
				.andExpect(status().isOk())
				.andExpect(model().attributeExists("scratchPadForm", "notesFolder", "saveNoteDetails"))
				.andExpect(view().name("notedovnPad"));
	}

	@Test(groups = "integration")
	public void testMakeScratchNotes() throws Exception {
		mockMvc.perform(post("/secure/scratch/makeNotes.go").sessionAttr("scratchPadForm", new ScratchNote()))
				.andExpect(status().isFound()).andExpect(flash().attribute("saveNoteDetails", true))
				.andExpect(flash().attributeCount(1)).andExpect(redirectedUrl("/scratch/notedovnPad.go"));
	}

	@Test(groups = "integration")
	public void testRemoveScratchNotes() throws Exception {
		mockMvc.perform(post("/secure/scratch/345676/removeNotes.go").sessionAttr("scratchPadForm", new ScratchNote()))
				.andExpect(status().isOk()).andExpect(view().name("notedovnPad"));
	}

	@Test(groups = "integration")
	public void testUpdateScratchNotes() throws Exception {
		JSONObject json = new JSONObject();
		json.put("status", "success");
		mockMvc.perform(post("/secure/scratch/updateNote.go").param("name", "any_name").param("pk", "any_id")
				.param("value", "any_value").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(content().json(json.toString()))
				.andReturn();
	}
}
