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
public interface EventService {
	
	public Event find(int id);
	
	public List<Event> searchByToday();
	
	public List<Event> searchByWeek();
	
	public List<Event> searchByMonth();
	
	public void save(Event event);
	
	public void delete(Event event);
	
	
}
