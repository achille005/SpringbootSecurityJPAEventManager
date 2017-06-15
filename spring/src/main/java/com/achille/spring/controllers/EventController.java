package com.achille.spring.controllers;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.achille.spring.entities.Event;
import com.achille.spring.services.*;
import com.achille.spring.validators.EventFormValidator;

/**
 * @author Achille
 *
 */
@Controller
@RequestMapping("/event")
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		String email = userDetail.getUsername();
		modelMap.put("events", userService.findByEmail(email)
				.getEvents());
		return "event/index";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(ModelMap modelMap) {
		modelMap.put("event", new Event());
		return "event/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(
		@ModelAttribute("event") @Valid Event event,
		BindingResult bindingResult,
		HttpServletRequest request, 
		ModelMap modelMap) {
		try {
			EventFormValidator eventFormValidator = 
					new EventFormValidator();
				eventFormValidator.validate(event, bindingResult);
				if (bindingResult.hasErrors()) {
					return "event/add";
				} else {			
					
					String date = request.getParameter("date");
					String reminderTime = request.getParameter("reminderTime");
					SimpleDateFormat simpleDateFormat = 
						new SimpleDateFormat("MM/dd/yyyy");
					event.setDate(simpleDateFormat.parse(date));
					event.setReminderTime(simpleDateFormat.parse(reminderTime));
					SimpleDateFormat simpleDateFormat2 = 
							new SimpleDateFormat("HH:mm");
					String time = request.getParameter("hours") + ":" + request.getParameter("minutes");
					event.setTime(simpleDateFormat2.parse(time));
					
					Authentication auth = SecurityContextHolder.getContext()
							.getAuthentication();
					UserDetails userDetail = (UserDetails) auth.getPrincipal();
					event.setUsr(userService.findByEmail(userDetail.getUsername()));
					eventService.save(event);
					return "redirect:../event";
				}
		} catch (Exception e) {
			modelMap.put("error", "Fail: " + e.getMessage());
			return "event/add";
		}		
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String edit(
		@ModelAttribute("event") @Valid Event event,
		BindingResult bindingResult,
		HttpServletRequest request, 
		ModelMap modelMap) {
		try {
			EventFormValidator eventFormValidator = 
					new EventFormValidator();
				eventFormValidator.validate(event, bindingResult);
				if (bindingResult.hasErrors()) {
					modelMap.put("event", event);
					return "event/edit";
				} else {
					String date = request.getParameter("date");
					String reminderTime = request.getParameter("reminderTime");
					SimpleDateFormat simpleDateFormat = 
						new SimpleDateFormat("MM/dd/yyyy");
					event.setDate(simpleDateFormat.parse(date));
					event.setReminderTime(simpleDateFormat.parse(reminderTime));
					SimpleDateFormat simpleDateFormat2 = 
							new SimpleDateFormat("HH:mm");
					String time = request.getParameter("hours") + ":" + request.getParameter("minutes");
					event.setTime(simpleDateFormat2.parse(time));
					
					Authentication auth = SecurityContextHolder.getContext()
							.getAuthentication();
					UserDetails userDetail = (UserDetails) auth.getPrincipal();
					event.setUsr(userService.findByEmail(userDetail.getUsername()));
					eventService.save(event);
					return "redirect:../event";
				}
		} catch (Exception e) {
			modelMap.put("error", "Fail: " + e.getMessage());
			modelMap.put("event", event);
			return "event/edit";
		}		
	}
	
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String edit(
		@PathVariable("id") int id, 
		ModelMap modelMap) {
		modelMap.put("event", eventService.find(id));
		return "event/edit";
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id) {
		eventService.delete(eventService.find(id));
		return "redirect:/event";
	}
	
	@RequestMapping(value = "month", method = RequestMethod.GET)
	public String month(ModelMap modelMap) {
		modelMap.put("events", eventService.searchByMonth());
		return "event/index";
	}
	
	@RequestMapping(value = "today", method = RequestMethod.GET)
	public String today(ModelMap modelMap) {
		modelMap.put("events", eventService.searchByToday());
		return "event/index";
	}
	
	@RequestMapping(value = "week", method = RequestMethod.GET)
	public String week(ModelMap modelMap) {
		modelMap.put("events", eventService.searchByWeek());
		return "event/index";
	}
	
}
