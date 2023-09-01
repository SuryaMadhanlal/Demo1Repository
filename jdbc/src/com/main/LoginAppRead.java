package com.main;

import java.util.List;
import java.util.Scanner;

import com.dao.LoginDAO;
import com.dao.LoginDAOImpl;
import com.exception.LoginException;
import com.model.User;
import com.service.LoginService;
import com.service.LoginServiceImpl;

public class LoginAppRead {

	public static void main(String[] args) {

		/*
		 * LoginDAO loginDAO = new LoginDAOImpl(); try { List<User> alluser =
		 * loginDAO.getAllUser(); for (User object : alluser) {
		 * System.out.println("User Name : " + object.getUserName() +
		 * " and his User ID: STGI" + object.getUserId());
		 * 
		 * System.out.println(); }
		 * 
		 * } catch (LoginException e) { System.err.println(e.getMessage());
		 * 
		 * }
		 */

		
		LoginService loginService = new LoginServiceImpl();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter userId");
		
		int uid = scanner.nextInt();
		try {
			String output =  loginService.deleteUserByUserID(uid);
			if (output != null) {
				System.out.println(output);
			}
		} catch (LoginException e) {
			System.err.println(e.getMessage());
		}
		
		
		
		
		
		
		
		
		
		/*
		 * try { int user_id1 = 0; User userService =
		 * loginService.searchByUserId(user_id1); if (userService != null) {
		 * System.out.println("User id is :" + userService.getUserId());
		 * System.out.println("User Name is : " + userService.getUserName()); } } catch
		 * (LoginException e) {
		 * 
		 * System.err.println(e.getMessage()); }
		 */
		
		
	
		/*
		 * System.out.println("Enter Username"); String usName = scanner.next();
		 * System.out.println("Enter Password"); String pwd = scanner.next(); try {
		 * 
		 * User userService = loginService.readUserByUserNameAndPassword(usName, pwd);
		 * System.out.println(userService); if (userService != null) {
		 * System.out.println("User id is :" + userService.getUserId());
		 * System.out.println("User Name is : " + userService.getUserName());
		 * System.out.println("User Password is : "+ userService.getPassword());
		 * System.out.println("Age of the User :" + userService.getAge()); } else {
		 * throw new LoginException("Invalid Details Provided"); }
		 * 
		 * } catch (LoginException e) { System.err.println(e.getMessage());
		 * 
		 * }
		 */
		User user = new User();
	
	
		/*
		 * try {
		 * 
		 * 
		 * System.out.println("Update  Password"); String pwd = scanner.next();
		 * System.out.println("Enter Username"); String uName = scanner.next();
		 * System.out.println("Enter user id"); int uid = scanner.nextInt(); User user2
		 * = loginService.updateUser(user, pwd, uName, uid); if (user2 != null) {
		 * System.out.println("updated"); } } catch (LoginException e) {
		 * System.err.println(e.getMessage());
		 * 
		 * }
		 */
}
}