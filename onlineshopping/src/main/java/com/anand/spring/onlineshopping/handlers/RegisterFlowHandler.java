package com.anand.spring.onlineshopping.handlers;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.anand.spring.shoppingbackend.dto.AddressTO;
import com.anand.spring.shoppingbackend.dto.RegistrationModel;
import com.anand.spring.shoppingbackend.dto.UserRegister;
import com.anand.spring.shoppingbackend.services.UserManagementService;

/**
 * 
 * @author A Anand
 *
 */
@Component
public class RegisterFlowHandler {

	@Autowired
	private UserManagementService userManagementServiceImpl;
	
	@Bean
	public RegistrationModel getRegistrationModel() {
		return new RegistrationModel();
	}

	public void addUserToModel(RegistrationModel registrationModel, UserRegister userRegister) {
		registrationModel.setUserRegister(userRegister);
	}

	public void addBillingAddressToModel(RegistrationModel registrationModel, AddressTO addressTO) {
		registrationModel.setAddressTO(addressTO);
	}
	
	public String saveAll(RegistrationModel registrationModel) {
		String transitionValue = "success";
		
		AddressTO address = registrationModel.getAddressTO();
		address.setAddressBilling(true);
		address.setAddressShipping(false);
		userManagementServiceImpl.createUser(registrationModel.getUserRegister(), address);
		
		return transitionValue;
	}
}
