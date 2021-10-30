package com.example.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = "postgres";
		String password = "postgres";
		String jdbcUrl = "jdbc:postgresql://localhost:5432/web_customer_tracker?useSSL=false";
		String driver = "org.postgresql.Driver";
		
		try {
			Class.forName(driver);
			
			Connection connection = DriverManager.getConnection(jdbcUrl, user , password);
			
			PrintWriter out = response.getWriter();
			
			out.println("Connection Successful!");
			
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
