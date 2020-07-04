package com.bsep.recipes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;

import com.bsep.recipes.dto.StepResponseDTO;
import com.bsep.recipes.events.BadPreparationEvent;
import com.bsep.recipes.events.GoodPreparationEvent;
import com.bsep.recipes.events.StepEvent;

public class EventsTest {
	@Test
    public void test() throws IOException {
		KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        badPreparingTest(kContainer.newKieSession("eventsSession"));
        goodPreparingTest(kContainer.newKieSession("eventsSession"));
    }
	
	private void badPreparingTest(KieSession eventSession) {
		//failed from one user same recipe
		StepEvent event1 = new StepEvent(1, 1, "Step 1", false);
		
		StepResponseDTO response = new StepResponseDTO();
		eventSession.insert(event1);
		eventSession.setGlobal("response", response);
		int fired = eventSession.fireAllRules();
		assertEquals(0, fired);
		
		StepEvent event2 = new StepEvent(1, 1, "Step 2", true);
		StepEvent event3 = new StepEvent(1, 1, "Step 3", false);
		eventSession.insert(event2);
		eventSession.insert(event3);
		fired = eventSession.fireAllRules();
		assertEquals(0, fired);
		
		StepEvent event4 = new StepEvent(1, 1, "Step 4", false);
		eventSession.insert(event4);
		fired = eventSession.fireAllRules();
		assertEquals(2, fired);
		BadPreparationEvent event = new BadPreparationEvent();
		QueryResults results = eventSession.getQueryResults( "getBadPreparationEvent" ); 
		for ( QueryResultsRow row : results ) {
			event =  ( BadPreparationEvent ) row.get( "$result" ); //you can retrieve all the bounded variables here
		    //do whatever you want with classA
		}
		assertEquals(1, event.getRecipeID());
		assertEquals(1,event.getUserID());
		assertEquals("Is everything ok?", response.getMessage());
		
		StepEvent event5 = new StepEvent(1, 1, "Step 5", false);
		eventSession.insert(event5);
		fired = eventSession.fireAllRules();
		assertEquals(0, fired);	
	}
	
	
	private void goodPreparingTest(KieSession eventSession) {
		//failed from one user same recipe
		StepEvent event1 = new StepEvent(1, 1, "Step 1", true);
		StepEvent event2 = new StepEvent(1, 1, "Step 2", true);
		
		StepResponseDTO response = new StepResponseDTO();
		eventSession.insert(event1);
		eventSession.insert(event2);
		eventSession.setGlobal("response", response);
		int fired = eventSession.fireAllRules();
		assertEquals(0, fired);
		
		StepEvent event3 = new StepEvent(1, 1, "Step 3", false);
		StepEvent event4 = new StepEvent(1, 1, "Step 4", true);
		eventSession.insert(event3);
		eventSession.insert(event4);
		fired = eventSession.fireAllRules();
		assertEquals(0, fired);

		StepEvent event5 = new StepEvent(1, 1, "Step 5", true);
		StepEvent event6 = new StepEvent(1, 1, "Step 6", true);
		eventSession.insert(event5);
		eventSession.insert(event6);
		
		fired = eventSession.fireAllRules();
		assertEquals(2, fired);
		GoodPreparationEvent event = new GoodPreparationEvent();
		QueryResults results = eventSession.getQueryResults( "getGoodPreparationEvent" ); 
		for ( QueryResultsRow row : results ) {
			event =  ( GoodPreparationEvent ) row.get( "$result" ); //you can retrieve all the bounded variables here
		    //do whatever you want with classA
		}
		assertEquals(1, event.getRecipeID());
		assertEquals(1,event.getUserID());
		assertEquals("Nice job!", response.getMessage());
		
		StepEvent event7 = new StepEvent(1, 1, "Step 7", true);
		eventSession.insert(event7);
		
		fired = eventSession.fireAllRules();
		assertEquals(0, fired);	
	}
}
