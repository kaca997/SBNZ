package com.bsep.recipes.mapper;

import com.bsep.recipes.dto.RegisteredUserDTO;
import com.bsep.recipes.model.Recipe;
import com.bsep.recipes.model.RegisteredUser;

public class RegisteredUserMapper {
	
	
	public static RegisteredUser toRegisteredUser(RegisteredUserDTO dto) {
		return new RegisteredUser(dto.getUsername(), dto.getPassword(), dto.getFirstName(), dto.getLastName(), dto.getLikes(), dto.getHates());
	}

}
