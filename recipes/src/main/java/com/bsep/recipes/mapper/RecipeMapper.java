package com.bsep.recipes.mapper;

import com.bsep.recipes.dto.RecipeDTO;
import com.bsep.recipes.model.Recipe;

public class RecipeMapper {
	
	public static Recipe toRecipe(RecipeDTO dto) {
		return new Recipe(dto.getName(), dto.getType(), dto.getPrice(), dto.getTime(), dto.getIngredients(), dto.getSteps(), dto.getImage());
	}

}
