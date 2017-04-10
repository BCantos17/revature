package com.chinook.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns={"login"}, loadOnStartup=2)
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookies = req.getCookies();
		for(Cookie c : cookies ){
			if(c.getName().equals("username")){
				req.setAttribute("welcomeBack", "Welcome back, value customer");
			}
		}
		
		// create a new cookie; Stores username on client machine		
		String rememberMe = req.getParameter("remember");
		if(rememberMe != null){
			
			Cookie cookie = new Cookie("username", req.getParameter("username"));
			cookie.setMaxAge(10);
			resp.addCookie(cookie);
		}
		req.getRequestDispatcher("loginHome.jsp").forward(req, resp);;
	}
}
