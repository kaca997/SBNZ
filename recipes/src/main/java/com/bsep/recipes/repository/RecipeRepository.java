package com.bsep.recipes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bsep.recipes.model.Recipe;


public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
}