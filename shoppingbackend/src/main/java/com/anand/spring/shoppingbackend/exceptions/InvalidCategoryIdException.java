package com.anand.spring.shoppingbackend.exceptions;

public class InvalidCategoryIdException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidCategoryIdException() {
		super();
	}

	public InvalidCategoryIdException(String exceptionMessage) {
		super(exceptionMessage);
	}
}
