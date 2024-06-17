package com.example.socialconnect.domain.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.socialconnect.domain.model.user.User;
import com.example.socialconnect.domain.repository.UserRepository;

@Service
public class AuthenticationService {
	private static final Logger logger = LoggerFactory.getLogger(AuthenticationService.class);
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User authenticate(String email, String password) {
		logger.debug("Attempting to authenticat user with email: {}", email);
		Optional<User> userOptional = userRepository.findByEmail(email);
		if (userOptional.isPresent()) {
			User user = userOptional.get();
			logger.debug("User found: {}", user.getUsername());
			if (passwordEncoder.matches(password, user.getPassword())) {
				logger.debug("Password match for user: {}", user.getUsername());
				return user;
			} else {
				logger.debug("Password mismatch for user: {}", user.getUsername());
			}
		} else {
			logger.debug("No user found with email: {}", email);
		}
		return null;
	}
	
}
