package com.bsep.recipes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bsep.recipes.model.Grade;

public interface GradeRepository  extends JpaRepository<Grade, Integer> {
	List<Grade> findAllByUserId(Integer user_id);
}
