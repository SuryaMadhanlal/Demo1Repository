package com.dao;

import java.sql.Connection;
import java.util.List;

import com.exception.LoginException;
import com.model.User;

public interface LoginDAO {

	// CRUD

	public abstract String createUser(User user);

	public abstract User searchByUserId(int userId) throws LoginException;

	public abstract List<User> getAllUser()throws LoginException;

	public abstract User readUserByUserNameAndPassword(String userName, String password) throws LoginException;

	public abstract User updateUser(User user) throws LoginException;

	public abstract String deleteUserByUserID(int userId) throws LoginException;

	User updateUser(User user, String password, String name, int id) throws LoginException;

}
