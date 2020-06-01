package com.bsep.recipes.mapper;

import java.util.List;

import com.bsep.recipes.dto.BestUserDTO;
import com.bsep.recipes.dto.BestUserGradeDTO;
import com.bsep.recipes.dto.UserReportsDTO;
import com.bsep.recipes.model.Grade;
import com.bsep.recipes.model.RegisteredUser;

public class BestUsersMapper {
	public static UserReportsDTO toRecipe(List<RegisteredUser> users) {
		UserReportsDTO mapped = new UserReportsDTO();
		for(RegisteredUser u: users) {
			BestUserDTO userDTO = new BestUserDTO();
			for(Grade g: u.getGrades()) {
				BestUserGradeDTO gradeDTO = new BestUserGradeDTO(g.getRecipe().getName(), g.getGrade());
				userDTO.getGrades().add(gradeDTO);
			}
			userDTO.setFirstName(u.getFirstName());
			userDTO.setLastName(u.getLastName());
			userDTO.setUsername(u.getUsername());
			mapped.getUsers().add(userDTO);
		}
		return mapped;
	}
}
