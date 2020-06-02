package com.bsep.recipes.dto;

public class StepDTO {
	Integer number;
	String step;
	Boolean success;
	public StepDTO() {
		super();
	}
	public String getStep() {
		return step;
	}
	public void setStep(String step) {
		this.step = step;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "StepDTO [number=" + number + ", step=" + step + ", success=" + success + "]";
	}
	
	
	
}
