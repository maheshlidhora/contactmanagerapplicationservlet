package com.jspiders.contactmanagerapplicationservlet.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.jspiders.contactmanagerapplicationservlet.entity.Contact;

public class ContactJDBC {
	private static Driver driver;
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	private static String query;
	
	public static int addContact(int id, String firstName, String lastName, long mobile, String category) {
		int res = 0;
		try {
			openConnection();
			query = "INSERT INTO contact VALUES(?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, firstName);
			preparedStatement.setString(3, lastName);
			preparedStatement.setLong(4, mobile);
			preparedStatement.setString(5, category);
			res = preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}

	public static List<Contact> findAllContacts() {
		List<Contact> contacts = new ArrayList<>();
		try {
			openConnection();
			query = "SELECT * FROM contact";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Contact contact = new Contact();
				contact.setId(resultSet.getInt(1));
				contact.setFirstName(resultSet.getString(2));
				contact.setLastName(resultSet.getString(3));
				contact.setMobileNumber(resultSet.getLong(4));
				contact.setCategory(resultSet.getString(5));
				contacts.add(contact);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return contacts;
	}

	public static int deleteContact(int id) {
		int res = 0;
		try {
			openConnection();
			query = "DELETE FROM contact WHERE ID = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			res = preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}

	public static List<Contact> searchBy(int id, String firstName, String lastName, long mobile, String category) {
		List<Contact> contacts = new ArrayList<>();
		try {
			openConnection();
			query = "SELECT * FROM contact WHERE id =  ? OR firstName = ? OR lastName = ? OR mobile = ? OR category = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, firstName);
			preparedStatement.setString(3, lastName);
			preparedStatement.setLong(4, mobile);
			preparedStatement.setString(5, category);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Contact contact = new Contact();
				contact.setId(resultSet.getInt(1));
				contact.setFirstName(resultSet.getString(2));
				contact.setLastName(resultSet.getString(3));
				contact.setMobileNumber(resultSet.getLong(4));
				contact.setCategory(resultSet.getString(5));
				contacts.add(contact);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return contacts;
	}
	
	public static int editContact(int id, String firstName, String lastName, long mobile, String category) {
		int res=0;
		try {
			openConnection();
			query = "UPDATE contact SET firstName = ? , lastName = ? , mobile = ? , category = ?  WHERE id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			preparedStatement.setLong(3, mobile);
			preparedStatement.setString(4, category);
			preparedStatement.setInt(5, id);
			res = preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}

	private static void openConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/USER", "root", "78789899");
	}

	private static void closeConnection() throws SQLException {
		if (resultSet != null) {
			resultSet.close();
		}
		if (preparedStatement != null) {
			preparedStatement.close();
		}
		if (connection != null) {
			connection.close();
		}
		if (driver != null) {
			DriverManager.deregisterDriver(driver);
		}
	}
}
