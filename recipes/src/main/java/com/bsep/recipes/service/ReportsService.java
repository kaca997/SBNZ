package com.bsep.recipes.service;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsep.recipes.dto.RecipeReportsDTO;
import com.bsep.recipes.dto.UserReportsDTO;
import com.bsep.recipes.mapper.BestUsersMapper;
import com.bsep.recipes.model.Grade;
import com.bsep.recipes.model.Recipe;
import com.bsep.recipes.model.RegisteredUser;
import com.bsep.recipes.repository.GradeRepository;
import com.bsep.recipes.repository.RecipeRepository;
import com.bsep.recipes.repository.RegisteredUserRepository;

@Service
public class ReportsService {
	
	private final KieContainer kieContainer;

	@Autowired
	public ReportsService(KieContainer kieContainer) {
		this.kieContainer = kieContainer;
	}
	
	@Autowired
	private RegisteredUserRepository regUserRepo;
	
	@Autowired
	private GradeRepository gradeRepo;
	
	@Autowired
	private RecipeRepository recipeRepo;
	
	public UserReportsDTO bestUsers() {
		//get the stateful session
		UserReportsDTO dto = new UserReportsDTO();
		ArrayList<RegisteredUser> allUsers = (ArrayList<RegisteredUser>) regUserRepo.findAll();
		for(RegisteredUser u : allUsers) {
			List<Grade> grades = gradeRepo.findAllByUserId(u.getId());
			System.out.println(grades.size());
			u.setGrades(grades);
		}		
		System.out.println(allUsers);
		ArrayList<RegisteredUser> foundUsers = new ArrayList<>();
//		RegisteredUser ru1 = new RegisteredUser();
//		ru1.setKnowledge(UserKnowledgeType.ADVANCED);
//		ru1.setUsername("najbolji");
//		RegisteredUser ru2 = new RegisteredUser();
//		ru2.setKnowledge(UserKnowledgeType.ADVANCED);
//		ru2.setUsername("srednji");
//		for (int i = 0; i<7; i++) {
//			Grade g1 = new Grade();
//			g1.setGrade(5);
//			Recipe r1 = new Recipe();
//			r1.setComplexity(RecipeComplexityType.HARD);
//			r1.setName("r1" + i);
//			g1.setRecipe(r1);
//			g1.setUser(ru1);
//			ru1.getGrades().add(g1);
//			Grade g2 = new Grade();
//			g2.setGrade(5);
//			Recipe r2 = new Recipe();
//			r2.setComplexity(RecipeComplexityType.MEDIUM);
//			r2.setName("r2" + i);
//			g2.setRecipe(r2);
//			g2.setUser(ru2);
//			ru2.getGrades().add(g2);
//			
//		}
//		System.out.println(ru1);
//		System.out.println(ru2);
//		allUsers.add(ru1);
//		allUsers.add(ru2);
		KieSession kieSession = kieContainer.newKieSession("rulesSession");
		kieSession.getAgenda().getAgendaGroup("reports").setFocus();
		kieSession.setGlobal("allUsers", allUsers);
		System.out.println("Facts num: " + kieSession.getFactCount());
		kieSession.insert(dto);
		kieSession.insert(foundUsers);
		int fired = kieSession.fireAllRules();
		System.out.println("Rules: " + fired);
//		kieSession.fireAllRules();
		System.out.println("Facts num: " + kieSession.getFactCount());
		kieSession.dispose();
		dto = BestUsersMapper.toRecipe(foundUsers);
		System.out.println(dto);
		System.out.println(foundUsers);
		return dto;
	}
	
	public RecipeReportsDTO mostPopularRecipes() {
		//get the stateful session
		RecipeReportsDTO dto = new RecipeReportsDTO();
		dto.setBest(true);
		ArrayList<Recipe> allRecipes = (ArrayList<Recipe>) recipeRepo.findAll();
//		Recipe r1 = new Recipe();
//		r1.setPrepared(10);
//		Recipe r2 = new Recipe();
//		r2.setPrepared(5);
//		Recipe r3 = new Recipe();
//		r3.setPrepared(10);
//		Recipe r4 = new Recipe();
//		r4.setPrepared(1);
//		allRecipes.add(r1);
//		allRecipes.add(r2);
//		allRecipes.add(r3);
//		allRecipes.add(r4);
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
		ArrayList<Recipe> allRecipes = (ArrayList<Recipe>) recipeRepo.findAll();
//		Recipe r1 = new Recipe();
//		r1.setPrepared(10);
//		Recipe r2 = new Recipe();
//		r2.setPrepared(5);
//		Recipe r3 = new Recipe();
//		r3.setPrepared(10);
//		Recipe r4 = new Recipe();
//		r4.setPrepared(1);
//		allRecipes.add(r1);
//		allRecipes.add(r2);
//		allRecipes.add(r3);
//		allRecipes.add(r4);
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
