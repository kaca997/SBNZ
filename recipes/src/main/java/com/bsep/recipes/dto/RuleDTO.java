package com.bsep.recipes.dto;

import com.bsep.recipes.model.RecipeComplexityType;
import com.bsep.recipes.model.UserKnowledgeType;

public class RuleDTO {
	private int salienceVal;
	private String ruleName;
	private int gradesCount;
	private int largerThenGrade;
	private UserKnowledgeType previousType;
	private UserKnowledgeType newType;
	private RecipeComplexityType recipeType;
	
	public RuleDTO() {
		super();
	}

	public RuleDTO(int salienceVal, String ruleName, int gradesCount, int largerThenGrade,
			UserKnowledgeType previousType, UserKnowledgeType newType, RecipeComplexityType recipeType) {
		super();
		this.salienceVal = salienceVal;
		this.ruleName = ruleName;
		this.gradesCount = gradesCount;
		this.largerThenGrade = largerThenGrade;
		this.previousType = previousType;
		this.newType = newType;
		this.recipeType = recipeType;
	}

	public int getGradesCount() {
		return gradesCount;
	}
	
	public void setGradesCount(int gradesCount) {
		this.gradesCount = gradesCount;
	}

	public int getLargerThenGrade() {
		return largerThenGrade;
	}

	public void setLargerThenGrade(int largerThenGrade) {
		this.largerThenGrade = largerThenGrade;
	}

	public UserKnowledgeType getPreviousType() {
		return previousType;
	}

	public void setPreviousType(UserKnowledgeType previousType) {
		this.previousType = previousType;
	}

	public UserKnowledgeType getNewType() {
		return newType;
	}

	public void setNewType(UserKnowledgeType newType) {
		this.newType = newType;
	}

	public RecipeComplexityType getRecipeType() {
		return recipeType;
	}

	public void setRecipeType(RecipeComplexityType recipeType) {
		this.recipeType = recipeType;
	}

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}
	

	public int getSalienceVal() {
		return salienceVal;
	}

	public void setSalienceVal(int salienceVal) {
		this.salienceVal = salienceVal;
	}

	@Override
	public String toString() {
		return "RuleDTO [salienceVal=" + salienceVal + ", ruleName=" + ruleName + ", gradesCount=" + gradesCount
				+ ", largerThenGrade=" + largerThenGrade + ", previousType=" + previousType + ", newType=" + newType
				+ ", recipeType=" + recipeType + "]";
	}

	
}
