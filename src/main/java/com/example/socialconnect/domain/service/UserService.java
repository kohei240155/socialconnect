package com.example.socialconnect.domain.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.socialconnect.domain.model.user.User;
import com.example.socialconnect.domain.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Transactional
	public User registerUser(User user) {
		String rawpassword = user.getPassword();
		String encodedPassword = passwordEncoder.encode(rawpassword);
		user.setPassword(encodedPassword);
		logger.debug("User registered with email: {} and encoded password: {}", user.getEmail(), encodedPassword);
		return userRepository.save(user);
	}
	
}
