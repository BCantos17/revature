package com.revature.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ExampleClass {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		Class.forName("oracle.jdbc.OracleDriver");
//		Connection conn =
//		 DriverManager.getConnection("jdbc:oracle:thin:@locatehost1521:xe"
//				, "chinook"
//				, "p4ssw0rd");
//		Genre genre = new Genre();
//		genre.setName("Chill Out");
//		String sql = "INSERT INTO GENRE NAME) VALUES(";
//		sql += genre.getName() + "' )";
//		Statement stmt = conn.createStatement();
//		stmt.executeupdate(sql);
		
		GenreDAO dao = new GenreDAOimpl();
		List<Genre> list = dao.query("Metal");
		
		for(Genre g : list){
			System.out.println(g);
		}
		dao.close();
		System.out.println("comfirmed!");
		

	}
//	public static void cool(String[] args) {
//		GenreDAO dao = new GenreDAOimpl();
//		
//		
//		// working with some data
//		Genre genre =  new Genre();
//		genre.setName("Chill Out");
//		
//		// save it
//		genre.insert(genre);
//		dao.close();
//		
//	}
}
