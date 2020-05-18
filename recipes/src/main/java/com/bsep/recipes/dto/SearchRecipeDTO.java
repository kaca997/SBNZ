package com.bsep.recipes.dto;

import java.util.ArrayList;
import java.util.List;

public class SearchRecipeDTO {
	private List<String> ingredients;
	private int time;
	private double price;
	public SearchRecipeDTO(List<String> ingredients, int time, double price) {
		super();
		this.ingredients = ingredients;
		this.time = time;
		this.price = price;
	}
	public SearchRecipeDTO() {
		super();
		this.ingredients = new ArrayList<String>();
	}
	public List<String> getIngredients() {
		return ingredients;
	}
	public void setIingredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	} 
	
	
}
