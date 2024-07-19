package com.jspiders.contactmanagerapplicationservlet.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspiders.contactmanagerapplicationservlet.entity.Contact;
import com.jspiders.contactmanagerapplicationservlet.jdbc.ContactJDBC;

@WebServlet("/ContactInfos")
public class ContactInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id=0;
		long mobile=0;
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		RequestDispatcher requestDispatcher;
		if (request.getParameter("id").length()==4) {
			try {
				id = Integer.parseInt(request.getParameter("id"));
			} catch (Exception e) {
				writer.println("<script>alert(\"Please Provide Valid 4-Digits Numerical ID.\")</script>");
			}
		} else {
			writer.println("<script>alert(\"Only use 4-Digits Numerical ID.\")</script>");
		}
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		if (request.getParameter("mobile").length()==10) {
			try {
				mobile = Long.parseLong(request.getParameter("mobile"));
			} catch (Exception e) {
				writer.println("<script>alert(\"Please Provide Valid 10-Digits Contact No.\")</script>");
			}
		} else {
			writer.println("<script>alert(\"Only use 10-Digits Contact No.\")</script>");
		}
		String category = request.getParameter("category");
		int res=0;
		if (id!=0 && mobile!=0) {
			res = ContactJDBC.addContact(id, firstName, lastName, mobile, category);
		} 
		if (res == 1) {
			writer.println("<script>alert(\"Contact Added\")</script>");
		} else {
			writer.println("<script>alert(\"Contact Not Added\")</script>");
		}
		requestDispatcher = request.getRequestDispatcher("addContact.jsp");
		requestDispatcher.include(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Contact> contacts = ContactJDBC.findAllContacts();
		RequestDispatcher requestDispatcher;
		if (contacts != null && contacts.size() > 0) {
			req.setAttribute("list", contacts);
			requestDispatcher = req.getRequestDispatcher("contactInfo.jsp");
			requestDispatcher.forward(req, resp);
		} else {
			resp.setContentType("text/html");
			PrintWriter writer = resp.getWriter();
			writer.println("<script>alert(\"Contact List is Empty\")</script>");
			requestDispatcher = req.getRequestDispatcher("index.jsp");
			requestDispatcher.include(req, resp);
		}
	}
}
