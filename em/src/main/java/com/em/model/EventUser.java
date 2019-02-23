package com.em.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the EVENT_USER database table.
 * 
 */
@Entity
@Table(name="EVENT_USER")
@NamedQuery(name="EventUser.findAll", query="SELECT e FROM EventUser e")
public class EventUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="EVENT_ID")
	private BigInteger eventId;

	@Column(name="USER_ID")
	private BigInteger userId;

	public EventUser() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigInteger getEventId() {
		return this.eventId;
	}

	public void setEventId(BigInteger eventId) {
		this.eventId = eventId;
	}

	public BigInteger getUserId() {
		return this.userId;
	}

	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}

}