package com.bsep.recipes.dto;

public class BestUserGradeDTO {
	private String recipeName;
	private int grade;

	public BestUserGradeDTO(String recipeName, int grade) {
		super();
		this.recipeName = recipeName;
		this.grade = grade;
	}

	public BestUserGradeDTO() {
		super();
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
}
