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

@WebServlet("/EditContactDetails")
public class EditDetails extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long mobile=0;
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		RequestDispatcher requestDispatcher;
		int id = Integer.parseInt(req.getParameter("id"));
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		if (req.getParameter("mobile").length()==10) {
			try {
				mobile = Long.parseLong(req.getParameter("mobile"));
			} catch (Exception e) {
				writer.println("<script>alert(\"Please Provide Valid 10-Digits Contact No.\")</script>");
			}
		} else {
			writer.println("<script>alert(\"Only use 10-Digits Contact No.\")</script>");
		}
		String category = req.getParameter("category");
		int res = 0;
		if (mobile!=0) {
			res = ContactJDBC.editContact(id, firstName, lastName, mobile, category);
		}
		if (res == 1) {
			writer.println("<script>alert(\"Contact Updated\")</script>");
		} else {
			writer.println("<script>alert(\"Contact Not Updated\")</script>");
		}
		requestDispatcher = req.getRequestDispatcher("editByID.jsp");
		requestDispatcher.include(req, resp);
	}
}
