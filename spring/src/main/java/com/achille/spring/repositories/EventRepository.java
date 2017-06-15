package com.achille.spring.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.achille.spring.entities.*;
/**
 * @author Achille
 *
 */
@Repository("eventRepository")
public interface EventRepository extends CrudRepository<Event, Integer> {
	
	@Query("select e from Event e "
			+ "where year(e.date) = year(current_date) "
			+ "and month(e.date) = month(current_date) "
			+ "and day(e.date) = day(current_date)")
	public List<Event> searchByToday();
	
	@Query("select e from Event e "
			+ "where e.date between :min and :max")
	public List<Event> searchByWeek(
			@Param("min") Date min, 
			@Param("max") Date max);
	
	@Query("select e from Event e where month(e.date) = month(current_date)")
	public List<Event> searchByMonth();

}
