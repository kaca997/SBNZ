package com.bsep.recipes.dto;

import java.util.ArrayList;
import java.util.List;

public class GradeDTO {
	private List<StepDTO> steps;
	private int recipeID;
	
	public GradeDTO() {
		super();
		this.steps= new ArrayList<StepDTO>();
	}
	public List<StepDTO> getSteps() {
		return steps;
	}
	public void setSteps(List<StepDTO> steps) {
		this.steps = steps;
	}
	public int getRecipeID() {
		return recipeID;
	}
	public void setRecipeID(int recipeID) {
		this.recipeID = recipeID;
	}
	@Override
	public String toString() {
		return "GradeDTO [steps=" + steps + ", recipeID=" + recipeID + "]";
	}
	
}
