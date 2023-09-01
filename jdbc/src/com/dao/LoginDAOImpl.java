package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.exception.LoginException;
import com.model.User;


public class LoginDAOImpl implements LoginDAO {

	public static Connection getConnection() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			String driverName = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/stg";
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, "root", "Reset123");
			System.out.println(connection != null ? "connection established" : "connection failed");

		} catch (ClassNotFoundException cnfe) {
			System.out.println("There is no respective jars : " + cnfe.getMessage());
		} catch (SQLException se) {// Catching SQL Exception
			System.out.println("SQL Exception :" + se.getMessage());
		} catch (Exception e) {
			System.out.println(e);
		}

		/*
		 * finally { try { connection.close(); } catch (SQLException e) {
		 * e.printStackTrace(); } }
		 */

		return connection;
	}

	@Override
	public String createUser(User user) {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = null;
		String insertQuery = " INSERT INTO user(user_name,password,age) VALUES (?,?,?)";

		try {
			preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setInt(3, user.getAge());
			preparedStatement.execute();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return user.getUserName();
	}

	@Override
	public User readUserByUserNameAndPassword(String userName, String password) throws LoginException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		User user = new User();
		String readQuery = "Select * from user WHERE user_name =  ? AND password = ?";
		try {
			preparedStatement = connection.prepareStatement(readQuery);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {

				user.setUserName(resultSet.getString("user_name"));
				user.setPassword(resultSet.getString("password"));
				user.setAge(resultSet.getInt("age"));

			}
		} catch (SQLException e) {
			throw new LoginException("No data Found");
		}

		return user;
	}

	@Override
	public User updateUser(User user,  String password , String name , int id) throws LoginException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		User user1 = new User();
		int waste = 0;
		String updateQuery = "UPDATE user SET password = ? WHERE user_name = ? AND user_id = ?";
		try {
			preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setString(1, password);
			preparedStatement.setString(2, name);
			preparedStatement.setInt(3, id);
			waste= 	preparedStatement.executeUpdate();
			 if( waste==1 ) {
				 user1=user;
			 }
			
		} catch (SQLException e) {
			
			throw new LoginException("No data Found");
		}
		return user1;
	}

	@Override
	public String deleteUserByUserID(int userId) throws LoginException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = null;
		String deleteQuery = "delete from user WHERE user_id = ?";
		try {
			preparedStatement = connection.prepareStatement(deleteQuery);
			preparedStatement.setInt(1, userId);
			
				preparedStatement.execute();
			
		} catch (SQLException e) {
			throw new LoginException("No data Found");
			
		}
		
		
		return " User deleted successfully "  ;
	}

	@Override
	public User searchByUserId(int userId) throws LoginException {
	 Connection connection =	getConnection();
	 PreparedStatement preparedStatement = null;
	 User user = null;
	 ResultSet resultSet = null;
	 String searchQuery = "Select user_id,user_name,password FROM user WHERE user_id = ?";
	  try {
		preparedStatement = connection.prepareStatement(searchQuery);
		preparedStatement.setInt(1, userId);
		resultSet= preparedStatement.executeQuery();
		user = new User();
		while (resultSet.next()) {
			user.setUserId(resultSet.getInt("user_Id"));
			user.setUserName(resultSet.getString("user_name"));
			user.setPassword(resultSet.getString("password"));
		}
		
		
		
	} catch (SQLException e) {
		throw new LoginException(e.getMessage());	
	}
		return 	user;
	}

	@Override
	public List<User> getAllUser() throws LoginException {
		Connection connection =	getConnection();
		 PreparedStatement preparedStatement = null;
		 User user = null;
		 List<User> list = new ArrayList<User>();
		 ResultSet resultSet = null;
		 String getAlluserData = "select * from user";
		 try {
			preparedStatement = connection.prepareStatement(getAlluserData);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				user = new User();
				user.setUserId(resultSet.getInt("user_Id"));
				user.setUserName(resultSet.getString("user_name"));
				list.add(user);
			}
		} catch (SQLException e) {
			throw new LoginException("No data Found");
		}
		return list;
	}

	@Override
	public User updateUser(User user) throws LoginException {
		// TODO Auto-generated method stub
		return null;
	}

}
