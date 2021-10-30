package com.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcTest {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:postgresql://localhost:5432/spring-hibernate-tutorial?useSSL=false";
		String user = "postgres";
		String pass = "postgres";
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("connection successful!!!");
			
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
