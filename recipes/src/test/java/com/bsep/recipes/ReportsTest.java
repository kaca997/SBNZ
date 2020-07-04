package com.bsep.recipes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.bsep.recipes.dto.RecipeReportsDTO;
import com.bsep.recipes.dto.UserReportsDTO;
import com.bsep.recipes.model.Grade;
import com.bsep.recipes.model.Recipe;
import com.bsep.recipes.model.RecipeComplexityType;
import com.bsep.recipes.model.RegisteredUser;
import com.bsep.recipes.model.UserKnowledgeType;

public class ReportsTest {

	@Test
    public void test() throws IOException {
		KieServices ks = KieServices.Factory.get();
	    KieContainer kContainer = ks.getKieClasspathContainer();
	    bestUsersTest(kContainer.newKieSession("rulesSession"));
	    mostPopularRecipesTest(kContainer.newKieSession("rulesSession"));
	    leastPopularRecipesTest(kContainer.newKieSession("rulesSession"));
	}
	
	private void bestUsersTest(KieSession kieSession) {
		RegisteredUser ru1 = new RegisteredUser();
		ru1.setKnowledge(UserKnowledgeType.ADVANCED);
		ru1.setUsername("najbolji");
		RegisteredUser ru2 = new RegisteredUser();
		ru2.setKnowledge(UserKnowledgeType.ADVANCED);
		ru2.setUsername("srednji");
		RegisteredUser ru3 = new RegisteredUser();
		ru3.setKnowledge(UserKnowledgeType.ADVANCED);
		ru3.setUsername("username");
		Grade g3 = new Grade();
		g3.setGrade(5);
		Recipe r3 = new Recipe();
		r3.setComplexity(RecipeComplexityType.HARD);
		r3.setName("r3");
		g3.setRecipe(r3);
		g3.setUser(ru3);
		ru3.getGrades().add(g3);
		for (int i = 0; i<7; i++) {
			Grade g1 = new Grade();
			g1.setGrade(5);
			Recipe r1 = new Recipe();
			r1.setComplexity(RecipeComplexityType.HARD);
			r1.setName("r1" + i);
			g1.setRecipe(r1);
			g1.setUser(ru1);
			ru1.getGrades().add(g1);
			Grade g2 = new Grade();
			g2.setGrade(5);
			Recipe r2 = new Recipe();
			r2.setComplexity(RecipeComplexityType.MEDIUM);
			r2.setName("r2" + i);
			g2.setRecipe(r2);
			g2.setUser(ru2);
			ru2.getGrades().add(g2);
			
		}
		ArrayList<RegisteredUser> allUsers = new ArrayList<>();
		allUsers.add(ru1);
		allUsers.add(ru2);
		allUsers.add(ru3);
		UserReportsDTO dto = new UserReportsDTO();
		ArrayList<RegisteredUser> foundUsers = new ArrayList<>();
		kieSession.getAgenda().getAgendaGroup("reports").setFocus();
		kieSession.setGlobal("allUsers", allUsers);
		kieSession.insert(dto);
		kieSession.insert(foundUsers);
		int fired = kieSession.fireAllRules();
		assertEquals(1, fired);
		assertEquals(1, foundUsers.size());
		assertEquals("najbolji", foundUsers.get(0).getUsername());
	}
	
	private void mostPopularRecipesTest(KieSession kieSession) {
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
		kieSession.getAgenda().getAgendaGroup("reports").setFocus();
		kieSession.setGlobal("allRecipes", allRecipes);
		System.out.println("Facts num: " + kieSession.getFactCount());
		kieSession.insert(dto);
		int fired = kieSession.fireAllRules();
		assertEquals(1,fired);
		assertEquals(2, dto.getRecipes().size());
		assertEquals(r1, dto.getRecipes().get(0));
		assertEquals(r3, dto.getRecipes().get(1));
	}
	
	private void leastPopularRecipesTest(KieSession kieSession) {
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
		kieSession.getAgenda().getAgendaGroup("reports").setFocus();
		kieSession.setGlobal("allRecipes", allRecipes);
		System.out.println("Facts num: " + kieSession.getFactCount());
		kieSession.insert(dto);
		int fired = kieSession.fireAllRules();
		assertEquals(1,fired);
		assertEquals(1, dto.getRecipes().size());
		assertEquals(r4, dto.getRecipes().get(0));
	}
}
