package com.anand.spring.shoppingbackend.exceptions;

/**
 * 
 * @author A Anand
 *
 */
public class InvalidAddressIdException extends InvalidIdException {

	private static final long serialVersionUID = 1L;

	public InvalidAddressIdException() {
		super();
	}

	public InvalidAddressIdException(String exceptionMessage) {
		super(exceptionMessage);
	}
}