package com.achille.spring.validators;

import org.springframework.validation.*;

import com.achille.spring.entities.Event;

public class EventFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Event.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		
	}

}
