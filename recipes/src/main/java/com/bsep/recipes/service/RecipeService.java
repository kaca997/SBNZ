package com.bsep.recipes.service;
import java.util.ArrayList;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.bsep.recipes.dto.RecipeDTO;
import com.bsep.recipes.dto.RecipeResponseDTO;
import com.bsep.recipes.dto.SearchRecipeDTO;
import com.bsep.recipes.mapper.RecipeMapper;
import com.bsep.recipes.model.Recipe;
import com.bsep.recipes.model.RecipeComplexityType;
import com.bsep.recipes.model.RegisteredUser;
import com.bsep.recipes.model.UserKnowledgeType;
import com.bsep.recipes.repository.RecipeRepository;


@Service
public class RecipeService {
	
	private final KieContainer kieContainer;

	@Autowired
	public RecipeService(KieContainer kieContainer) {
		this.kieContainer = kieContainer;
	}
	
	@Autowired
	private RecipeRepository recipeRepo;
	
	public Recipe addRecipe(RecipeDTO dto) {
		//get the stateful session
		Recipe r = RecipeMapper.toRecipe(dto);
		System.out.println(dto);
		System.out.println(r);
		KieSession kieSession = kieContainer.newKieSession("rulesSession");
		System.out.println("Facts num: " + kieSession.getFactCount());
		kieSession.insert(dto);
		kieSession.insert(r);
		int fired = kieSession.fireAllRules();
		System.out.println("Rules: " + fired);
//		kieSession.fireAllRules();
		System.out.println("Facts num: " + kieSession.getFactCount());
		kieSession.dispose();
		System.out.println(dto.getName());
		Recipe rec = recipeRepo.save(r);
		return rec;
	}
	
	public RecipeResponseDTO findRecipes(SearchRecipeDTO dto) {
		ArrayList<Recipe> recipes = (ArrayList<Recipe>) recipeRepo.findAll();
		System.out.println(recipes);
		RecipeResponseDTO found = new RecipeResponseDTO();
//		Recipe r = new Recipe();
//		r.setName("recipe1");
//		r.setTime(15);
//		r.setPrice(14.5);
//		r.getIngredients().add("in 2");
//		r.getIngredients().add("in 3");
//		r.getIngredients().add("in 4");
//		r.setComplexity(RecipeComplexityType.EASY);
//		Recipe r2 = new Recipe();
//		r2.setName("recipe2");
//		r2.getIngredients().add("in 1");
//		r2.getIngredients().add("in 3");
//		r2.setPrice(14.5);
//		r2.setTime(15);
//		r2.setComplexity(RecipeComplexityType.EASY);
//		Recipe r3 = new Recipe();
//		r3.setName("recipe3");
//		r3.setTime(15);
//		r3.setPrice(14.5);
//		r3.getIngredients().add("in 2");
//		r3.getIngredients().add("in 3");
//		r3.setComplexity(RecipeComplexityType.MEDIUM);
//		Recipe r4 = new Recipe();
//		r4.setName("recipe4");
//		r4.getIngredients().add("in 2");
//		r4.getIngredients().add("in 3");
//		r4.setPrice(14.5);
//		r4.setTime(15);
//		r4.setComplexity(RecipeComplexityType.EASY);
//		ArrayList<Recipe> recipes = new ArrayList<Recipe>();
//		recipes.add(r);
//		recipes.add(r2);
//		recipes.add(r3);
//		recipes.add(r4);
//		RegisteredUser ru = new RegisteredUser();
//		ru.setKnowledge(UserKnowledgeType.BEGINER);
//		ru.getLikes().add("in 2");
//		ru.getHates().add("in 1");
//		ru.getHates().add("in 5");
//		
		
		RegisteredUser ru = (RegisteredUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println(ru);
		KieSession kieSession = kieContainer.newKieSession("rulesSession");
		kieSession.setGlobal("recipes", recipes);
		System.out.println("Facts num: " + kieSession.getFactCount());
		kieSession.insert(dto);
		kieSession.insert(ru);
		kieSession.insert(found);
		int fired = kieSession.fireAllRules();
		System.out.println("Rules: " + fired);
//		kieSession.fireAllRules();
		System.out.println("Facts num: " + kieSession.getFactCount());
		kieSession.dispose();
		return found;
	}
	
	public RecipeResponseDTO findRecipesByName(SearchRecipeDTO dto) {
		ArrayList<Recipe> recipes = (ArrayList<Recipe>) recipeRepo.findAll();
		System.out.println(recipes);
		RecipeResponseDTO found = new RecipeResponseDTO();
		KieSession kieSession = kieContainer.newKieSession("rulesSession");
		kieSession.setGlobal("recipes", recipes);
		System.out.println("Facts num: " + kieSession.getFactCount());
		kieSession.insert(dto);
		kieSession.insert(found);
		int fired = kieSession.fireAllRules();
		System.out.println("Rules: " + fired);
//		kieSession.fireAllRules();
		System.out.println("Facts num: " + kieSession.getFactCount());
		kieSession.dispose();
		return found;
	}
}
