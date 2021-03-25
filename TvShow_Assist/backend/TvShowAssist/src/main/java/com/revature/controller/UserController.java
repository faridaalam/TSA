package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.revature.ajax.ClientMessage;
import com.revature.model.User;

public interface UserController {

	ClientMessage registerUser(User user);
	
//	User findUser(User user, HttpServletRequest request);
	
	List<User> findAllUsers();
}
