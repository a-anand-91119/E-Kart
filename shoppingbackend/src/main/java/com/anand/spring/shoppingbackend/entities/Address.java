package com.anand.spring.shoppingbackend.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author A Anand
 *
 */
@Entity
@Table(name = "ADDRESS")
public class Address {
	
	@Id
	@Column(name = "a_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long addressId;
	
	@Column(name = "a_user_id")
	private Long addressUserId;
	
	@Column(name = "a_addressline_one")
	private String addressLineOne;
	
	@Column(name = "a_addressline_two")
	private String addressLineTwo;
	
	@Column(name = "a_city")
	private String addressCity;
	
	@Column(name = "a_state")
	private String addressState;
	
	@Column(name = "a_country")
	private String addressCountry;
	
	@Column(name = "a_postal_code")
	private String addressPostalCode;
	
	@Column(name = "a_shipping")
	private Boolean addressShipping;
	
	@Column(name = "a_billing")
	private Boolean addressBilling;

	public Address() {
		super();
	}

	public Address(Long addressId, Long addressUserId, String addressLineOne, String addressLineTwo, String addressCity,
			String addressState, String addressCountry, String addressPostalCode, Boolean addressShipping,
			Boolean addressBilling) {
		super();
		this.addressId = addressId;
		this.addressUserId = addressUserId;
		this.addressLineOne = addressLineOne;
		this.addressLineTwo = addressLineTwo;
		this.addressCity = addressCity;
		this.addressState = addressState;
		this.addressCountry = addressCountry;
		this.addressPostalCode = addressPostalCode;
		this.addressShipping = addressShipping;
		this.addressBilling = addressBilling;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public Long getAddressUserId() {
		return addressUserId;
	}

	public void setAddressUserId(Long addressUserId) {
		this.addressUserId = addressUserId;
	}

	public String getAddressLineOne() {
		return addressLineOne;
	}

	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}

	public String getAddressLineTwo() {
		return addressLineTwo;
	}

	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}

	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public String getAddressState() {
		return addressState;
	}

	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}

	public String getAddressCountry() {
		return addressCountry;
	}

	public void setAddressCountry(String addressCountry) {
		this.addressCountry = addressCountry;
	}

	public String getAddressPostalCode() {
		return addressPostalCode;
	}

	public void setAddressPostalCode(String addressPostalCode) {
		this.addressPostalCode = addressPostalCode;
	}

	public Boolean getAddressShipping() {
		return addressShipping;
	}

	public void setAddressShipping(Boolean addressShipping) {
		this.addressShipping = addressShipping;
	}

	public Boolean getAddressBilling() {
		return addressBilling;
	}

	public void setAddressBilling(Boolean addressBilling) {
		this.addressBilling = addressBilling;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", addressUserId=" + addressUserId + ", addressLineOne="
				+ addressLineOne + ", addressLineTwo=" + addressLineTwo + ", addressCity=" + addressCity
				+ ", addressState=" + addressState + ", addressCountry=" + addressCountry + ", addressPostalCode="
				+ addressPostalCode + ", addressShipping=" + addressShipping + ", addressBilling=" + addressBilling
				+ "]";
	}

}
