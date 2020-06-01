package com.bsep.recipes.dto;

import java.util.ArrayList;
import java.util.List;

import com.bsep.recipes.model.RegisteredUser;

public class UserReportsDTO {

	private List<BestUserDTO> users;

	public UserReportsDTO(List<BestUserDTO> users) {
		super();
		this.users = users;
	}

	public UserReportsDTO() {
		super();
		this.users = new ArrayList<BestUserDTO>();
	}

	public List<BestUserDTO> getUsers() {
		return users;
	}

	public void setUsers(List<BestUserDTO> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "UserReportsDTO [users=" + users + "]";
	}
	
	
}
