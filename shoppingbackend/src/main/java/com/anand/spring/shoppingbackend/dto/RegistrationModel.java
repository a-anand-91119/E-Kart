package com.anand.spring.shoppingbackend.dto;

import java.io.Serializable;

/**
 * Composite Model to store Two DTOS for registration Flow
 * 
 * @author A Anand
 *
 */
public class RegistrationModel implements Serializable{

	private static final long serialVersionUID = 1L;
	private UserRegister userRegister;
	private AddressTO addressTO;

	public RegistrationModel() {
		super();
	}

	public RegistrationModel(UserRegister userRegister, AddressTO addressTO) {
		super();
		this.userRegister = userRegister;
		this.addressTO = addressTO;
	}

	public UserRegister getUserRegister() {
		return userRegister;
	}

	public void setUserRegister(UserRegister userRegister) {
		this.userRegister = userRegister;
	}

	public AddressTO getAddressTO() {
		return addressTO;
	}

	public void setAddressTO(AddressTO addressTO) {
		this.addressTO = addressTO;
	}

	@Override
	public String toString() {
		return "RegistrationModel [userRegister=" + userRegister + ", addressTO=" + addressTO + "]";
	}

}
