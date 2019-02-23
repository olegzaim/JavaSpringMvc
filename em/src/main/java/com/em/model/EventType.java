package com.em.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the EVENT_TYPE database table.
 * 
 */
@Entity
@Table(name="EVENT_TYPE")
@NamedQuery(name="EventType.findAll", query="SELECT e FROM EventType e")
public class EventType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="AGE_LIMIT")
	private int ageLimit;

	@Column(name="EVENT_ID")
	private BigInteger eventId;

	private String name;

	public EventType() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAgeLimit() {
		return this.ageLimit;
	}

	public void setAgeLimit(int ageLimit) {
		this.ageLimit = ageLimit;
	}

	public BigInteger getEventId() {
		return this.eventId;
	}

	public void setEventId(BigInteger eventId) {
		this.eventId = eventId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}