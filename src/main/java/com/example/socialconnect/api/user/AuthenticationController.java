package com.example.socialconnect.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.socialconnect.domain.model.user.User;
import com.example.socialconnect.domain.service.AuthenticationService;
import com.example.socialconnect.domain.valueobject.user.UserLoginRequest;

@RestController
@RequestMapping("/api/users")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserLoginRequest userLoginRequest) {
		User user = authenticationService.authenticate(userLoginRequest.getEmail(), userLoginRequest.getPassword());
		if (user != null) {
			return ResponseEntity.ok(user);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
		}
	}
}
