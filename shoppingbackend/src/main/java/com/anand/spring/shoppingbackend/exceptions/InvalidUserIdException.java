package com.anand.spring.shoppingbackend.exceptions;

/**
 * 
 * @author A Anand
 *
 */
public class InvalidUserIdException extends InvalidIdException {
	
	private static final long serialVersionUID = 1L;

	public InvalidUserIdException() {
		super();
	}

	public InvalidUserIdException(String exceptionMessage) {
		super(exceptionMessage);
	}
}
