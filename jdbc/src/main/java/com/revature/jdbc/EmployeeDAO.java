package com.revature.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class EmployeeDAO {
	
	public int youngEmployees() throws SQLException, ClassNotFoundException{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", 
				"chinook", 
				"p4ssw0rd");
		
		CallableStatement stmt = conn.prepareCall("? = YOUNG_EMPLOYEE()");
		stmt.registerOutParameter(1, Types.INTEGER);
		stmt.execute();
		int result = 0;
		result = stmt.getInt(1);

		return result;
	}
	
	public String getFullName(int id) throws SQLException, ClassNotFoundException{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", 
				"chinook", 
				"p4ssw0rd");
		String fullname = ""; // OUT param
		// call procedure
		CallableStatement stmt = conn.prepareCall("Call Employee_Fullname(?,?)");
		stmt.setInt(1, id); // bind IN param
		stmt.registerOutParameter(2, Types.VARCHAR);
		stmt.execute();
		fullname = stmt.getString(2);
		
		conn.close();
		return fullname;
	}
}
	