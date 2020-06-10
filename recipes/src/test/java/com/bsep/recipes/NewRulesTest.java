package com.bsep.recipes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import org.drools.template.ObjectDataCompiler;
import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.kie.internal.utils.KieHelper;
import org.springframework.beans.factory.annotation.Autowired;

import com.bsep.recipes.dto.RuleDTO;
import com.bsep.recipes.model.Grade;
import com.bsep.recipes.model.Recipe;
import com.bsep.recipes.model.RecipeComplexityType;
import com.bsep.recipes.model.RegisteredUser;
import com.bsep.recipes.model.UserKnowledgeType;
import com.bsep.recipes.service.NewRuleService;

public class NewRulesTest {

	@Test
    public void test() throws IOException {
		testSimpleTemplateWithObjects();
    }
	
	private void testSimpleTemplateWithObjects() throws IOException {
		InputStream template = NewRuleService.class.getResourceAsStream("/rules/userTemplate.drt");
		//vise od 2 recepta
		RuleDTO nr = new RuleDTO(10, "name", 2,3, UserKnowledgeType.BEGINER, UserKnowledgeType.ADVANCED, RecipeComplexityType.EASY);
		nr.setRuleName("NN");
        List<RuleDTO> data = new ArrayList<>();
        data.add(nr);

        ObjectDataCompiler converter = new ObjectDataCompiler();
        String drl = converter.compile(data, template);
        System.out.println(drl);
//        int startIndex = drl.indexOf("rule \"");
//        drl = drl.substring(startIndex);
//        Files.write(Paths.get("src/main/resources/rules/userRules.drl"), drl.getBytes(), StandardOpenOption.APPEND);
        
        KieHelper kieHelper = new KieHelper();
        kieHelper.addContent(drl, ResourceType.DRL);;
        doTest(kieHelper.build().newKieSession());
	}
	
	private void doTest(KieSession kieSession) {
		Recipe r1 = new Recipe();
		r1.setComplexity(RecipeComplexityType.EASY);
		Grade g1 = new Grade();
		g1.setGrade(1);
		g1.setRecipe(r1);
		
		Recipe r2 = new Recipe();
		r2.setComplexity(RecipeComplexityType.EASY); 
		Grade g2 = new Grade();
		g2.setGrade(3);
		g2.setRecipe(r2);
		
		Recipe r3 = new Recipe();
		r3.setComplexity(RecipeComplexityType.EASY); 
		Grade g3 = new Grade();
		g3.setGrade(2);
		g3.setRecipe(r3);
		
		RegisteredUser ru = new RegisteredUser();
		ru.setKnowledge(UserKnowledgeType.BEGINER);
		ru.getGrades().add(g1);
		ru.getGrades().add(g2);
		ru.getGrades().add(g3);
		
		FactHandle fh = kieSession.insert(ru);
		
		kieSession.fireAllRules();
		kieSession.getFactCount();
		assertEquals(UserKnowledgeType.BEGINER, ru.getKnowledge());

		Recipe newRecipe = new Recipe();
		newRecipe.setComplexity(RecipeComplexityType.EASY);
		Grade newGrade = new Grade();
		newGrade.setGrade(3);
		newGrade.setRecipe(newRecipe);
		
		ru.getGrades().add(newGrade);
		kieSession.update(fh, ru);
		kieSession.fireAllRules();
		
		assertEquals(UserKnowledgeType.ADVANCED, ru.getKnowledge());
		
	}

}
