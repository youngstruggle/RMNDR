package services;

import org.springframework.validation.BindingResult;

import entities.Ruser;

/**
 * @author Nana Febriana
 */

public interface UserValidationServices {

	public boolean userValidation(Ruser rUser, BindingResult result);

}