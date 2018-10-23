package com.nana.services;

import org.springframework.validation.BindingResult;

import com.nana.entities.Ruser;

/**
 * @author Nana Febriana
 */

public interface UserValidationServices {

	public boolean userValidation(Ruser rUser, BindingResult result);

}