package com.chinook.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCustomerServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("customerId"));
		String first = req.getParameter("firstName");
		String last = req.getParameter("lastName");
		String email = req.getParameter("email");
		Customer customerReq = new Customer(id, first, last, email);
		Customer customerSes = new Customer(id, first, last, email);
		
		//insert into database
		/*CustomerDAO dao = new CustomerDAO();
		dao.insert();*/
		
		// upon success, prepare the view then send to the homepage
		// (application, session, request, page) all scopes
		req.setAttribute("requestData", customerReq); // forwards the object to the next page
		req.getSession().setAttribute("sessionData", customerSes);
		//req.getSession().setMaxInactiveInterval(10);
		// forward request
		req.getRequestDispatcher("customerHome.jsp").forward(req, resp);
		// doesnt forward request
		//resp.sendRedirect("customerHome.jsp");
		//req.getSession().invalidate(); // erase HTTPSession obj
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
