package com.bsep.recipes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.bsep.recipes.dto.GradeDTO;
import com.bsep.recipes.dto.StepDTO;
import com.bsep.recipes.model.Grade;
import com.bsep.recipes.model.Recipe;
import com.bsep.recipes.model.RecipeComplexityType;
import com.bsep.recipes.model.RegisteredUser;
import com.bsep.recipes.model.UserKnowledgeType;

public class GradeTest {

	
	@Test
    public void test() throws IOException {
		KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        newGradeWithUserUpgrade(kContainer.newKieSession("rulesSession"));
        newGradeWithoutUserUpgrade(kContainer.newKieSession("rulesSession"));
        higherGradeWithUserUpgrade(kContainer.newKieSession("rulesSession"));
        higherGradeWithoutUserUpgrade(kContainer.newKieSession("rulesSession"));
        lowerGrade(kContainer.newKieSession("rulesSession"));
        
    }
	
	//new grade for not prepared recipe that calls upgrade user rule
	private void newGradeWithUserUpgrade(KieSession kieSession) {
		RegisteredUser ru = new RegisteredUser();
		ru.setId(3);
		ru.setKnowledge(UserKnowledgeType.INTERMEDIATE);
		
		Recipe r = new Recipe();
		r.setId(0);
		r.setComplexity(RecipeComplexityType.MEDIUM);
		Grade g = new Grade();
		g.setGrade(2);
		g.setRecipe(r);
		
		Recipe r1 = new Recipe();
		r1.setId(1);
		r1.setComplexity(RecipeComplexityType.MEDIUM);
		Grade g1 = new Grade();
		g1.setGrade(4);
		g1.setRecipe(r1);
		
		Recipe r2 = new Recipe();
		r.setId(2);
		r2.setComplexity(RecipeComplexityType.MEDIUM);
		Grade g2 = new Grade();
		g2.setGrade(5);
		g2.setRecipe(r2);
		
		
		ru.getGrades().add(g);
		ru.getGrades().add(g1);
		ru.getGrades().add(g2);
		Recipe gradeRecipe = new Recipe();
		gradeRecipe.setId(3);
		gradeRecipe.setComplexity(RecipeComplexityType.MEDIUM);
		gradeRecipe.setPrepared(0);
		
		Grade newGrade = new Grade();
		
		//66.6% = 4 -> 3.medium recept ocena>=4 -> upgrade user-a na advanced
		GradeDTO dto = new GradeDTO();
		StepDTO dt1 = new StepDTO();
		dt1.setStep("S1");
		dt1.setSuccess(true);
		StepDTO dt2 = new StepDTO();
		dt2.setStep("S2");
		dt2.setSuccess(true);
		StepDTO dt3 = new StepDTO();
		dt3.setStep("S3");
		dt3.setSuccess(false);
		dto.getSteps().add(dt1);
		dto.getSteps().add(dt2);
		dto.getSteps().add(dt3);
		dto.setRecipeID(3);

		kieSession.getAgenda().getAgendaGroup("grade").setFocus();
		//System.out.println("Facts num: " + kieSession.getFactCount());
		kieSession.insert(newGrade);
		kieSession.insert(ru);
		kieSession.insert(dto);
		kieSession.insert(gradeRecipe);
		int fired = kieSession.fireAllRules();
		
		assertEquals(2, fired);
		assertEquals(4,newGrade.getGrade());
		assertEquals(1,gradeRecipe.getPrepared());
		assertEquals(gradeRecipe,newGrade.getRecipe());
		assertEquals(4, ru.getGrades().size());
		assertEquals(newGrade ,ru.getGrades().get(3));
		
		assertEquals(UserKnowledgeType.ADVANCED,ru.getKnowledge());
		kieSession.dispose();
	}
	
