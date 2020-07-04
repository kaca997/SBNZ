package com.bsep.recipes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;

import com.bsep.recipes.dto.RecipeResponseDTO;
import com.bsep.recipes.model.Recipe;
import com.bsep.recipes.model.RecipeComplexityType;
import com.bsep.recipes.model.RegisteredUser;
import com.bsep.recipes.model.UserKnowledgeType;

public class SearchRecipesByNameTest {
	@Test
    public void test() throws IOException {
		KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        beginnerSearchTest(kContainer.newKieSession("rulesSession"));
        intermediateSearchTest(kContainer.newKieSession("rulesSession"));
        advancedSearchTest(kContainer.newKieSession("rulesSession"));
        adminSearchTest(kContainer.newKieSession("rulesSession"));
        
	}
	
	public void beginnerSearchTest(KieSession kieSession) {
		ArrayList<Recipe> recipes = new ArrayList<>();
		Recipe r1 = new Recipe();
		r1.setName("Karbonara");
		r1.setComplexity(RecipeComplexityType.EASY);
		
		Recipe r2 = new Recipe();
		r2.setComplexity(RecipeComplexityType.EASY);
		r2.setName("Bolonjeze");
		
		Recipe r3 = new Recipe();
		r3.setComplexity(RecipeComplexityType.MEDIUM);
		r3.setName("Pasulj");
		
		Recipe r4 = new Recipe();
		r4.setComplexity(RecipeComplexityType.HARD);
		r4.setName("Kapama");
		
		recipes.add(r1);
		recipes.add(r2);
		recipes.add(r3);
		recipes.add(r4);
		
		String name = "A";
		
		RegisteredUser ru = new RegisteredUser();
		ru.setKnowledge(UserKnowledgeType.BEGINER);
			
		kieSession.getAgenda().getAgendaGroup("search by name").setFocus();
		kieSession.setGlobal("recipes", recipes);
		kieSession.insert(name);
		kieSession.insert(ru);	
		int fired = kieSession.fireAllRules();
		assertEquals(2, fired);
		
		RecipeResponseDTO found = new RecipeResponseDTO();
		QueryResults results = kieSession.getQueryResults( "getRecipeResponseName" ); 
		for ( QueryResultsRow row : results ) {
		    found =  ( RecipeResponseDTO ) row.get( "$result" ); //you can retrieve all the bounded variables here
		    //do whatever you want with classA
		}
		
		assertEquals(1, found.getRecipes().size());
		assertEquals(2, found.getNotForPreparation().size());
		assertEquals(r1, found.getRecipes().get(0));
		
		kieSession.dispose();
	}
	
	public void intermediateSearchTest(KieSession kieSession) {
		ArrayList<Recipe> recipes = new ArrayList<>();
		Recipe r1 = new Recipe();
		r1.setName("Karbonara");
		r1.setComplexity(RecipeComplexityType.EASY);
		
		Recipe r2 = new Recipe();
		r2.setComplexity(RecipeComplexityType.EASY);
		r2.setName("Bolonjeze");
		
		Recipe r3 = new Recipe();
		r3.setComplexity(RecipeComplexityType.MEDIUM);
		r3.setName("Pasulj");
		
		Recipe r4 = new Recipe();
		r4.setComplexity(RecipeComplexityType.HARD);
		r4.setName("Kapama");
		
		recipes.add(r1);
		recipes.add(r2);
		recipes.add(r3);
		recipes.add(r4);
		
		String name = "A";
		
		RegisteredUser ru = new RegisteredUser();
		ru.setKnowledge(UserKnowledgeType.INTERMEDIATE);
			
		kieSession.getAgenda().getAgendaGroup("search by name").setFocus();
		kieSession.setGlobal("recipes", recipes);
		kieSession.insert(name);
		kieSession.insert(ru);	
		int fired = kieSession.fireAllRules();
		assertEquals(2, fired);
		
		RecipeResponseDTO found = new RecipeResponseDTO();
		QueryResults results = kieSession.getQueryResults( "getRecipeResponseName" ); 
		for ( QueryResultsRow row : results ) {
		    found =  ( RecipeResponseDTO ) row.get( "$result" ); //you can retrieve all the bounded variables here
		    //do whatever you want with classA
		}
		
		assertEquals(2, found.getRecipes().size());
		assertEquals(1, found.getNotForPreparation().size());
		assertEquals(r1, found.getRecipes().get(0));
		assertEquals(r3, found.getRecipes().get(1));
		
		kieSession.dispose();
	}
	
