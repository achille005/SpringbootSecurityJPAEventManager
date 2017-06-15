package com.achille.spring.services;

import java.util.Date;
import java.util.List;

import org.springframework.validation.BindingResult;

import com.achille.spring.dto.ForgotPasswordForm;
import com.achille.spring.dto.ResetPasswordForm;
import com.achille.spring.dto.SignupForm;
import com.achille.spring.dto.UserEditForm;
import com.achille.spring.entities.Event;
import com.achille.spring.entities.User;

/**
 * @author Achille
 *
 */
public interface UserService {
	
	public abstract void signup(SignupForm signupForm);

	public abstract void verify(String verificationCode);

	public abstract void forgotPassword(ForgotPasswordForm forgotPasswordForm);

	public abstract void resetPassword(String forgotPasswordCode,
			ResetPasswordForm resetPasswordForm, BindingResult result);

	public abstract User findOne(long userId);

	public abstract void update(long userId, UserEditForm userEditForm);

	public User findByEmail(String email);

}
