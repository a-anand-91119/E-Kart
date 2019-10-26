package com.anand.spring.shoppingbackend.dto;

import java.io.Serializable;

/**
 * 
 * @author A Anand
 *
 */
public class UserRegister implements Serializable {

	private static final long serialVersionUID = 1L;
	private String userEmailAddress;
	private String userFirstName;
	private String userLastName;
	private String userRole;
	private String userPassword;
	private String userPhoneNumber;
	private boolean isShoppingCartNeeded = false;

	public UserRegister() {
		super();
	}

	public UserRegister(String emailAddress, String userFirstName, String userLastName, String userRole,
			String userPassword, String userPhoneNumber) {
		super();
		this.userEmailAddress = emailAddress;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userRole = userRole;
		this.userPassword = userPassword;
		this.userPhoneNumber = userPhoneNumber;
	}

	public boolean isShoppingCartNeeded() {
		return isShoppingCartNeeded;
	}

	public void setShoppingCartNeeded(boolean isShoppingCartNeeded) {
		this.isShoppingCartNeeded = isShoppingCartNeeded;
	}

	public String getUserEmailAddress() {
		return userEmailAddress;
	}

	public void setUserEmailAddress(String emailAddress) {
		this.userEmailAddress = emailAddress;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	@Override
	public String toString() {
		return "UserRegister [emailAddress=" + userEmailAddress + ", userFirstName=" + userFirstName + ", userLastName="
				+ userLastName + ", userRole=" + userRole + ", userPassword=" + userPassword + ", userPhoneNumber="
				+ userPhoneNumber + "]";
	}

}
