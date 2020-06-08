package com.bsep.recipes.dto;

import java.util.ArrayList;
import java.util.List;

import com.bsep.recipes.model.Recipe;

public class RecipeResponseDTO {
	private List<Recipe> recipes;
	private List<Recipe> bestRecipes;

	public RecipeResponseDTO() {
		super();
		this.recipes = new ArrayList<Recipe>();
		this.bestRecipes = new ArrayList<Recipe>();
	}

	public RecipeResponseDTO(List<Recipe> recipes) {
		super();
		this.recipes = recipes;
	}

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

	public List<Recipe> getBestRecipes() {
		return bestRecipes;
	}

	public void setBestRecipes(List<Recipe> bestRecipes) {
		this.bestRecipes = bestRecipes;
	}

	@Override
	public String toString() {
		return "RecipeResponseDTO [recipes=" + recipes + ", bestRecipes=" + bestRecipes + "]";
	}
	
	
	
}
