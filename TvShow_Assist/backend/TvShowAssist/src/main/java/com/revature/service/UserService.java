package com.revature.service;

import java.util.List;

import com.revature.model.LoginTemplate;
import com.revature.model.User;

public interface UserService {
	
	public boolean registerUser(User user);
	
	public List<User> getAllUsers();
	
	public User getUser(int id);
	
	public User getByEmail(String email);
	
	public User login(LoginTemplate loginTemplate);

}
