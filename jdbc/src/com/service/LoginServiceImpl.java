package com.service;

import java.sql.Connection;
import java.util.List;

import com.dao.LoginDAO;
import com.dao.LoginDAOImpl;
import com.exception.LoginException;
import com.model.User;

public class LoginServiceImpl implements LoginService {

	@Override
	public String createUser(User user)  throws LoginException {
		Connection connection = LoginDAOImpl.getConnection();
		String daoString =null ;
		if (user.getPassword().length()>= 8) {
			LoginDAO loginDAO = new LoginDAOImpl();
			daoString = loginDAO.createUser(user);
		}else {
			throw new LoginException("Invalid Credentials");
		}
		return daoString;
	}

	@Override
	public User readUserByUserNameAndPassword(String userName, String password) throws LoginException {
		Connection connection = LoginDAOImpl.getConnection();
		User daoRead = null;
		if(userName.length()>=5 && password.length()>=5) {
			LoginDAO loginDAO = new LoginDAOImpl();
		daoRead =	loginDAO.readUserByUserNameAndPassword(userName, password);
		

		}else {
			throw new LoginException("Invalid Details");
		}
		return daoRead;
	}

	@Override
	public User updateUser(User user,  String password , String name , int id) throws LoginException{
		Connection connection = LoginDAOImpl.getConnection();
		User daoUpdate= new User();
		if(password.length()>=5) {
			LoginDAO loginDAO = new LoginDAOImpl();
			daoUpdate = loginDAO.updateUser(user);
		}else {
			throw new LoginException("Invalid Details");
		}
		return daoUpdate;
	}

	@Override
	public String  deleteUserByUserID(int userId) throws LoginException {
		Connection connection =LoginDAOImpl.getConnection();
		String var = null;
		int userIdlength = String.valueOf(userId).length();
		if(userIdlength==4) {
			LoginDAO loginDAO = new LoginDAOImpl();
			var = loginDAO.deleteUserByUserID(userId);
		}
		else {
			throw new LoginException("Invalid id");
		}
		
		return var;
	}

	@Override
	public User searchByUserId(int userId) throws LoginException {
	int length = String.valueOf(userId).length();
		User userDAO = null;
		if (length >= 4) { 
			LoginDAO loginDAO7 = new LoginDAOImpl();
			userDAO= loginDAO7.searchByUserId(userId);
			
		} else {
			throw new LoginException("Please check user Id");
		}
		return userDAO;
	}

}
