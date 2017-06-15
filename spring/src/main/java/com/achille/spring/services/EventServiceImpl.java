package com.achille.spring.services;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.achille.spring.entities.Event;
import com.achille.spring.repositories.EventRepository;

/**
 * @author Achille
 *
 */
@Service("eventService")
@Transactional
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepository eventRepository;
	
	@Override
	public List<Event> searchByToday() {
		return eventRepository.searchByToday();
	}

	@Override
	public List<Event> searchByMonth() {
		return eventRepository.searchByMonth();
	}

	@Override
	public void save(Event event) {
		eventRepository.save(event);
	}

	@Override
	public void delete(Event event) {
		eventRepository.delete(event);
	}

	@Override
	public Event find(int id) {
		return eventRepository.findOne(id);
	}

	@Override
	public List<Event> searchByWeek() {
		Date date = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK) - c.getFirstDayOfWeek();
		c.add(Calendar.DAY_OF_MONTH, -dayOfWeek);

		Date weekStart = c.getTime();
		
		c.add(Calendar.DAY_OF_MONTH, 6); 
		Date weekEnd = c.getTime();
		
		return eventRepository.searchByWeek(weekStart, weekEnd);
	}


}
