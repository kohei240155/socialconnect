package com.example.socialconnect.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.socialconnect.domain.model.user.User;
import com.example.socialconnect.domain.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public User registerUser(User user) {
		return userRepository.save(user);
	}
	
}
