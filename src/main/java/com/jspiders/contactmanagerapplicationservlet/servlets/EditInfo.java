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

@WebServlet("/EditInfos")
public class EditInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=0;
		RequestDispatcher requestDispatcher;
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		try {
			id = Integer.parseInt(req.getParameter("id"));
		} catch (Exception e) {
			writer.println("<script>alert(\"Please Provide Valid Numerical ID.\")</script>");
		}
		List<Contact> contacts = ContactJDBC.searchBy(id,"null","null",0,"null");
		if (contacts != null && contacts.size() > 0) {
			req.setAttribute("list", contacts);
			requestDispatcher = req.getRequestDispatcher("editContactInfo.jsp");
			requestDispatcher.forward(req, resp);
		} else {
			writer.println("<script>alert(\"CONTACT DOES NOT EXIST\")</script>");
			requestDispatcher = req.getRequestDispatcher("editByID.jsp");
			requestDispatcher.include(req, resp);
		}
	}
}
