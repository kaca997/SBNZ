package com.bsep.recipes.dto;

import java.util.ArrayList;
import java.util.List;

import com.bsep.recipes.model.Recipe;

public class RecipeReportsDTO {
	private List<Recipe> recipes;
	boolean best;

	public RecipeReportsDTO() {
		super();
		this.recipes = new ArrayList<Recipe>();
	}

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

	public boolean isBest() {
		return best;
	}

	public void setBest(boolean best) {
		this.best = best;
	}
	
	
	
}
