package com.abuabdul.notedovn.dao;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Update.update;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import com.abuabdul.notedovn.document.model.ScratchNote;
import com.abuabdul.notedovn.exception.NoteDovnServiceException;

/**
 * @author abuabdul
 *
 */
public class NoteDovnDAOImpl implements NoteDovnDAO {

	private final MongoTemplate mongoTemplate;

	public NoteDovnDAOImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public void saveNote(ScratchNote note) throws NoteDovnServiceException {
		mongoTemplate.save(note);
	}

	@Override
	public ScratchNote findNote(String id) throws NoteDovnServiceException {
		return mongoTemplate.findOne(query(id), ScratchNote.class);
	}

	@Override
	public List<ScratchNote> findAll() throws NoteDovnServiceException {
		return mongoTemplate.findAll(ScratchNote.class);
	}

	@Override
	public void updateNote(String id, String key, Object val) throws NoteDovnServiceException {
		mongoTemplate.updateFirst(query(id), update(key, val), ScratchNote.class);
	}

	@Override
	public void removeNote(ScratchNote savedNote) throws NoteDovnServiceException {
		mongoTemplate.remove(savedNote);
	}

	protected Query query(String id) {
		return new Query(where("id").is(id));
	}
}
