package com.bsep.recipes.dto;

import java.util.ArrayList;
import java.util.List;

import com.bsep.recipes.model.RecipeType;

public class SearchRecipeDTO {
	private List<String> ingredients;
	private int time;
	private double price;
	private List<RecipeType> types;
	private String name;
	public SearchRecipeDTO(List<String> ingredients, int time, double price) {
		super();
		this.ingredients = ingredients;
		this.time = time;
		this.price = price;
	}
	public SearchRecipeDTO() {
		super();
		this.ingredients = new ArrayList<String>();
		this.types = new ArrayList<RecipeType>();
	}
	public List<String> getIngredients() {
		return ingredients;
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
	public List<RecipeType> getTypes() {
		return types;
	}
	public void setTypes(List<RecipeType> types) {
		this.types = types;
	}
	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "SearchRecipeDTO [ingredients=" + ingredients + ", time=" + time + ", price=" + price + ", types="
				+ types + ", name=" + name + "]";
	}
}
