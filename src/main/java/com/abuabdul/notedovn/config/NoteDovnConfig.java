package com.abuabdul.notedovn.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.abuabdul.notedovn.dao.NoteDovnDAO;
import com.abuabdul.notedovn.dao.NoteDovnDAOImpl;
import com.mongodb.MongoClient;

/**
 * @author abuabdul
 *
 */
@Configuration
public class NoteDovnConfig {

	private static final String APPCONFIG_FILE_NAME = "Appconfig.properties";

	@Value("${mongo.host}")
	private String mongohost;
	@Value("${mongo.port}")
	private int mongoport;
	@Value("${mongo.databaseName}")
	private String mongodbName;

	@Bean
	public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
		PropertyPlaceholderConfigurer propertyConfigurer = new PropertyPlaceholderConfigurer();
		propertyConfigurer.setLocation(new ClassPathResource(APPCONFIG_FILE_NAME));
		propertyConfigurer.setIgnoreResourceNotFound(false);
		propertyConfigurer.setIgnoreUnresolvablePlaceholders(true);
		propertyConfigurer.setSearchSystemEnvironment(true);
		propertyConfigurer.setSystemPropertiesMode(PropertyPlaceholderConfigurer.SYSTEM_PROPERTIES_MODE_OVERRIDE);
		return propertyConfigurer;
	}

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

	@Bean
	public NoteDovnDAO noteDovnDAO() throws Exception {
		return new NoteDovnDAOImpl(mongoTemplate());
	}
}
