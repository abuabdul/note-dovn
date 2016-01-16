package com.abuabdul.notedovn.dao;

import static com.abuabdul.notedovn.util.NoteDovnUtil.getUTCDateTime;
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
		Update update = new Update();
		update.set("name", "someValue");
		update.set("updatedDate", getUTCDateTime());
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
