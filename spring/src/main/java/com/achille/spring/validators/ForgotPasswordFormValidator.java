package com.achille.spring.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.achille.spring.dto.ForgotPasswordForm;
import com.achille.spring.repositories.UserRepository;

/**
 * @author Achille
 *
 */
@Component
public class ForgotPasswordFormValidator extends LocalValidatorFactoryBean {
	
	private UserRepository userRepository;
	
	@Autowired
	public ForgotPasswordFormValidator(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(ForgotPasswordForm.class);
	}

	@Override
	public void validate(Object obj, Errors errors, final Object... validationHints) {
		
		super.validate(obj, errors, validationHints);
		
		if (!errors.hasErrors()) {
			ForgotPasswordForm forgotPasswordForm = (ForgotPasswordForm) obj;
			userRepository.findByEmail(forgotPasswordForm.getEmail());
			if (!userRepository.findByEmail(forgotPasswordForm.getEmail()).isPresent())
				errors.rejectValue("email", "notFound");			
		}
	}

}
