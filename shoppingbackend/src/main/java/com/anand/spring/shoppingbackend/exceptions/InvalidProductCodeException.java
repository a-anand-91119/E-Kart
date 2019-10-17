package com.anand.spring.shoppingbackend.exceptions;

/**
 * 
 * @author A Anand
 *
 */
public class InvalidProductCodeException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidProductCodeException() {
		super();
	}

	public InvalidProductCodeException(String errorMessage) {
		super(errorMessage);
	}
}
