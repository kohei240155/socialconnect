package com.example.socialconnect.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.socialconnect.domain.model.user.User;
import com.example.socialconnect.domain.service.UserService;
import com.example.socialconnect.domain.valueobject.user.UserCreateRequest;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public User registerUser(@RequestBody UserCreateRequest userCreateRequest) {
		User user = new User();
		user.setUsername(userCreateRequest.getUsername());
		user.setEmail(userCreateRequest.getEmail());
		user.setPassword(userCreateRequest.getPassword());
		return userService.registerUser(user);
	}
}
