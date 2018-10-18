package auth;

import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;

import entities.Ruser;

/**
 * @author Nana Febriana
 */

@Repository
public class UserValidationAuthImpl implements UserValidationAuth {
	
	@Override
	public boolean userValidation(Ruser rUser, BindingResult result) {
		boolean error = false;
		if (rUser.getUsername().isEmpty()) {
			result.rejectValue("username", "error.username");
			error = true;
		}
		if (rUser.getPassword().isEmpty()) {
			result.rejectValue("password", "error.password");
			error = true;
		}
		if (rUser.getEmailAddress().isEmpty()) {
			result.rejectValue("email", "error.email");
			error = true;
		}
		return error;
	}
	
}