	//new grade for not prepared recipe that without user upgrade
	private void newGradeWithoutUserUpgrade(KieSession kieSession) {
		RegisteredUser ru = new RegisteredUser();
		ru.setId(3);
		ru.setKnowledge(UserKnowledgeType.INTERMEDIATE);
		
		Recipe r = new Recipe();
		r.setId(0);
		r.setComplexity(RecipeComplexityType.MEDIUM);
		Grade g = new Grade();
		g.setGrade(2);
		g.setRecipe(r);
		
		Recipe r1 = new Recipe();
		r1.setId(1);
		r1.setComplexity(RecipeComplexityType.MEDIUM);
		Grade g1 = new Grade();
		g1.setGrade(4);
		g1.setRecipe(r1);
		
		Recipe r2 = new Recipe();
		r.setId(2);
		r2.setComplexity(RecipeComplexityType.MEDIUM);
		Grade g2 = new Grade();
		g2.setGrade(5);
		g2.setRecipe(r2);

		ru.getGrades().add(g);
		ru.getGrades().add(g1);
		ru.getGrades().add(g2);
		
		Recipe gradeRecipe = new Recipe();
		gradeRecipe.setId(3);
		gradeRecipe.setComplexity(RecipeComplexityType.MEDIUM);
		gradeRecipe.setPrepared(0);
		
		Grade newGrade = new Grade();
		//33% = 2 -> nema upgrade usera
		GradeDTO dto = new GradeDTO();
		StepDTO dt1 = new StepDTO();
		dt1.setStep("S1");
		dt1.setSuccess(false);
		StepDTO dt2 = new StepDTO();
		dt2.setStep("S2");
		dt2.setSuccess(true);
		StepDTO dt3 = new StepDTO();
		dt3.setStep("S3");
		dt3.setSuccess(false);
		dto.getSteps().add(dt1);
		dto.getSteps().add(dt2);
		dto.getSteps().add(dt3);
		dto.setRecipeID(3);

		kieSession.getAgenda().getAgendaGroup("grade").setFocus();
		//System.out.println("Facts num: " + kieSession.getFactCount());
		kieSession.insert(newGrade);
		kieSession.insert(ru);
		kieSession.insert(dto);
		kieSession.insert(gradeRecipe);
		int fired = kieSession.fireAllRules();
		
		assertEquals(1, fired);
		assertEquals(2,newGrade.getGrade());
		assertEquals(1,gradeRecipe.getPrepared());
		assertEquals(gradeRecipe,newGrade.getRecipe());
		assertEquals(4, ru.getGrades().size());
		assertEquals(newGrade ,ru.getGrades().get(3));
		
		assertEquals(UserKnowledgeType.INTERMEDIATE,ru.getKnowledge());
		kieSession.dispose();
	}
	
	//korisnik vec pripremao recept ali s nizom ocenom i ovo je 3.recept sa ocenom>=4
	private void higherGradeWithUserUpgrade(KieSession kieSession) {
		RegisteredUser ru = new RegisteredUser();
		ru.setId(3);
		ru.setKnowledge(UserKnowledgeType.BEGINER);
		
		Recipe r = new Recipe();
		r.setId(0);
		r.setPrepared(10);
		r.setComplexity(RecipeComplexityType.EASY);
		Grade g = new Grade();
		g.setGrade(4);
		g.setRecipe(r);
		
		Recipe r1 = new Recipe();
		r1.setId(1);
		r1.setComplexity(RecipeComplexityType.EASY);
		Grade g1 = new Grade();
		g1.setGrade(2);
		g1.setRecipe(r1);
		
		Recipe r2 = new Recipe();
		r.setId(2);
		r2.setComplexity(RecipeComplexityType.EASY);
		Grade g2 = new Grade();
		g2.setGrade(5);
		g2.setRecipe(r2);

		ru.getGrades().add(g);
		ru.getGrades().add(g1);
		ru.getGrades().add(g2);
		
		Recipe gradeRecipe = new Recipe();
		gradeRecipe.setId(1);
		gradeRecipe.setComplexity(RecipeComplexityType.EASY);
		gradeRecipe.setPrepared(10);
		
		Grade newGrade = new Grade();
		//66% = 4 -> prethodna ocena 2 -> nova ocena se postavlja na 4
		GradeDTO dto = new GradeDTO();
		StepDTO dt1 = new StepDTO();
		dt1.setStep("S1");
		dt1.setSuccess(true);
		StepDTO dt2 = new StepDTO();
		dt2.setStep("S2");
		dt2.setSuccess(true);
		StepDTO dt3 = new StepDTO();
		dt3.setStep("S3");
		dt3.setSuccess(true);
		dto.getSteps().add(dt1);
		dto.getSteps().add(dt2);
		dto.getSteps().add(dt3);
		dto.setRecipeID(1);

		kieSession.getAgenda().getAgendaGroup("grade").setFocus();
		System.out.println("Facts num: " + kieSession.getFactCount());
		kieSession.insert(newGrade);
		kieSession.insert(dto);
		kieSession.insert(gradeRecipe);
		kieSession.insert(ru);
		int fired = kieSession.fireAllRules();
		System.out.println("Facts num: " + kieSession.getFactCount());
		assertEquals(2, fired);
		assertEquals(5,newGrade.getGrade());
		assertEquals(11,gradeRecipe.getPrepared());
		assertEquals(5, ru.getGrades().get(1).getGrade());
		assertEquals(3, ru.getGrades().size());
		
		assertEquals(UserKnowledgeType.INTERMEDIATE,ru.getKnowledge());
		kieSession.dispose();
	}
	
