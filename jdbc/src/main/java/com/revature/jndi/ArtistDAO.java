package com.revature.jndi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ArtistDAO {
	
	public ArtistDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	private Connection conn;
	
	public void insert(int id, String name) throws SQLException{
		String sql = "insert into artist values(?,?)";
		PreparedStatement stmt = conn.prepareStatement("sql");
		stmt.setInt(1, id);
		stmt.setString(2, name);
		stmt.executeUpdate();
	}
}
