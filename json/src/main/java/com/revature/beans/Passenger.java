package com.revature.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Passenger {
	@JsonProperty
	private String name;
	@JsonProperty
	private int age;
	@JsonProperty
	private boolean isLicensed;
	
	
	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Passenger(String name, int age, boolean isLicensed) {
		super();
		this.name = name;
		this.age = age;
		this.isLicensed = isLicensed;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public boolean isLicensed() {
		return isLicensed;
	}


	public void setLicensed(boolean isLicensed) {
		this.isLicensed = isLicensed;
	}
	
	
}
