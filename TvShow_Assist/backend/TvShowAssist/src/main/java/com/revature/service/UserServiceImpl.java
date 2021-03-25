package com.revature.service;

import java.awt.print.Printable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateError;
import org.hibernate.HibernateException;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.LoginTemplate;
import com.revature.model.User;
import com.revature.repository.UserRepository;

import antlr.collections.Stack;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	private Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;
	
	public UserServiceImpl() {
		logger.trace("Injection using Autowired User Repository in UserServiceImpl");
	}

	@Override
	public boolean registerUser(User user){
	
	try {
		
		userRepository.save(user);
		return true;
	} catch (Exception e) {
		
		return false;
	}
	
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(int id) {
		return userRepository.findById(id);
	}

	@Override
	public User getByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User login(LoginTemplate loginTemplate) {
		
		//Tests
		System.out.println("HIT THE LOGIN METHOD");
		System.out.println(loginTemplate);
		
		String matchEmail = loginTemplate.getEmail();
		
		//Test
		System.out.println(matchEmail);
		
		User user = userRepository.findByEmail(matchEmail);
		System.out.println(user);
		if (loginTemplate.getPassword().equals(user.getPassword())) {
			return user;
		}
		return null;
	}
	
}
