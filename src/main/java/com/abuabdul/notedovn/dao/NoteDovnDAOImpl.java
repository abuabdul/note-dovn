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

import static com.abuabdul.notedovn.util.NoteDovnUtil.getUTCDateTime;
import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

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

	protected Update update(String key, Object val) {
		Update update = new Update();
		update.set(key, val);
		update.set("updatedDate", getUTCDateTime());
		return update;
	}
}
