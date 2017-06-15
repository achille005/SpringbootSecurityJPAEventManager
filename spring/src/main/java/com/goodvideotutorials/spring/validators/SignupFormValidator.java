package com.goodvideotutorials.spring.validators;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.goodvideotutorials.spring.dto.SignupForm;
import com.goodvideotutorials.spring.repositories.UserRepository;

/**
 * @author Achille
 *
 */
@Component
public class SignupFormValidator extends LocalValidatorFactoryBean {
	
	private UserRepository userRepository;
	
	@Resource
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(SignupForm.class);
	}

	@Override
	public void validate(Object obj, Errors errors, final Object... validationHints) {
		
		super.validate(obj, errors, validationHints);
		
		if (!errors.hasErrors()) {
			SignupForm signupForm = (SignupForm) obj;
			if (userRepository.findByEmail(signupForm.getEmail()).isPresent())
				errors.rejectValue("email", "emailNotUnique");			
		}	
	}
}
