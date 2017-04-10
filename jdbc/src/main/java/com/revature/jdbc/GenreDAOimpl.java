package com.revature.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GenreDAOimpl implements GenreDAO{
	private Connection conn;
	// the driver name (jdbc:oracle:thin):@DNS name:port number:database SID
	private static final String URL = "jdbc:oracle:thin:@localhost1521:xe";
	private static final String USER = "chinook";
	private static final String PASS = "p4ssw0rd";

	/**
	 * establishes a connection to database
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public GenreDAOimpl() throws ClassNotFoundException, SQLException {
		// as JDBC 4.0, this isnt needed
		// forces class to be loaded
		Class.forName("oracle.jdbc.OracleDriver");
		conn = DriverManager.getConnection(URL, USER, PASS);
	}

	public void insert( Genre genre ) throws SQLException{
		/*
		 * Statement: compiled by the database
		 * preapredstatement: compiled by java
		 */
//		String sql = "INSERT INTO GENRE NAME) VALUES(";
//		sql += genre.getName() + "' )";
//		Statement stmt = conn.createStatement(); // factory
//		stmt.executeupdate(sql);
		
		String sql = "INSERT INTO GENRE(NAME) VALUES(?)";
		PreparedStatement stmt = conn.prepareStatement(sql, new String[]{"genreid"});
		// bind values to ? params
		stmt.setString(1, genre.getName());
		stmt.executeUpdate();
		
		// get the generated values
		ResultSet rs = stmt.getGeneratedKeys();
		//goto the first row
		rs.next();
		// get the value
		int generatedPK = rs.getInt(1);
		genre.setId(generatedPK);
	}

	public List<Genre> query(String like) throws SQLException {
		// stores all the rows from the query
		List<Genre> results = new ArrayList<Genre>();
		// construct query
		String sql = "SELECT GERNR, NAME, FROM GENRE WHERE" + "NAME LIKE ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, "%" + like + "%");
		ResultSet rs = stmt.executeQuery();
		mapRows(rs, results);

		return results;
	}

	private void mapRows(ResultSet rs, List<Genre> results) throws SQLException {
		while (rs.next()) {
			// get values from row
			int id = rs.getInt("GENREID");
			String name = rs.getString("NAME");
			Genre obj = new Genre(id, name);
			// add object to list
			results.add(obj);
		}
	}

	public void close() throws SQLException {
		conn.close();
	}
}