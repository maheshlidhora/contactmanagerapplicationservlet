# Contact Manager Application - Servlet

A simple and effective **Contact Manager Web Application** built using **Java Servlets**, **JSP**, and **JDBC**. This application allows users to manage their contact list by adding, viewing, updating, and deleting contact records. Designed to demonstrate the core concepts of Java EE and MVC architecture.

## 🛠️ Tech Stack

- **Java Servlets**
- **JSP (JavaServer Pages)**
- **JDBC (Java Database Connectivity)**
- **MySQL** (as the backend database)
- **HTML / CSS**
- **Apache Tomcat** (for deployment)

## ✨ Features

- Add new contacts
- View all contacts in a tabular format
- Edit contact details
- Delete contacts
- Simple session-based authentication (if implemented)
- Clean MVC architecture (Servlets → JSP → JDBC)

## 💾 Database Setup

1. Install **MySQL** and create a database:
    ```sql
    CREATE DATABASE contact_db;
    ```

2. Create a `contacts` table:
    ```sql
    CREATE TABLE contacts (
        id INT AUTO_INCREMENT PRIMARY KEY,
        name VARCHAR(100) NOT NULL,
        email VARCHAR(100),
        phone VARCHAR(15),
        address VARCHAR(255)
    );
    ```

3. Update your DB configuration in the project:
    - Usually found in a utility or config class like `DBUtil.java`
    - Provide your DB `URL`, `username`, and `password`

## 🚀 Getting Started

1. **Clone the repository**
    ```bash
    git clone https://github.com/yourusername/contactmanagerapplicationservlet.git
    ```

2. **Import the project** into your preferred IDE (like Eclipse or IntelliJ).

3. **Configure Apache Tomcat** in your IDE.

4. **Deploy and Run the Application**.

5. Open in browser:
    ```
    http://localhost:8080/contactmanagerapplicationservlet/
    ```

## 📂 Project Structure

