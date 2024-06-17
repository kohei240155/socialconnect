package com.example.socialconnect.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.socialconnect.domain.model.user.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
