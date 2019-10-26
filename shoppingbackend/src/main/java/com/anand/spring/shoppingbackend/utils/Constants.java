package com.anand.spring.shoppingbackend.utils;

public class Constants {

	public static final String DB_URL = "jdbc:h2:tcp://localhost/~/ekart";
	public static final String DB_DRIVER = "org.h2.Driver";
	public static final String DB_USERNAME = "ekartUser";
	public static final String DB_PASSWORD = "ekartPassword";
	
	public static final String HIBERNATE_DIALECT = "org.hibernate.dialect.H2Dialect";
	public static final String HIBERNATE_SHOW_SQL = "true";
	public static final String HIBERNATE_FORMAT_SQL = "true";
	public static final String HIBERNATE_HBM2DDL_AUTO = "update";
	
	public static final String ROLE_USER = "USER";
	public static final String ROLE_SUPPLIER = "SUPPLIER";
	
}
