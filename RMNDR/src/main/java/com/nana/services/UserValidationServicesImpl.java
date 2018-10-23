package com.nana.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.nana.auth.UserValidationAuth;
import com.nana.entities.Ruser;

/**
 * @author Nana Febriana
 */

@Service
public class UserValidationServicesImpl implements UserValidationServices {

	private UserValidationAuth userValidationAuth;

	@Autowired
	public void setUserValidationAuth(UserValidationAuth userValidationAuth) {
		this.userValidationAuth = userValidationAuth;
	}

	@Override
	public boolean userValidation(Ruser rUser, BindingResult result) {
		return userValidationAuth.userValidation(rUser, result);
	}

}
