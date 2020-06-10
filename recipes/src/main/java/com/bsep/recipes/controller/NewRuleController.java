package com.bsep.recipes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bsep.recipes.dto.RuleDTO;
import com.bsep.recipes.service.NewRuleService;

@RestController
public class NewRuleController {

	@Autowired
	private NewRuleService newRuleService;
	
	@RequestMapping(value = "/newRule", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<String> newRule(@RequestBody RuleDTO nr) {
        System.out.println(nr);

        try {
        	newRuleService.addNewRule(nr);
            return new ResponseEntity<>("New rule added successfully", HttpStatus.OK);
           }
        catch (Exception e) {
        	e.printStackTrace();
        	return new ResponseEntity<>("Error while adding new rule", HttpStatus.BAD_REQUEST);
        }
    }

}
