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
package com.abuabdul.notedovn.service;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.abuabdul.notedovn.document.model.NoteDovnUser;
import com.google.common.collect.Lists;

/**
 * @author abuabdul
 *
 */
public class NoteDovnUserDetailsService implements UserDetailsService {

	private final MongoTemplate mongoTemplate;

	/**
	 * @param mongoTemplate
	 */
	public NoteDovnUserDetailsService(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		NoteDovnUser noteDovnUser = mongoTemplate.findOne(query(username), NoteDovnUser.class);
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(noteDovnUser.getRole());
		return new User(noteDovnUser.getUsername(), noteDovnUser.getPassword(), Lists.newArrayList(authority));
	}

	protected Query query(String username) {
		return new Query(where("username").is(username));
	}

}
