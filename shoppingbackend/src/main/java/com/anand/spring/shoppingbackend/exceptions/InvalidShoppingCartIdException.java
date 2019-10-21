package com.anand.spring.shoppingbackend.exceptions;

/**
 * 
 * @author A Anand
 *
 */
public class InvalidShoppingCartIdException extends InvalidIdException {

	private static final long serialVersionUID = 1L;

	public InvalidShoppingCartIdException() {
		super();
	}

	public InvalidShoppingCartIdException(String exceptionMessage) {
		super(exceptionMessage);
	}
}
