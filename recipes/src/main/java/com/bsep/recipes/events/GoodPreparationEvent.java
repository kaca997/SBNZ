package com.bsep.recipes.events;

import org.kie.api.definition.type.Role;

@Role(Role.Type.EVENT)
public class GoodPreparationEvent {
	private Integer userID;
	private Integer recipeID;
	public GoodPreparationEvent() {
		super();
	}
	public GoodPreparationEvent(Integer userID, Integer recipeID) {
		super();
		this.userID = userID;
		this.recipeID = recipeID;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public Integer getRecipeID() {
		return recipeID;
	}
	public void setRecipeID(Integer recipeID) {
		this.recipeID = recipeID;
	}
	
	
}
