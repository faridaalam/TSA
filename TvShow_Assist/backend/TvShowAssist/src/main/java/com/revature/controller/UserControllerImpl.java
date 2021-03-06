package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.revature.util.ClientMessageUtil.*;

import com.revature.ajax.ClientMessage;
import com.revature.model.FavShows;
import com.revature.model.LoginTemplate;
import com.revature.model.User;
import com.revature.service.UserService;

@Controller("userController")
@CrossOrigin(origins = "http://localhost:4200")
public class UserControllerImpl implements UserController{

	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public @ResponseBody ClientMessage registerUser(@RequestBody User user) {
		return (userService.registerUser(user)) ? REGISTRATION_SUCCESSFUL : SOMETHING_WRONG;
	}
	
	@PostMapping("/favshow")
	public @ResponseBody ClientMessage addFavShow(@RequestBody FavShows favshow ) {
		System.out.println(favshow);
		return (userService.addFavShow(favshow)) ? UPDATE_SUCCESSFUL : UPDATE_FAIL;
	}
	
	@PostMapping("/returnfavshow")
	public @ResponseBody ClientMessage getAllShows(@RequestBody FavShows favshow ) {
		System.out.println(favshow);
		System.out.println(favshow.getUserHolder());
		System.out.println(favshow.getUserHolder());
		return (userService.getAllShows(favshow)) != null ? UPDATE_SUCCESSFUL : UPDATE_FAIL;
	}
	
	@PostMapping("/update")
	public @ResponseBody ClientMessage updateUser(@RequestBody User user) {
		return (userService.updateUser(user)) ? UPDATE_SUCCESSFUL : UPDATE_FAIL;
	}

//	@PostMapping("/findUser")
//	public @ResponseBody User findUser(@RequestBody User user, HttpServletRequest request) {
//		request.getSession();
//		return userService.getUser(user.getId());
//	}

	@GetMapping("/findAllUsers")
	public @ResponseBody List<User> findAllUsers() {
		return userService.getAllUsers();
	}
	
	@PostMapping("/login")
	public @ResponseBody User login(@RequestBody LoginTemplate loginTemplate) {
		try {
		System.out.println("test");
		
		return userService.login(loginTemplate);
		} catch(Exception e) {
			return null;
		}
	}
	

}
