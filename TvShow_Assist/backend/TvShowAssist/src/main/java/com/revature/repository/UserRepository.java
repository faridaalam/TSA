package com.revature.repository;

import java.util.List;

import com.revature.model.FavShows;
import com.revature.model.User;

public interface UserRepository {
	
	void save (User user);
	
	List<User> findAll();
	
	User findById(int id);
	
	User findByEmail(String email);
	
	void update (User user);

	boolean saveShow(FavShows favshow);

	List<Object> findById1(FavShows favshow);

}
