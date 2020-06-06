package com.bsep.recipes.events;

import org.kie.api.definition.type.Role;

@Role(Role.Type.EVENT)

public class StepEvent {
	private int userID;
	private int recipeID;
	private String step;
	private boolean success;
	
	public StepEvent() {
		super();
	}

	public StepEvent(int userID, int recipeID, String step, boolean success) {
		super();
		this.userID = userID;
		this.recipeID = recipeID;
		this.step = step;
		this.success = success;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getRecipeID() {
		return recipeID;
	}

	public void setRecipeID(int recipeID) {
		this.recipeID = recipeID;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	@Override
	public String toString() {
		return "StepEvent [userID=" + userID + ", recipeID=" + recipeID + ", step=" + step + ", success=" + success
				+ "]";
	}
	
}
