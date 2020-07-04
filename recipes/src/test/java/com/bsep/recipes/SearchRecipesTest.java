package com.bsep.recipes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.bsep.recipes.dto.RecipeResponseDTO;
import com.bsep.recipes.dto.SearchRecipeDTO;
import com.bsep.recipes.model.Recipe;
import com.bsep.recipes.model.RecipeComplexityType;
import com.bsep.recipes.model.RecipeType;
import com.bsep.recipes.model.RegisteredUser;
import com.bsep.recipes.model.UserKnowledgeType;

public class SearchRecipesTest {
	@Test
    public void test() throws IOException {
		KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        searchRecipesEmptyTest(kContainer.newKieSession("rulesSession"));
        searchRecipesWithParams(kContainer.newKieSession("rulesSession"));
	}
	
	public void searchRecipesEmptyTest(KieSession kieSession) {
		ArrayList<Recipe> recipes = new ArrayList<>();
		Recipe r1 = new Recipe();
		r1.setComplexity(RecipeComplexityType.EASY);
		r1.setIngredients(new ArrayList<String>() {{
			add("ingredientLike1");
			add("ingerdientLike2");
			add("randomIngredient");
		}});
		
		Recipe r2 = new Recipe();
		r2.setComplexity(RecipeComplexityType.MEDIUM);
		r2.setIngredients(new ArrayList<String>() {{
			add("ingredientLike1");
		}});
		
		Recipe r3 = new Recipe();
		r3.setComplexity(RecipeComplexityType.MEDIUM);
		r3.setIngredients(new ArrayList<String>() {{
			add("ingredientHate1");
			add("ingerdientLike2");
		}});
		
		Recipe r4 = new Recipe();
		r4.setComplexity(RecipeComplexityType.HARD);
		r4.setIngredients(new ArrayList<String>() {{
			add("ingredientLike1");
			add("ingerdientLike2");
		}});
		
		recipes.add(r1);
		recipes.add(r2);
		recipes.add(r3);
		recipes.add(r4);
		
		RecipeResponseDTO found = new RecipeResponseDTO();

		SearchRecipeDTO dto = new SearchRecipeDTO();
		
		RegisteredUser ru = new RegisteredUser();
		ru.setKnowledge(UserKnowledgeType.INTERMEDIATE);
		ru.setLikes(new ArrayList<String>() {
			{
			add("ingredientLike1");
			add("ingredientLike2");
			}
		});
		
		ru.setHates(new ArrayList<String>() {
			{
			add("ingredientHate1");
			}
		});
		
		kieSession.setGlobal("recipes", recipes);
		kieSession.insert(dto);
		kieSession.insert(ru);
		kieSession.insert(found);
		int fired = kieSession.fireAllRules();
		
		//rule1 "Recipe can't contain any ingredient that user doesn't like"
		//rule2 "Recipes for intermediate users"
		//rule3 "Best recipe suggestion if all recipe's ingredients are those that user likes"
		
		
//		ovo pravilo(ispod) nije aktivirano jer se aktiviralo pravilo 3 
//		rule "Best recipe suggestion for recipes that contain the most ingredients that user likes"

		assertEquals(3, fired);
		
		assertEquals(1, found.getBestRecipes().size());
		assertEquals(r2, found.getBestRecipes().get(0));
		//nema r3 - zbog hate, nema r4 jer je hard recipe, a user je intermediate
		assertEquals(1,found.getRecipes().size());
		assertEquals(r1, found.getRecipes().get(0));
	}
	
