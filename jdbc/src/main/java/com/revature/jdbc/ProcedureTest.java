package com.revature.jdbc;

import java.sql.SQLException;

public class ProcedureTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		EmployeeDAO dao = new EmployeeDAO();
		String name = dao.getFullName(1);
		System.out.println(name);
	}
}
