package com.bsep.recipes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bsep.recipes.model.User;


public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsername(String username);
}
