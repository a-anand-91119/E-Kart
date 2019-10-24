package com.anand.spring.shoppingbackend.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.anand.spring.shoppingbackend.utils.Constants;

/**
 * Spring Root configurations
 * 
 * @author A Anand
 *
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.anand.spring.shoppingbackend"})
public class SpringRootConfiguration {

	@Bean
	public DataSource getDataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(Constants.DB_DRIVER);
		basicDataSource.setUrl(Constants.DB_URL);
		basicDataSource.setUsername(Constants.DB_USERNAME);
		basicDataSource.setPassword(Constants.DB_PASSWORD);
		return basicDataSource;
	}
	
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder localSessionFactoryBuilder = new LocalSessionFactoryBuilder(dataSource);
		localSessionFactoryBuilder.addProperties(getHibernateProperties());
		localSessionFactoryBuilder.scanPackages("com.anand.spring.shoppingbackend.entities");
		return localSessionFactoryBuilder.buildSessionFactory();
	}
	
	/**
	 * Method creates and returns {@link HibernateTransactionManager} using the available {@link SessionFactory}
	 * 
	 * @param sessionFactory
	 * 			the session factory to be used to create the hibernate transaction manager
	 * @return
	 * 			hibernate transaction manager
	 */
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager(sessionFactory);
		return hibernateTransactionManager;
	}

	/**
	 * All Hibernate properties are specified in this method.
	 * 
	 * @return hibenate properties to be used
	 */
	private Properties getHibernateProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.dialect", Constants.HIBERNATE_DIALECT);
		hibernateProperties.setProperty("hibernate.show_sql", Constants.HIBERNATE_SHOW_SQL);
		hibernateProperties.setProperty("hibernate.format_sql", Constants.HIBERNATE_FORMAT_SQL);
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", Constants.HIBERNATE_HBM2DDL_AUTO);
		return hibernateProperties;
	}
}