	public void advancedSearchTest(KieSession kieSession) {
		ArrayList<Recipe> recipes = new ArrayList<>();
		Recipe r1 = new Recipe();
		r1.setName("Karbonara");
		r1.setComplexity(RecipeComplexityType.EASY);
		
		Recipe r2 = new Recipe();
		r2.setComplexity(RecipeComplexityType.EASY);
		r2.setName("Bolonjeze");
		
		Recipe r3 = new Recipe();
		r3.setComplexity(RecipeComplexityType.MEDIUM);
		r3.setName("Pasulj");
		
		Recipe r4 = new Recipe();
		r4.setComplexity(RecipeComplexityType.HARD);
		r4.setName("Kapama");
		
		recipes.add(r1);
		recipes.add(r2);
		recipes.add(r3);
		recipes.add(r4);
		
		String name = "A";
		
		RegisteredUser ru = new RegisteredUser();
		ru.setKnowledge(UserKnowledgeType.ADVANCED);
			
		kieSession.getAgenda().getAgendaGroup("search by name").setFocus();
		kieSession.setGlobal("recipes", recipes);
		kieSession.insert(name);
		kieSession.insert(ru);	
		int fired = kieSession.fireAllRules();
		assertEquals(1, fired);
		
		RecipeResponseDTO found = new RecipeResponseDTO();
		QueryResults results = kieSession.getQueryResults( "getRecipeResponseName" ); 
		for ( QueryResultsRow row : results ) {
		    found =  ( RecipeResponseDTO ) row.get( "$result" ); //you can retrieve all the bounded variables here
		    //do whatever you want with classA
		}
		
		assertEquals(3, found.getRecipes().size());
		assertEquals(0, found.getNotForPreparation().size());
		assertFalse(found.getRecipes().contains(r2));
		
		kieSession.dispose();
	}
	
	public void adminSearchTest(KieSession kieSession) {
		ArrayList<Recipe> recipes = new ArrayList<>();
		Recipe r1 = new Recipe();
		r1.setName("Karbonara");
		r1.setComplexity(RecipeComplexityType.EASY);
		
		Recipe r2 = new Recipe();
		r2.setComplexity(RecipeComplexityType.EASY);
		r2.setName("Bolonjeze");
		
		Recipe r3 = new Recipe();
		r3.setComplexity(RecipeComplexityType.MEDIUM);
		r3.setName("Pasulj");
		
		Recipe r4 = new Recipe();
		r4.setComplexity(RecipeComplexityType.HARD);
		r4.setName("Kapama");
		
		recipes.add(r1);
		recipes.add(r2);
		recipes.add(r3);
		recipes.add(r4);
		
		String name = "A";
			
		kieSession.getAgenda().getAgendaGroup("search by name").setFocus();
		kieSession.setGlobal("recipes", recipes);
		kieSession.insert(name);
		int fired = kieSession.fireAllRules();
		assertEquals(1, fired);
		
		RecipeResponseDTO found = new RecipeResponseDTO();
		QueryResults results = kieSession.getQueryResults( "getRecipeResponseName" ); 
		for ( QueryResultsRow row : results ) {
		    found =  ( RecipeResponseDTO ) row.get( "$result" ); //you can retrieve all the bounded variables here
		    //do whatever you want with classA
		}
		
		assertEquals(3, found.getRecipes().size());
		assertEquals(0, found.getNotForPreparation().size());
		assertFalse(found.getRecipes().contains(r2));
		
		kieSession.dispose();
	}

}