	//korisnik vec pripremao recept ali s nizom ocenom
	private void higherGradeWithoutUserUpgrade(KieSession kieSession) {
		RegisteredUser ru = new RegisteredUser();
		ru.setId(3);
		ru.setKnowledge(UserKnowledgeType.BEGINER);
		
		Recipe r = new Recipe();
		r.setId(0);
		r.setPrepared(10);
		r.setComplexity(RecipeComplexityType.EASY);
		Grade g = new Grade();
		g.setGrade(2);
		g.setRecipe(r);
		
		Recipe r1 = new Recipe();
		r1.setId(1);
		r1.setComplexity(RecipeComplexityType.EASY);
		Grade g1 = new Grade();
		g1.setGrade(3);
		g1.setRecipe(r1);
		
		Recipe r2 = new Recipe();
		r.setId(2);
		r2.setComplexity(RecipeComplexityType.EASY);
		Grade g2 = new Grade();
		g2.setGrade(5);
		g2.setRecipe(r2);

		ru.getGrades().add(g);
		ru.getGrades().add(g1);
		ru.getGrades().add(g2);
		
		Recipe gradeRecipe = new Recipe();
		gradeRecipe.setId(1);
		gradeRecipe.setComplexity(RecipeComplexityType.EASY);
		gradeRecipe.setPrepared(10);
		
		Grade newGrade = new Grade();
		//66% = 4 -> prethodna ocena 2 -> nova ocena se postavlja na 4
		GradeDTO dto = new GradeDTO();
		StepDTO dt1 = new StepDTO();
		dt1.setStep("S1");
		dt1.setSuccess(false);
		StepDTO dt2 = new StepDTO();
		dt2.setStep("S2");
		dt2.setSuccess(true);
		StepDTO dt3 = new StepDTO();
		dt3.setStep("S3");
		dt3.setSuccess(true);
		dto.getSteps().add(dt1);
		dto.getSteps().add(dt2);
		dto.getSteps().add(dt3);
		dto.setRecipeID(1);

		kieSession.getAgenda().getAgendaGroup("grade").setFocus();
		System.out.println("Facts num: " + kieSession.getFactCount());
		kieSession.insert(newGrade);
		kieSession.insert(dto);
		kieSession.insert(gradeRecipe);
		kieSession.insert(ru);
		int fired = kieSession.fireAllRules();
		System.out.println("Facts num: " + kieSession.getFactCount());
		assertEquals(1, fired);
		assertEquals(4,newGrade.getGrade());
		assertEquals(11,gradeRecipe.getPrepared());
		assertEquals(4, ru.getGrades().get(1).getGrade());
		assertEquals(3, ru.getGrades().size());
		
		assertEquals(UserKnowledgeType.BEGINER,ru.getKnowledge());
		kieSession.dispose();
	}
	
	//korisnik vec pripremao recept sa visom ili jednakom ocenom
		private void lowerGrade(KieSession kieSession) {
			RegisteredUser ru = new RegisteredUser();
			ru.setId(3);
			ru.setKnowledge(UserKnowledgeType.BEGINER);
			
			Recipe r = new Recipe();
			r.setId(0);
			r.setPrepared(10);
			r.setComplexity(RecipeComplexityType.EASY);
			Grade g = new Grade();
			g.setGrade(2);
			g.setRecipe(r);
			
			Recipe r1 = new Recipe();
			r1.setId(1);
			r1.setComplexity(RecipeComplexityType.EASY);
			Grade g1 = new Grade();
			g1.setGrade(4);
			g1.setRecipe(r1);
			
			Recipe r2 = new Recipe();
			r.setId(2);
			r2.setComplexity(RecipeComplexityType.EASY);
			Grade g2 = new Grade();
			g2.setGrade(5);
			g2.setRecipe(r2);

			ru.getGrades().add(g);
			ru.getGrades().add(g1);
			ru.getGrades().add(g2);
			
			Recipe gradeRecipe = new Recipe();
			gradeRecipe.setId(1);
			gradeRecipe.setComplexity(RecipeComplexityType.EASY);
			gradeRecipe.setPrepared(10);
			
			Grade newGrade = new Grade();
			//33% = 2 -> prethodna ocena 4 ->ne menja se ocena
			GradeDTO dto = new GradeDTO();
			StepDTO dt1 = new StepDTO();
			dt1.setStep("S1");
			dt1.setSuccess(false);
			StepDTO dt2 = new StepDTO();
			dt2.setStep("S2");
			dt2.setSuccess(false);
			StepDTO dt3 = new StepDTO();
			dt3.setStep("S3");
			dt3.setSuccess(true);
			dto.getSteps().add(dt1);
			dto.getSteps().add(dt2);
			dto.getSteps().add(dt3);
			dto.setRecipeID(1);

			kieSession.getAgenda().getAgendaGroup("grade").setFocus();
			System.out.println("Facts num: " + kieSession.getFactCount());
			kieSession.insert(newGrade);
			kieSession.insert(dto);
			kieSession.insert(gradeRecipe);
			kieSession.insert(ru);
			int fired = kieSession.fireAllRules();
			System.out.println("Facts num: " + kieSession.getFactCount());
			assertEquals(1, fired);
			assertEquals(2,newGrade.getGrade());
			assertEquals(11,gradeRecipe.getPrepared());
			assertEquals(4, ru.getGrades().get(1).getGrade());
			assertEquals(3, ru.getGrades().size());
			
			assertEquals(UserKnowledgeType.BEGINER,ru.getKnowledge());
			kieSession.dispose();
		}
}
