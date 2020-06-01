package com.bsep.recipes.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bsep.recipes.dto.RecipeReportsDTO;
import com.bsep.recipes.dto.UserReportsDTO;
import com.bsep.recipes.model.Grade;
import com.bsep.recipes.service.ReportsService;

@RestController
public class ReportsController {
	
	private final ReportsService reportsService;

	@Autowired
	public ReportsController(ReportsService reportsService) {
		this.reportsService = reportsService;
	}
	
	@RequestMapping(value = "/bestUsers", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> bestUsers() {
		try {
			UserReportsDTO users = reportsService.bestUsers();
			return new ResponseEntity<UserReportsDTO>(users, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/bestRecipes", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> bestRecipes() {
		try {
			RecipeReportsDTO recipes = reportsService.mostPopularRecipes();
			return new ResponseEntity<RecipeReportsDTO>(recipes, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/leastPopularRecipes", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> leastPopularRecipes() {
		try {
			RecipeReportsDTO recipes = reportsService.leastPopularRecipes();
			return new ResponseEntity<RecipeReportsDTO>(recipes, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

}
