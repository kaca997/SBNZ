package com.bsep.recipes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bsep.recipes.dto.RecipeDTO;
import com.bsep.recipes.mapper.RecipeMapper;
import com.bsep.recipes.model.Recipe;
import com.bsep.recipes.model.RecipeComplexityType;

public class NewRecipeTest {
	
	@Test
    public void test() throws IOException {
		KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        easyRecipeTest(kContainer.newKieSession("rulesSession"));
        mediumRecipeTest(kContainer.newKieSession("rulesSession"));
        hardRecipeTest(kContainer.newKieSession("rulesSession"));
    }
	
	@Test
	private void easyRecipeTest(KieSession kieSession) {
		kieSession.getAgenda().getAgendaGroup("new-recipe").setFocus();
		RecipeDTO dto = new RecipeDTO();
//		dto.setImage("imgurl");
		dto.setIngredients(new ArrayList<String>());
//		dto.setName("Recipe 1");
//		dto.setTime(15);
//		dto.setType(RecipeType.DESSERT);
//		dto.setPrice(50.0);
		List<String>steps = new ArrayList<String>()
		{
			{
				add("Step1");
				add("Step2");
				add("Step3");
			}
		};
		dto.setSteps(steps);
		Recipe r = RecipeMapper.toRecipe(dto);
		kieSession.insert(dto);
		kieSession.insert(r);
		int fired = kieSession.fireAllRules();
		assertEquals(1, fired);
		assertEquals(RecipeComplexityType.EASY,r.getComplexity());
	}
	
	private void mediumRecipeTest(KieSession kieSession) {
		kieSession.getAgenda().getAgendaGroup("new-recipe").setFocus();
		RecipeDTO dto = new RecipeDTO();
//		dto.setImage("imgurl");
		dto.setIngredients(new ArrayList<String>());
//		dto.setName("Recipe 1");
//		dto.setTime(15);
//		dto.setType(RecipeType.DESSERT);
//		dto.setPrice(50.0);
		List<String>steps = new ArrayList<String>()
		{
			{
				add("Step1");
				add("Step2");
				add("Step3");
				add("Step4");
				add("Step5");
			}
		};
		dto.setSteps(steps);
		Recipe r = RecipeMapper.toRecipe(dto);
		kieSession.insert(dto);
		kieSession.insert(r);
		int fired = kieSession.fireAllRules();
		assertEquals(1, fired);
		assertEquals(RecipeComplexityType.MEDIUM,r.getComplexity());
	}
	
	private void hardRecipeTest(KieSession kieSession) {
		kieSession.getAgenda().getAgendaGroup("new-recipe").setFocus();
		RecipeDTO dto = new RecipeDTO();
//		dto.setImage("imgurl");
		dto.setIngredients(new ArrayList<String>());
//		dto.setName("Recipe 1");
//		dto.setTime(15);
//		dto.setType(RecipeType.DESSERT);
//		dto.setPrice(50.0);
		List<String>steps = new ArrayList<String>()
		{
			{
				add("Step1");
				add("Step2");
				add("Step3");
				add("Step4");
				add("Step5");
				add("Step6");
				add("Step7");
				add("Step8");
			}
		};
		dto.setSteps(steps);
		Recipe r = RecipeMapper.toRecipe(dto);
		kieSession.insert(dto);
		kieSession.insert(r);
		int fired = kieSession.fireAllRules();
		assertEquals(1, fired);
		assertEquals(RecipeComplexityType.HARD,r.getComplexity());
	}

}
