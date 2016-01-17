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
package com.abuabdul.notedovn.dao;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.data.mongodb.core.query.Criteria.where;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.abuabdul.notedovn.document.model.ScratchNote;

/**
 * @author abuabdul
 *
 */
public class NoteDovnDAOTest {

	@Mock
	private MongoTemplate mongoTemplate;

	@InjectMocks
	private NoteDovnDAOImpl noteDovnDAO;

	@Mock
	private ScratchNote note;

	@BeforeClass
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test(groups = "integration")
	public void testSaveNote() throws Exception {
		noteDovnDAO.saveNote(note);
		verify(mongoTemplate).save(note);
	}

	@Test(groups = "integration")
	public void testFindNote() throws Exception {
		noteDovnDAO.findNote("pk");
		verify(mongoTemplate).findOne(query("pk"), ScratchNote.class);
	}

	@Test(groups = "integration")
	public void testFindAll() throws Exception {
		noteDovnDAO.findAll();
		verify(mongoTemplate).findAll(ScratchNote.class);
	}

	@Test(groups = "integration")
	public void testUpdateNote() throws Exception {
		noteDovnDAO.updateNote("pk", "name", "someValue");
		verify(mongoTemplate).updateFirst(any(Query.class), any(Update.class), any(Class.class));
	}

	@Test(groups = "integration")
	public void testRemoveNote() throws Exception {
		noteDovnDAO.removeNote(note);
		verify(mongoTemplate).remove(note);
	}

	private Query query(String id) {
		return new Query(where("id").is(id));
	}
}
