package com.revature.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * JPA annotations insetad of HBM XML files
 * #1 easier; #beans compatible with other OMR/Persistance Frameworks
 *
 */

@Cacheable
@Entity
@Table(name="ORM_PARENT_TABLE")// name of Physical Table
public class Parent {
	
	@Id
	@Column(name="ORM_PARENT_ID") // name of column
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;						  // name of bean porperty
	
								// set constraints
	@Column(nullable=false, unique=true, length=50, updatable=false)
	private String name;
	
	@OneToOne(cascade=CascadeType.REMOVE, fetch=FetchType.LAZY) 	// delete orphans
	@JoinColumn(nullable=false)				// configure FK columns
	private  Phone phone;
	
	@ManyToMany(fetch=FetchType.EAGER)		// load kids when I get parent
	@JoinTable(joinColumns={
			@JoinColumn(name="PARENT_ID"),
			@JoinColumn(name="CHILD_ID")
			})
	private Set<Child> kids = new HashSet<Child>();
	public Parent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Parent(String name, Phone phone) {
		super();
		this.name = name;
		this.phone = phone;
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
	public Phone getPhone() {
		return phone;
	}
	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	public Set<Child> getKids() {
		return kids;
	}
	public void setKids(Set<Child> kids) {
		this.kids = kids;
	}
	@Override
	public String toString() {
		return "Parent [id=" + id + ", name=" + name + ", phone=" + phone + ", kids=" + kids + "]";
	}
}
