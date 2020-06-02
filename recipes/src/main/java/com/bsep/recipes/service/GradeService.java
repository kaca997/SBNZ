package com.bsep.recipes.service;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.bsep.recipes.dto.GradeDTO;
import com.bsep.recipes.model.Grade;
import com.bsep.recipes.model.Recipe;
import com.bsep.recipes.model.RegisteredUser;
import com.bsep.recipes.repository.RecipeRepository;

@Service
public class GradeService {
	
	private final KieContainer kieContainer;

	@Autowired
	public GradeService(KieContainer kieContainer) {
		this.kieContainer = kieContainer;
	}
	
	@Autowired
	private RecipeRepository recipeRepo;
	
	public Grade conutGrade(GradeDTO dto) {
//		RegisteredUser ru = new RegisteredUser();
//		ru.setId(3);
//		ru.setKnowledge(UserKnowledgeType.INTERMEDIATE);
//		Recipe r = new Recipe();
//		r.setComplexity(RecipeComplexityType.MEDIUM);
//		Recipe r1 = new Recipe();
//		r1.setComplexity(RecipeComplexityType.MEDIUM);
//		Recipe r2 = new Recipe();
//		r2.setComplexity(RecipeComplexityType.MEDIUM);
//		Recipe r3 = new Recipe();
//		r3.setComplexity(RecipeComplexityType.MEDIUM);
//		Grade g = new Grade();
//		g.setGrade(2);
//		g.setRecipe(r);
//		Grade g1 = new Grade();
//		g1.setGrade(4);
//		g1.setRecipe(r1);
//		Grade g2 = new Grade();
//		g2.setGrade(5);
//		g2.setRecipe(r2);
//		Grade newGrade = new Grade();
//		//g3.setGrade(4);
//		newGrade.setId(9);
//		newGrade.setRecipe(r3);
//		ru.getGrades().add(g);
//		ru.getGrades().add(g1);
//		ru.getGrades().add(g2);
//		//ru.getGrades().add(g3);
//		//Grade gr = new Grade();
//		Recipe gradeRecipe = new Recipe();
//		gradeRecipe.setId(9);
//		System.out.println(dto);
		Grade newGrade = new Grade();
		RegisteredUser ru = (RegisteredUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Recipe gradeRecipe = recipeRepo.findById(dto.getRecipeID()).get();
		KieSession kieSession = kieContainer.newKieSession("rulesSession");
		System.out.println("Facts num: " + kieSession.getFactCount());
		kieSession.insert(newGrade);
		kieSession.insert(ru);
		kieSession.insert(dto);
		kieSession.insert(gradeRecipe);
		int fired = kieSession.fireAllRules();
		System.out.println("Rules: " + fired);
		kieSession.fireAllRules();
		System.out.println("Facts num: " + kieSession.getFactCount());
		kieSession.dispose();
		return newGrade;
		}
}
