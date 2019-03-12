package com.em.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigInteger;

/**
 * The persistent class for the EVENT_USER database table.
 * 
 */
@Entity
@Table(name = "EVENT_USER")
@NamedQuery(name = "EventUser.findAll", query = "SELECT e FROM EventUser e")
public class EventUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@JoinColumn(name = "EVENT_ID", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Integer eventId;

	@JoinColumn(name = "USER_ID", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Integer userId;

	public EventUser() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEventId() {
		return this.eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}