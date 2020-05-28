package com.bsep.recipes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bsep.recipes.model.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {

}
