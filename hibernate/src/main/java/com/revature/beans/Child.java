package com.revature.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Child {
	
	@Id
	@Column(name="KID_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	@Column(name="KID_NAME")
	private String name;
	
	// Bi-directional. already mapped by Parents.kids porperty
	@ManyToMany(mappedBy="kids")
	private Set<Parent> parents = new HashSet<Parent>();
	
	// Left to Right.. This class to that Class
	@OneToMany(mappedBy="owner")
	private Set<Toy> toys;

	public Child() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Child(String name, Set<Parent> parents) {
		super();
		this.name = name;
		this.parents = parents;
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
	public Set<Parent> getParents() {
		return parents;
	}
	public void setParents(Set<Parent> parents) {
		this.parents = parents;
	}
	public Set<Toy> getToys() {
		return toys;
	}
	public void setToys(Set<Toy> toys) {
		this.toys = toys;
	}
	@Override
	public String toString() {
		return "Child [id=" + id + ", name=" + name + ", parents=" + parents + ", toys=" + toys + "]";
	}
}
