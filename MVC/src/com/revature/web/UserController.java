package com.revature.web;

import java.io.IOException;

import javax.naming.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.bean.User;
import com.revature.middle.BusinessDelegate;

public class UserController {
	
	// not a servlet, just a contoller
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String user = request.getParameter("j_username");
		String pass = request.getParameter("j_password");
		try {
			User session = new BusinessDelegate().login(user, pass);
			request.getSession().setAttribute("userData", session);
			request.getRequestDispatcher("HomePage.jsp").forward(request, response);
		} catch (AuthenticationException e) {
			request.setAttribute("authFailed", "Try to login again");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	
	}
	public void deleteUser(HttpServletRequest req, HttpServletResponse resp) {
		
	}

	public void registerUser(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}
	
}
