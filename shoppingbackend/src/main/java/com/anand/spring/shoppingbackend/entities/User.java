package com.anand.spring.shoppingbackend.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author A Anand
 *
 */
@Entity
@Table(name = "USER_DETAILS")
public class User {

	@Id
	@Column(name = "ud_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@Column(name = "ud_first_name")
	private String userFirstName;
	
	@Column(name = "ud_last_name")
	private String userLastName;
	
	@Column(name = "ud_role")
	private String userRole;
	
	@Column(name = "ud_enabled")
	private Boolean userIsEnabled = true;
	
	@Column(name = "ud_password")
	private String userPassword;
	
	@Column(name = "ud_email_address")
	private String userEmailAddress;
	
	@Column(name = "ud_phone_number")
	private String userPhoneNumber;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private ShoppingCart shoppingCart; 
	
	public User() {
		super();
	}

	public User(Long userId, String userFirstName, String userLastName, String userRole, Boolean userIsEnabled,
			String userPassword, String userEmailAddress, String userPhoneNumber) {
		super();
		this.userId = userId;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userRole = userRole;
		this.userIsEnabled = userIsEnabled;
		this.userPassword = userPassword;
		this.userEmailAddress = userEmailAddress;
		this.userPhoneNumber = userPhoneNumber;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public Boolean getUserIsEnabled() {
		return userIsEnabled;
	}

	public void setUserIsEnabled(Boolean userIsEnabled) {
		this.userIsEnabled = userIsEnabled;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmailAddress() {
		return userEmailAddress;
	}

	public void setUserEmailAddress(String userEmailAddress) {
		this.userEmailAddress = userEmailAddress;
	}

	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userFirstName=" + userFirstName + ", userLastName=" + userLastName
				+ ", userRole=" + userRole + ", userIsEnabled=" + userIsEnabled + ", userPassword=" + userPassword
				+ ", userEmailAddress=" + userEmailAddress + ", userPhoneNumber=" + userPhoneNumber + "]";
	}

}
