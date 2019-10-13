package com.anand.spring.onlineshopping.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author A Anand
 *
 */
@Configuration
@ComponentScan(basePackages = { "com.anand.spring.onlineshopping", "com.anand.spring.shoppingbackend" })
public class SpringRootConfiguration {

}
