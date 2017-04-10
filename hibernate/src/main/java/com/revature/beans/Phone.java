package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Phone {
	@Id
	@Column(name="PHONE_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	// DO NOT PUT ID in equals or hascode
	// We cannot rel on what the value will be
	private int id;
	@Column(name="PHONE_NUMBER")
	private String number;
	
	public Phone() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Phone(String number) {
		super();
		this.number = number;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "Phone [id=" + id + ", number=" + number + "]";
	}
	
}
