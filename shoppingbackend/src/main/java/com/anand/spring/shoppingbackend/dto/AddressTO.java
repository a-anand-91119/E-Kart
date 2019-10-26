package com.anand.spring.shoppingbackend.dto;

import java.io.Serializable;

/**
 * 
 * @author A Anand
 *
 */
public class AddressTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long addressId;
	private Long addressUserId;
	private String addressLineOne;
	private String addressLineTwo;
	private String addressCity;
	private String addressState;
	private String addressCountry;
	private String addressPostalCode;
	private Boolean addressShipping;
	private Boolean addressBilling;

	public AddressTO() {
		super();
	}

	public AddressTO(Long addressId, Long addressUserId, String addressLineOne, String addressLineTwo,
			String addressCity, String addressState, String addressCountry, String addressPostalCode,
			Boolean addressShipping, Boolean addressBilling) {
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
		return "AddressTO [addressId=" + addressId + ", addressUserId=" + addressUserId + ", addressLineOne="
				+ addressLineOne + ", addressLineTwo=" + addressLineTwo + ", addressCity=" + addressCity
				+ ", addressState=" + addressState + ", addressCountry=" + addressCountry + ", addressPostalCode="
				+ addressPostalCode + ", addressShipping=" + addressShipping + ", addressBilling=" + addressBilling
				+ "]";
	}

}
