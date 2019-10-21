package com.anand.spring.shoppingbackend.exceptions;

/**
 * 
 * @author A Anand
 *
 */
public class InvalidIdException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidIdException() {
		super();
	}

	public InvalidIdException(String exceptionMessage) {
		super(exceptionMessage);
	}
}
