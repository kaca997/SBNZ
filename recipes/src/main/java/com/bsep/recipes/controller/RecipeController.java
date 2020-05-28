package com.bsep.recipes.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bsep.recipes.dto.RecipeDTO;
import com.bsep.recipes.dto.RecipeResponseDTO;
import com.bsep.recipes.dto.SearchRecipeDTO;
import com.bsep.recipes.model.Recipe;
import com.bsep.recipes.service.RecipeService;

@RestController
public class RecipeController {

	private final RecipeService recipeService;

	@Autowired
	public RecipeController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}


	@RequestMapping(value = "/addRecipe", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> addRecipe(@RequestBody RecipeDTO dto) {
		System.out.println(dto);
//		RecipeDTO dto = new RecipeDTO();
//		dto.setTime(30);
//		ArrayList<String> steps = new ArrayList<String>();
//		steps.add("Step 1");
//		steps.add("Step 2");
//		steps.add("Step 3");
//		dto.setName("name");
		try {
			Recipe r = recipeService.addRecipe(dto);
			return new ResponseEntity<Recipe>(r, HttpStatus.OK);
		}
		catch (Exception e) {		
			return new ResponseEntity<String>("Error has accured!",HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/searchRecipe", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> searchRecipe(@RequestBody SearchRecipeDTO dto) {
//		SearchRecipeDTO dto = new SearchRecipeDTO();
//		dto.setTime(30);
//		dto.setPrice(45.50);
//		ArrayList<String> ingredients = new ArrayList<String>();
//		ingredients.add("in 1");
//		ingredients.add("in 2");
//		ingredients.add("in 3");
//		dto.setIingredients(ingredients);
		System.out.println(dto);
		try {
			RecipeResponseDTO found = recipeService.findRecipes(dto);
			return new ResponseEntity<RecipeResponseDTO>(found, HttpStatus.OK);
		}
		catch (Exception e) {	
			e.printStackTrace();
			return new ResponseEntity<String>("Error has accured!",HttpStatus.BAD_REQUEST);
		}
	}
}
