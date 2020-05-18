package com.bsep.recipes.dto;

import java.util.ArrayList;
import java.util.List;

import com.bsep.recipes.model.RecipeType;

public class RecipeDTO {

	private String name;
	
	private RecipeType type;
		
	private Double price;
	
	private Integer time;
	
	private List<String> steps;

	public RecipeDTO() {
		super();
		steps = new ArrayList<String>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RecipeType getType() {
		return type;
	}

	public void setType(RecipeType type) {
		this.type = type;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public List<String> getSteps() {
		return steps;
	}

	public void setSteps(List<String> steps) {
		this.steps = steps;
	}
	
	
}
