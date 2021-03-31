package com.revature.service;

import java.util.List;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.FavShows;
import com.revature.model.LoginTemplate;
import com.revature.model.User;
import com.revature.repository.UserRepository;
import com.revature.repository.UserRepositoryImpl;

@Service("userService")
public class UserServiceImpl implements UserService{
	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	public static UserRepository eDao = new UserRepositoryImpl();
	
	
	@Autowired
	private UserRepository userRepository;
	
	public UserServiceImpl() {
		logger.trace("Injection using Autowired User Repository in UserServiceImpl");
	}

	@Override
	public boolean registerUser(User user){
	
	try {
		
		getUserRepository().save(user);
		return true;
	} catch (Exception e) {
		
		return false;
	}
	
	}

	@Override
	public List<User> getAllUsers() {
		return getUserRepository().findAll();
	}
	
	@Override
	public boolean addFavShow(FavShows favshow){
	
	try {
		System.out.println("AddingSHow");
		System.out.println(favshow);
		
		getUserRepository().saveShow(favshow);
		return true;
	} catch (Exception e) {
		
		return false;
	}
	
	}
	

	@Override
	public List<Object> getAllShows(FavShows favshow) {
		return (List<Object>) getUserRepository().findById1(favshow);
	}

	@Override
	public User getUser(int id) {
		return getUserRepository().findById(id);
	}

	@Override
	public User getByEmail(String email) {
		return getUserRepository().findByEmail(email);
	}

	@Override
	public User login(LoginTemplate loginTemplate) {
		
		try {
		//Tests
		System.out.println("HIT THE LOGIN METHOD");
		System.out.println(loginTemplate);
		
		String matchEmail = loginTemplate.getEmail();
		
		//Test
		System.out.println(matchEmail);
		
		User user = getUserRepository().findByEmail(matchEmail);
		System.out.println(user);
		if (loginTemplate.getPassword().equals(user.getPassword())) {
			return user;
		}else return null;
		} catch (Exception e){
			System.out.println("user is null");
		return null;
	}}

	@Override
	public boolean updateUser(User user) {
		try {
			getUserRepository().update(user);
			return true;
		} catch (Exception e) {
			
			return false;
		}
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
}
