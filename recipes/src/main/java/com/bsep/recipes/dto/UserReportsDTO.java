package com.bsep.recipes.dto;

import java.util.ArrayList;
import java.util.List;

import com.bsep.recipes.model.RegisteredUser;

public class UserReportsDTO {

	private List<RegisteredUser> users;

	public UserReportsDTO(List<RegisteredUser> users) {
		super();
		this.users = users;
	}

	public UserReportsDTO() {
		super();
		this.users = new ArrayList<RegisteredUser>();
	}

	public List<RegisteredUser> getUsers() {
		return users;
	}

	public void setUsers(List<RegisteredUser> users) {
		this.users = users;
	}
}
