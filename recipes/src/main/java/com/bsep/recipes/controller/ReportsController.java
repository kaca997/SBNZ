package com.bsep.recipes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bsep.recipes.dto.RecipeReportsDTO;
import com.bsep.recipes.dto.UserReportsDTO;
import com.bsep.recipes.service.ReportsService;

@RestController
public class ReportsController {
	
	private final ReportsService reportsService;

	@Autowired
	public ReportsController(ReportsService reportsService) {
		this.reportsService = reportsService;
	}
	
	@RequestMapping(value = "/bestUsers", method = RequestMethod.GET, produces = "application/json")
	public UserReportsDTO bestUsers() {;
		UserReportsDTO users = reportsService.bestUsers();
		return users;
	}
	
	@RequestMapping(value = "/bestRecipes", method = RequestMethod.GET, produces = "application/json")
	public RecipeReportsDTO bestRecipes() {;
		RecipeReportsDTO recipes = reportsService.mostPopularRecipes();
		return recipes;
	}
	
	@RequestMapping(value = "/leastPopularRecipes", method = RequestMethod.GET, produces = "application/json")
	public RecipeReportsDTO leastPopularRecipes() {;
		RecipeReportsDTO recipes = reportsService.leastPopularRecipes();
		return recipes;
	}

}
