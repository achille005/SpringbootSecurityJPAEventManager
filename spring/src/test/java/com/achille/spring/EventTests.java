package com.achille.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import com.achille.spring.services.EventService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EventTests {
	
	@Autowired
	private EventService eventService;
	
	@Test
    public void findTest() {
		assertThat(eventService.find(1)).isNotNull();
    }
	
	@Test
    public void searchByTodayTest() {
		assertThat(eventService.searchByToday()).isNotNull();
    }
	
	@Test
    public void searchByWeekTest() {
		assertThat(eventService.searchByWeek()).isNotNull();
    }
	
	@Test
    public void searchByMonthTest() {
		assertThat(eventService.searchByMonth()).isNotNull();
    }
	
}
