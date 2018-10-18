package auth;

import org.springframework.validation.BindingResult;

import entities.Ruser;

/**
 * @author Nana Febriana
 */

public interface UserValidationAuth {

	public boolean userValidation(Ruser rUser, BindingResult result);

}