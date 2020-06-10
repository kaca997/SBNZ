package com.bsep.recipes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bsep.recipes.dto.GradeDTO;
import com.bsep.recipes.dto.StepDTO;
import com.bsep.recipes.model.Grade;
import com.bsep.recipes.service.GradeService;

@RestController
public class GradeController {
	
	@Autowired
	GradeService gradeService;
	
	@RequestMapping(value = "/getGrade", method = RequestMethod.POST, produces = "application/json")
	public Grade conutGrade(@RequestBody GradeDTO dto) {
		System.out.println(dto);
//		GradeDTO dto = new GradeDTO();
//		StepDTO dt1 = new StepDTO();
//		dt1.setStep("S1");
//		dt1.setSuccess(true);
//		StepDTO dt2 = new StepDTO();
//		dt2.setStep("S2");
//		dt2.setSuccess(true);
//		StepDTO dt3 = new StepDTO();
//		dt3.setStep("S3");
//		dt3.setSuccess(false);
//		dto.getSteps().add(dt1);
//		dto.getSteps().add(dt2);
//		dto.getSteps().add(dt3);
//		dto.setRecipeID(9);
		Grade g = gradeService.conutGrade(dto);
		return g;
	}
}
