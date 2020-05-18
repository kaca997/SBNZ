package com.bsep.recipes.service;

import java.util.ArrayList;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsep.recipes.dto.RecipeReportsDTO;
import com.bsep.recipes.dto.UserReportsDTO;
import com.bsep.recipes.model.Grade;
import com.bsep.recipes.model.Recipe;
import com.bsep.recipes.model.RecipeComplexityType;
import com.bsep.recipes.model.RegisteredUser;
import com.bsep.recipes.model.UserKnowledgeType;

@Service
public class ReportsService {
	
	private final KieContainer kieContainer;

	@Autowired
	public ReportsService(KieContainer kieContainer) {
		this.kieContainer = kieContainer;
	}
	
	public UserReportsDTO bestUsers() {
		//get the stateful session
		UserReportsDTO dto = new UserReportsDTO();
		ArrayList<RegisteredUser> allUsers = new ArrayList<>();
		RegisteredUser ru1 = new RegisteredUser();
		ru1.setKnowledge(UserKnowledgeType.ADVANCED);
		ru1.setUsername("najbolji");
		RegisteredUser ru2 = new RegisteredUser();
		ru2.setKnowledge(UserKnowledgeType.ADVANCED);
		ru2.setUsername("srednji");
		for (int i = 0; i<7; i++) {
			Grade g1 = new Grade();
			g1.setGrade(5);
			Recipe r1 = new Recipe();
			r1.setComplexity(RecipeComplexityType.HARD);
			g1.setRecipe(r1);
			g1.setUser(ru1);
			ru1.getGrades().add(g1);
			Grade g2 = new Grade();
			g2.setGrade(5);
			Recipe r2 = new Recipe();
			r2.setComplexity(RecipeComplexityType.MEDIUM);
			g2.setRecipe(r2);
			g2.setUser(ru2);
			ru2.getGrades().add(g2);
			
		}
		allUsers.add(ru1);
		allUsers.add(ru2);
		KieSession kieSession = kieContainer.newKieSession("rulesSession");
		kieSession.setGlobal("allUsers", allUsers);
		System.out.println("Facts num: " + kieSession.getFactCount());
		kieSession.insert(dto);
		int fired = kieSession.fireAllRules();
		System.out.println("Rules: " + fired);
//		kieSession.fireAllRules();
		System.out.println("Facts num: " + kieSession.getFactCount());
		kieSession.dispose();
		return dto;
	}
	
	public RecipeReportsDTO mostPopularRecipes() {
		//get the stateful session
		RecipeReportsDTO dto = new RecipeReportsDTO();
		dto.setBest(true);
		ArrayList<Recipe> allRecipes = new ArrayList<>();
		Recipe r1 = new Recipe();
		r1.setPrepared(10);
		Recipe r2 = new Recipe();
		r2.setPrepared(5);
		Recipe r3 = new Recipe();
		r3.setPrepared(10);
		Recipe r4 = new Recipe();
		r4.setPrepared(1);
		allRecipes.add(r1);
		allRecipes.add(r2);
		allRecipes.add(r3);
		allRecipes.add(r4);
		KieSession kieSession = kieContainer.newKieSession("rulesSession");
		kieSession.setGlobal("allRecipes", allRecipes);
		System.out.println("Facts num: " + kieSession.getFactCount());
		kieSession.insert(dto);
		int fired = kieSession.fireAllRules();
		System.out.println("Rules: " + fired);
//		kieSession.fireAllRules();
		System.out.println("Facts num: " + kieSession.getFactCount());
		kieSession.dispose();
		return dto;
	}
	
	public RecipeReportsDTO leastPopularRecipes() {
		//get the stateful session
		RecipeReportsDTO dto = new RecipeReportsDTO();
		dto.setBest(false);
		ArrayList<Recipe> allRecipes = new ArrayList<>();
		Recipe r1 = new Recipe();
		r1.setPrepared(10);
		Recipe r2 = new Recipe();
		r2.setPrepared(5);
		Recipe r3 = new Recipe();
		r3.setPrepared(10);
		Recipe r4 = new Recipe();
		r4.setPrepared(1);
		allRecipes.add(r1);
		allRecipes.add(r2);
		allRecipes.add(r3);
		allRecipes.add(r4);
		KieSession kieSession = kieContainer.newKieSession("rulesSession");
		kieSession.setGlobal("allRecipes", allRecipes);
		System.out.println("Facts num: " + kieSession.getFactCount());
		kieSession.insert(dto);
		int fired = kieSession.fireAllRules();
		System.out.println("Rules: " + fired);
//		kieSession.fireAllRules();
		System.out.println("Facts num: " + kieSession.getFactCount());
		kieSession.dispose();
		return dto;
	}

}
