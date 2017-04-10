package com.chinook.server;

public class Customer {
	private int id;
	private String first;
	private String last;
	private String email;
	
	public Customer() {
		super();

	}
	
	public Customer(int id, String first, String last, String email) {
		super();
		this.id = id;
		this.first = first;
		this.last = last;
		this.email = email;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return first + " " + last;
	}
}
