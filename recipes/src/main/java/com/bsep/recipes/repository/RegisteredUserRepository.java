package com.bsep.recipes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bsep.recipes.model.RegisteredUser;

public interface RegisteredUserRepository extends JpaRepository<RegisteredUser, Integer> {

}
