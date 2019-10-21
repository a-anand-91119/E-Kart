package com.anand.spring.shoppingbackend.exceptions;

/**
 * 
 * @author A Anand
 *
 */
public class InvalidCategoryIdException extends InvalidIdException {

	private static final long serialVersionUID = 1L;

	public InvalidCategoryIdException() {
		super();
	}

	public InvalidCategoryIdException(String exceptionMessage) {
		super(exceptionMessage);
	}
}
