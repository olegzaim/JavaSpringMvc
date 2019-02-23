package com.em.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the USER_BALANCE database table.
 * 
 */
@Entity
@Table(name="USER_BALANCE")
@NamedQuery(name="UserBalance.findAll", query="SELECT u FROM UserBalance u")
public class UserBalance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private BigInteger balance;

	@Column(name="USER_ID")
	private BigInteger userId;

	public UserBalance() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigInteger getBalance() {
		return this.balance;
	}

	public void setBalance(BigInteger balance) {
		this.balance = balance;
	}

	public BigInteger getUserId() {
		return this.userId;
	}

	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}

}