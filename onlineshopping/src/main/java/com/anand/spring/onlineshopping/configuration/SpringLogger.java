package com.anand.spring.onlineshopping.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.anand.spring.onlineshopping.controllers.MainController;

/**
 * 
 * @author A Anand
 *
 */
@Component
public class SpringLogger {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	public Logger getLogger() {
		return logger;
	}
}
