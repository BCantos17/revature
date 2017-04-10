package com.revature.jdbc;

import java.sql.SQLException;
import java.util.List;

public interface GenreDAO {
	
	// create
	public void insert(Genre genre) throws SQLException;
	public List<Genre> query(String like) throws SQLException;
	public void close() throws SQLException;
	
	// retrieve
	/**
	 * public Genre get(int pk);
	 * public List<Genre> getall()
	 * public List<Genre> query(String like);
	 * 			
	 */
	
	// update
	/**
	 *  public void update(Genre genre)
	 */
	
	// delete
	/**
	 * public void delete(Genre genre)
	 * public void delete(id pk)
	 */
}