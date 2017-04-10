package com.revature.beans;


/**
 * Data Transfer Object (DTO) design pattern
 * 	Transfer data between two intermediaries
 * 		1. If you need less data than a bigger bean has
 * 		2. Ifyou have a bucnh of small beans, wrap
 * 	-- Maximum
 * @author bcant
 *
 */
public class Trainee {
	private int id;
	private String name;
	private String major;
	
	
	public Trainee(String name, String major) {
		super();
		this.name = name;
		this.major = major;
	}
	public Trainee() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Trainee [id=" + id + ", name=" + name + ", major=" + major + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
	
}
