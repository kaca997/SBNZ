package com.bsep.recipes.dto;

import java.util.ArrayList;
import java.util.List;

public class BestUserDTO {
	
	private String username;
	private String lastName;
	private String firstName;
	private List<BestUserGradeDTO> grades = new ArrayList<>();
	
	public BestUserDTO() {
		super();
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public List<BestUserGradeDTO> getGrades() {
		return grades;
	}
	public void setGrades(List<BestUserGradeDTO> grades) {
		this.grades = grades;
	}
}
