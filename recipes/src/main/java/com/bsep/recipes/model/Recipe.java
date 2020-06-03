package com.bsep.recipes.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "recipe")
public class Recipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column
	private String name;
	
	@Column
	private String imgURL;
	
	@Column(name = "rec_type")
	@Enumerated(EnumType.STRING)
	private RecipeType type;
	
	@Column
	@Enumerated(EnumType.STRING)
	private RecipeComplexityType complexity;
	
	@Column
	private Double price;
	
	@Column(name= "time_prep")
	private Integer time;
	
	@Column
	private Integer prepared;
	
	@ElementCollection
	@CollectionTable(name = "ingredients")
	private List<String> ingredients = new ArrayList<>();
	
	@ElementCollection
	@CollectionTable(name = "steps")
	private List<String> steps = new ArrayList<>();

	public Recipe() {
		super();
	}

	public Recipe(String name, RecipeType type, Double price, Integer time,
			List<String> ingredients, List<String> steps, String imgURL) {
		super();
		this.name = name;
		this.type = type;
		this.price = price;
		this.time = time;
		this.ingredients = ingredients;
		this.steps = steps;
		this.imgURL = imgURL;
		this.prepared = 0;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public RecipeComplexityType getComplexity() {
		return complexity;
	}

	public void setComplexity(RecipeComplexityType complexity) {
		this.complexity = complexity;
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

	public List<String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}

	public List<String> getSteps() {
		return steps;
	}

	public void setSteps(List<String> steps) {
		this.steps = steps;
	}

	public Integer getPrepared() {
		return prepared;
	}

	public void setPrepared(Integer prepared) {
		this.prepared = prepared;
	}

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}

	@Override
	public String toString() {
		return "Recipe [id=" + id + ", name=" + name + ", imgURL=" + imgURL + ", type=" + type + ", complexity="
				+ complexity + ", price=" + price + ", time=" + time + ", prepared=" + prepared + ", ingredients="
				+ ingredients + ", steps=" + steps + "]";
	}

	
}
