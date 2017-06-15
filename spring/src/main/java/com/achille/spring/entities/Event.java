package com.achille.spring.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Achille
 *
 */
@Entity
@Table(name = "event")
public class Event implements java.io.Serializable {

	private Integer id;
	private User usr;
	private String title;
	private Date date;
	private Date time;
	private String location;
	private String attendeeList;
	private Date reminderTime;
	private int reminderSent;

	public Event() {
	}

	public Event(User usr, String title, Date date, Date time, String location, String attendeeList, Date reminderTime,
			int reminderSent) {
		this.usr = usr;
		this.title = title;
		this.date = date;
		this.time = time;
		this.location = location;
		this.attendeeList = attendeeList;
		this.reminderTime = reminderTime;
		this.reminderSent = reminderSent;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId", nullable = false)
	public User getUsr() {
		return this.usr;
	}

	public void setUsr(User usr) {
		this.usr = usr;
	}

	@NotEmpty(message = "{require}")
	@Column(name = "title", nullable = false, length = 250)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date", nullable = false, length = 0)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "time", nullable = false, length = 0)
	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@NotEmpty(message = "{require}")
	@Column(name = "location", nullable = false, length = 250)
	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@NotEmpty(message = "{require}")
	@Column(name = "attendeeList", nullable = false, length = 65535)
	public String getAttendeeList() {
		return this.attendeeList;
	}

	public void setAttendeeList(String attendeeList) {
		this.attendeeList = attendeeList;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "reminderTime", nullable = false, length = 0)
	public Date getReminderTime() {
		return this.reminderTime;
	}

	public void setReminderTime(Date reminderTime) {
		this.reminderTime = reminderTime;
	}

	@Min(1)
	@Column(name = "reminderSent", nullable = false)
	public int getReminderSent() {
		return this.reminderSent;
	}

	public void setReminderSent(int reminderSent) {
		this.reminderSent = reminderSent;
	}

}
