package com.rms.ManualMapper;

import com.rms.DTO.ProfileDTO;
import com.rms.DTO.UserDTO;
import com.rms.model.Profile;
import com.rms.model.User;

public class UserMapper {
	
	// Convert to Entity
	public static User toEntity(UserDTO userDTO) {
		User user = new User();
		user.setId(userDTO.getId());
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		
		// Convert ProfileDTO to Profile entity
		if(userDTO.getProfile() != null) {
			Profile profile = new Profile();
			profile.setAddress(userDTO.getProfile().getAddress());
			profile.setPhoneNumber(userDTO.getProfile().getPhoneNumber());
			user.setProfile(profile);
		}
		return user;
	}
	
	// Convert to DTO
	public static UserDTO toDTO(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setName(user.getName());
		userDTO.setEmail(user.getEmail());
		
		// Convert Profile entity to ProfileDTO
		if(user.getProfile() != null) {
			ProfileDTO profileDTO = new ProfileDTO();
			profileDTO.setAddress(user.getProfile().getAddress());
			profileDTO.setPhoneNumber(user.getProfile().getPhoneNumber());
			userDTO.setProfile(profileDTO);
		}
		return userDTO;
	}

}
