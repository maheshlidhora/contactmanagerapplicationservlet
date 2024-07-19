package com.jspiders.contactmanagerapplicationservlet.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspiders.contactmanagerapplicationservlet.jdbc.ContactJDBC;

@WebServlet("/ContactDeleteInfos")
public class ContactDeleteInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
		}
		int res = ContactJDBC.deleteContact(id);
		System.out.println(res);
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		RequestDispatcher requestDispatcher;
		if (res == 1) {
			writer.println("<script>alert(\"CONTACT DELETED\")</script>");
		} else {
			writer.println("<script>alert(\"CONTACT DOES NOT EXIST\")</script>");
		}
		requestDispatcher = request.getRequestDispatcher("deleteContact.jsp");
		requestDispatcher.include(request, response);
	}
}
