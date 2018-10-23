package com.nana.auth;

import org.springframework.validation.BindingResult;

import com.nana.entities.Ruser;

/**
 * @author Nana Febriana
 */

public interface UserValidationAuth {

	public boolean userValidation(Ruser rUser, BindingResult result);

}