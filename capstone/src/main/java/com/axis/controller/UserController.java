package com.axis.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.model.User;
import com.axis.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public User registerUser(@RequestBody User user) {
		return userService.createUser(user);
	}

	@GetMapping("/getUser/{userId}")
	public User getUser(@PathVariable Long userId) {
		return userService.getUserById(userId);
	}

	@PutMapping("/updateUser/{userId}")
	public User updateUser(@PathVariable Long userId, @RequestBody User user) {
		user.setUserId(userId);
		return userService.updateUser(user);
	}

	@DeleteMapping("/deleteUser/{userId}")
	public void deleteUser(@PathVariable Long userId) {
		userService.deleteUser(userId);
	}

	@PostMapping("/login")
	public User loginUser(@RequestBody Map<String, String> requestBody) {
		String userName = requestBody.get("userName");
	    String password = requestBody.get("password");
		return userService.login(userName, password);
	}
}
