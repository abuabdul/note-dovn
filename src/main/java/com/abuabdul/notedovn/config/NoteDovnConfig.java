package com.abuabdul.notedovn.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.abuabdul.notedovn.dao.NoteDovnDAO;
import com.abuabdul.notedovn.dao.NoteDovnDAOImpl;
import com.abuabdul.notedovn.service.NoteDovnService;
import com.abuabdul.notedovn.service.NoteDovnServiceImpl;

/**
 * @author abuabdul
 *
 */

@Configuration
public class NoteDovnConfig {

	private static final String APPCONFIG_FILE_NAME = "Appconfig.properties";

	@Autowired
	private MongoTemplate mongoTemplate;

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
	public NoteDovnDAO noteDovnDAO() throws Exception {
		return new NoteDovnDAOImpl(mongoTemplate);
	}

	@Bean
	public NoteDovnService noteDovnService() throws Exception {
		return new NoteDovnServiceImpl(noteDovnDAO());
	}
}