	public void searchRecipesWithParams(KieSession kieSession) {
		ArrayList<Recipe> recipes = new ArrayList<>();
		
		//preveliko vreme
		Recipe r1 = new Recipe();
		r1.setComplexity(RecipeComplexityType.EASY);
		r1.setIngredients(new ArrayList<String>() {{
			add("ingredientLike1");
			add("ingerdientLike2");
			add("randomIngredient1");
		}});
		r1.setTime(200);
		r1.setPrice(10.50);
		r1.setType(RecipeType.DESSERT);
		
		//prevelika cena
		Recipe r2 = new Recipe();
		r2.setComplexity(RecipeComplexityType.EASY);
		r2.setIngredients(new ArrayList<String>() {{
			add("ingredientLike1");
			add("randomIngredient2");
		}});
		r1.setTime(10);
		r1.setPrice(500.0);
		r1.setType(RecipeType.SALAD);
		
		//neadekvatan tip jela
		Recipe r3 = new Recipe();
		r3.setComplexity(RecipeComplexityType.EASY);
		r3.setIngredients(new ArrayList<String>() {{
			add("randomIngredient1");
			add("randomIngredient2");
		}});
		r3.setTime(10);
		r3.setPrice(10.0);
		r3.setType(RecipeType.MAIN);
		
		//nije za beginera
		Recipe r4 = new Recipe();
		r4.setComplexity(RecipeComplexityType.HARD);
		r4.setIngredients(new ArrayList<String>() {{
			add("ingredientLike1");
			add("ingerdientLike2");
		}});
		
		//sve ok, nema ni jedan sastojak koji korisnik voli
		Recipe r5 = new Recipe();
		r5.setComplexity(RecipeComplexityType.EASY);
		r5.setIngredients(new ArrayList<String>() {{
			add("randomIngredient1");
			add("randomIngredient2");
		}});
		r5.setType(RecipeType.DESSERT);
		r5.setTime(10);
		r5.setPrice(20.0);
		
		//jedan sastojak koji korisnik voli, i jedan obican
		Recipe r6 = new Recipe();
		r6.setComplexity(RecipeComplexityType.EASY);
		r6.setIngredients(new ArrayList<String>() {{
			add("randomIngredient1");
			add("ingredientLike1");
		}});
		r6.setType(RecipeType.SIDE_DISH);
		r6.setTime(30);
		r6.setPrice(20.0);
		
		//korisnik nema potrebne sastojke za ovaj recept
		Recipe r7 = new Recipe();
		r7.setComplexity(RecipeComplexityType.EASY);
		r7.setIngredients(new ArrayList<String>() {{
			add("dontHaveIngredient1");
			add("ingredientLike1");
		}});
		r7.setType(RecipeType.SIDE_DISH);
		r7.setTime(30);
		r7.setPrice(20.0);
		
		recipes.add(r1);
		recipes.add(r2);
		recipes.add(r3);
		recipes.add(r4);
		recipes.add(r5);
		recipes.add(r6);
		recipes.add(r7);
		
		RecipeResponseDTO found = new RecipeResponseDTO();

		SearchRecipeDTO dto = new SearchRecipeDTO();
		dto.setIngredients(new ArrayList<String>() {{
			add("ingredientLike1");
			add("ingredientLike2");
			add("randomIngredient1");
			add("randomIngredient2");
		}});
		dto.setPrice(70.0);
		dto.setTime(60);
		dto.setTypes(new ArrayList<RecipeType>() {
			{
				add(RecipeType.DESSERT);
				add(RecipeType.SALAD);
				add(RecipeType.SIDE_DISH);
			}
		});
		
		RegisteredUser ru = new RegisteredUser();
		ru.setKnowledge(UserKnowledgeType.INTERMEDIATE);
		ru.setLikes(new ArrayList<String>() {
			{
			add("ingredientLike1");
			add("ingredientLike2");
			}
		});
		
		ru.setHates(new ArrayList<String>() {
			{
			add("ingredientHate1");
			}
		});
		
		kieSession.setGlobal("recipes", recipes);
		kieSession.insert(dto);
		kieSession.insert(ru);
		kieSession.insert(found);
		int fired = kieSession.fireAllRules();
		
		//sva pravila osim za intermediate user-a
		
		assertEquals(8, fired);
		
		assertEquals(1, found.getBestRecipes().size());
		assertEquals(r6, found.getBestRecipes().get(0));
		assertEquals(1, found.getRecipes().size());
		assertEquals(r5, found.getRecipes().get(0));
	}
}
