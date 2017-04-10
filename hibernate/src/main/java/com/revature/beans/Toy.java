package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Toy {
	@Id
	@Column(name="TOY_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column
	private String description;
	@Column
	private boolean noisy;
	
	// bi direction relationships
	
	// inverse of the child.toys property
	@ManyToOne
	@JoinColumn(name="TOY_OWNER_ID", nullable=true)
	private Child owner;

	public Toy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Toy(String description, boolean noisy, Child owner) {
		super();
		this.description = description;
		this.noisy = noisy;
	
		this.owner = owner;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isNoisy() {
		return noisy;
	}

	public void setNoisy(boolean noisy) {
		this.noisy = noisy;
	}

	public Child getOwner() {
		return owner;
	}

	public void setOwner(Child owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Toy [id=" + id + ", description=" + description + ", noisy=" + noisy + ", owner=" + owner + "]";
	}
	
	
}
