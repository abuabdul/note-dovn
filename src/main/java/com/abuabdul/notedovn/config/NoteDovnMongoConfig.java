package com.abuabdul.notedovn.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;

/**
 * @author abuabdul
 *
 */
@Configuration
public class NoteDovnMongoConfig {

	@Value("${mongo.host}")
	private String mongohost;
	@Value("${mongo.port}")
	private int mongoport;
	@Value("${mongo.databaseName}")
	private String mongodbName;

	@Bean
	public MongoClient mongoClient() throws Exception {
		return new MongoClient(mongohost, mongoport);
	}

	@Bean
	public MongoDbFactory mongoDbFactory() throws Exception {
		return new SimpleMongoDbFactory(mongoClient(), mongodbName);
	}

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongoDbFactory());
	}

}
