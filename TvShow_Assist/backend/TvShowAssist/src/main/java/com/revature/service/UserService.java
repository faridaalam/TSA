package com.revature.service;

import java.util.List;

import org.hibernate.HibernateException;

import com.revature.model.FavShows;
import com.revature.model.LoginTemplate;
import com.revature.model.User;

public interface UserService {
	
	public boolean registerUser(User user);
	
	public List<User> getAllUsers();
	
	public User getUser(int id);
	
	public User getByEmail(String email);
	
	public User login(LoginTemplate loginTemplate);
	
	public boolean updateUser(User user);

	boolean addFavShow(FavShows favshow);

	List<Object> getAllShows(FavShows favshow);

}
