package com.service;

import java.util.List;

import com.exception.LoginException;
import com.model.User;

public interface LoginService {
	public abstract String createUser(User user) throws LoginException;

	public abstract User searchByUserId(int userId) throws LoginException;



	public abstract User readUserByUserNameAndPassword(String userName, String password) throws LoginException;

	public User updateUser(User user,  String password , String name , int id) throws LoginException;

	public abstract String deleteUserByUserID(int userId) throws LoginException;
}
