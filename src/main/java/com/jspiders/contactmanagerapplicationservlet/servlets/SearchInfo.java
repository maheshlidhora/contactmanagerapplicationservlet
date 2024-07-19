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

@WebServlet("/SearchInfos")
public class SearchInfo extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String searchChoiceType = req.getParameter("searchChoice");
		String searchChoiceValue = req.getParameter("searchChoiceValue");

		int id = 0;
		String firstName = null;
		String lastName = null;
		long mobileNumber = 0;
		String category = null;

		RequestDispatcher requestDispatcher;
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();

		if (searchChoiceType != null) {
			switch (searchChoiceType) {
			case "ID":
				try {
					id = Integer.parseInt(searchChoiceValue);
				} catch (Exception e) {
				}
				break;

			case "First Name":
				firstName = searchChoiceValue;
				break;

			case "Last Name":
				lastName = searchChoiceValue;
				break;

			case "Mobile Number":
				try {
					mobileNumber = Long.parseLong(searchChoiceValue);
				} catch (Exception e) {
				}
				break;

			case "Category":
				category = searchChoiceValue;
				break;

			default:
				break;
			}
			List<Contact> contacts = ContactJDBC.searchBy(id, firstName, lastName, mobileNumber, category);
			if (contacts != null && contacts.size() > 0) {
				req.setAttribute("list", contacts);
				requestDispatcher = req.getRequestDispatcher("contactInfo.jsp");
				requestDispatcher.forward(req, resp);
			} else {
				writer.println("<script>alert(\"CONTACT DOES NOT EXIST\")</script>");
				requestDispatcher = req.getRequestDispatcher("searchChoice.jsp");
			}
		} else {
			writer.println("<script>alert(\"PLEASE CHOOSE A SEARCH CRITERIA\")</script>");
			requestDispatcher = req.getRequestDispatcher("searchChoice.jsp");
		}
		requestDispatcher.include(req, resp);
	}
}
