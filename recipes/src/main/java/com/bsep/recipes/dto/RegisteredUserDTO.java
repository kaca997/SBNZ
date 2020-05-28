package com.bsep.recipes.dto;

import java.util.ArrayList;
import java.util.List;

public class RegisteredUserDTO {
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private List<String> likes;
	private List<String> hates;
	
	public RegisteredUserDTO(String firstName, String lastName, String username, String password, List<String> likes,
			List<String> hates) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.likes = likes;
		this.hates = hates;
	}

	public RegisteredUserDTO() {
		super();
		this.likes = new ArrayList<String>();
		this.hates = new ArrayList<String>();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<String> getLikes() {
		return likes;
	}

	public void setLikes(List<String> likes) {
		this.likes = likes;
	}

	public List<String> getHates() {
		return hates;
	}

	public void setHates(List<String> hates) {
		this.hates = hates;
	}

	@Override
	public String toString() {
		return "RegisteredUserDTO [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + ", likes=" + likes + ", hates=" + hates + "]";
	}

}
