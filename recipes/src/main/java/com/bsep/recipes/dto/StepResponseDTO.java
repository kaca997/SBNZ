package com.bsep.recipes.dto;

public class StepResponseDTO {
	String message;
	boolean good;
	boolean bad;
	
	public StepResponseDTO() {
		super();
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isGood() {
		return good;
	}
	public void setGood(boolean good) {
		this.good = good;
	}
	public boolean isBad() {
		return bad;
	}
	public void setBad(boolean bad) {
		this.bad = bad;
	}
}
