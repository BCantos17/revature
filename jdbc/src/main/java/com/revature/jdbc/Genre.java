package com.revature.jdbc;

import java.sql.SQLException;
import java.util.List;

public class Genre implements GenreDAO{
	private int id;
	private String name;
	
	
	public Genre() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Genre(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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


	public void insert(Genre genre) {
		// TODO Auto-generated method stub
		
	}


	public List<Genre> query(String like) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	public void close() throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
