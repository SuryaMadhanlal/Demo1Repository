package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class MySQLConnectionCheck {

	public Connection getConnection() {
		Connection connection = null;
		Statement statement = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			String driverName = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/stg";
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, "root", "Reset123");
			System.out.println(connection != null ? "Connection established" : "Connection failed");
			
			
		} catch (ClassNotFoundException cnfe) {
			System.out.println("There is no respective jars : " + cnfe.getMessage());
		} catch (SQLException se) {// Catching SQL Exception
			System.out.println("SQL Exception :" + se.getMessage());
		} catch (Exception e) {
			System.out.println(e);
		}

		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}
}
