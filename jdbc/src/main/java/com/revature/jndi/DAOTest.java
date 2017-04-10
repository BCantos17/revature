package com.revature.jndi;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DAOTest {
	// Jar File in classpath
	// C:\Oracle\Middleware\Oracle_Home\wlserver\server\lib\weblogic.jar
	public static void main(String[] args)  {
		Connection conn;
		try {
			conn = ServiceLocator.getChinookDatabase()
								.getConnection();		
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from genre");
			while(rs.next()){
				System.out.println(rs.getString("Name"));
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
}
