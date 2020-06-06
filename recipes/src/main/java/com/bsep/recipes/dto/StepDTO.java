package com.bsep.recipes.dto;

public class StepDTO {
	Integer recipeID;
	String step;
	Boolean success;
	public StepDTO() {
		super();
	}
	public String getStep() {
		return step;
	}
	public void setStep(String step) {
		this.step = step;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public Integer getRecipeID() {
		return recipeID;
	}
	public void setRecipeID(Integer recipeID) {
		this.recipeID = recipeID;
	}
	@Override
	public String toString() {
		return "StepDTO [recipeID=" + recipeID + ", step=" + step + ", success=" + success + "]";
	}
	
	
	
}
