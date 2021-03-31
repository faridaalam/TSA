package com.revature.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.revature.model.FavShows;
import com.revature.model.User;
import com.revature.repository.UserRepository;
import com.revature.repository.UserRepositoryImpl;
import com.revature.service.UserServiceImpl;

public class ServiceTest {
	
	public static UserRepository eDao = new UserRepositoryImpl();
	
	//class to be tested
	private UserServiceImpl eserv;
	
	
	//
	private UserRepositoryImpl edaoImpl;
	
	
//	@Mock
//	SessionFactory sessionFactory;

	@Before
	public void setup() {
		
//		Mockito.verify(sessionFactory).getCurrentSession();
		
		eserv = new UserServiceImpl();
		
		/*
		 * Here, we are creating a fake DB connection
		 * 
		 */
		
		edaoImpl = mock(UserRepositoryImpl.class);
		
		//here we set the UserRepositoryImpl OF the service layer to the one that we have mocked
		
		eserv.setUserRepository(edaoImpl);
	}
	
	@Test
	public void happyPathScenario() {
		User sampleUser = new User(1, "a", "b", "c", "d", "e");
		
		List<User> list = new ArrayList<User>();
		list.add(sampleUser);
		
		when(edaoImpl.findByEmail("c")).thenReturn(sampleUser);
		
		User foundByUsername = eserv.getByEmail(sampleUser.getEmail());
		
		assertEquals(sampleUser, foundByUsername);
	}
	
	@Test
	public void happyPathScenario2() {
		User sampleUser = new User(1, "a", "b", "c", "d", "e");
		
		List<User> list = new ArrayList<User>();
		list.add(sampleUser);
		
		when(edaoImpl.findById(1)).thenReturn(sampleUser);
		
		User foundByUsername = eserv.getUser(sampleUser.getId());
		
		assertEquals(sampleUser, foundByUsername);
	}
	@Test
	public void happyPathScenario3() {
		User sampleUser = new User(1, "a", "b", "c", "d", "e");
		
		List<User> list = new ArrayList<User>();
		list.add(sampleUser);
		
		when(edaoImpl.findAll()).thenReturn(list);
		
		List <User> listOfUsers = eserv.getAllUsers();
		
		assertEquals(list, listOfUsers);
	}
	
	@Test
	public void happyPathScenario4() {
		User sampleUser = new User(1, "a", "b", "c", "d", "e");
		FavShows sampleShow = new FavShows(1, "BreakingBad", sampleUser);
		
	
		
		when(edaoImpl.saveShow(sampleShow)).thenReturn(true);
		
		boolean savedShow = eserv.addFavShow(sampleShow);
		
		assertTrue(savedShow);
	}
	
	
	
	
	
	

}
