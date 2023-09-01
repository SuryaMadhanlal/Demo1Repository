package com.main;

import java.util.Scanner;

import com.dao.LoginDAO;
import com.dao.LoginDAOImpl;
import com.exception.LoginException;
import com.model.User;
import com.service.LoginService;
import com.service.LoginServiceImpl;

public class LoginApp {

	public static void main(String[] args) {
		
		LoginDAOImpl.getConnection();
		
		/*
		 * Scanner scanner = new Scanner(System.in);
		 * System.out.println("Enter User Name"); String iName = scanner.next();
		 * System.out.println("Enter Password"); String pwd = scanner.next();
		 * System.out.println("Enter Age"); int user_age = scanner.nextInt(); User user
		 * = new User(); user.setUserName(iName); user.setPassword(pwd);
		 * user.setAge(user_age);
		 * 
		 * 
		 * //LoginDAO loginDAO = new LoginDAOImpl(); LoginService loginService = new
		 * LoginServiceImpl(); String strDAO; try { strDAO =
		 * loginService.createUser(user); if(strDAO != null) { System.out.println(strDAO
		 * + "has been Successfully Created"); }else {
		 * System.out.println("SOMETHING WENT WRONG"); } } catch (LoginException e) {
		 * 
		 * System.err.println(e.getMessage());
		 * 
		 * 
		 * }
		 */
		
		LoginDAO loginDAO = new LoginDAOImpl();
		User user = null;
		try {
			user = loginDAO.readUserByUserNameAndPassword("Surya", "Reset123");
			System.out.println(user);
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}
}
