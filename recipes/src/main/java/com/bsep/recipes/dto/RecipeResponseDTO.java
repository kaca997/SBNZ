package com.bsep.recipes.dto;

import java.util.ArrayList;
import java.util.List;

import com.bsep.recipes.model.Recipe;

public class RecipeResponseDTO {
	private List<Recipe> recipes;

	public RecipeResponseDTO() {
		super();
		this.recipes = new ArrayList<Recipe>();
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
	
	
}
