package com.revature.jndi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AlbumDAO {
	public AlbumDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	private Connection conn;
	
	public void insert(int albumid, String title, int artistid) throws SQLException{
		String sql = "insert into album values(?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, albumid);
		stmt.setString(2, title);
		stmt.setInt(3, artistid);
		stmt.executeUpdate();
	}
}
