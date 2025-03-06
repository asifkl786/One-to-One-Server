package com.rms.ManualMapper;

import com.rms.DTO.ProfileDTO;
import com.rms.DTO.UserDTO;
import com.rms.model.Profile;

public class ProfileMapper {
	
	
	// Convert profileDTO to profile toEntity
    public static Profile toEntity(ProfileDTO profileDTO) {
    	
    		Profile profile = new Profile();
    		profile.setId(profileDTO.getId());
    		profile.setAddress(profileDTO.getAddress());
    		profile.setPhoneNumber(profileDTO.getPhoneNumber());
    		return profile;
    	 }
    	
    
    
    // Convert to DTO
    public static ProfileDTO toDTO(Profile profile) {
    	
    	ProfileDTO profileDTO = new ProfileDTO();
    	profileDTO.setId(profile.getId());
    	profileDTO.setAddress(profile.getAddress());
    	profileDTO.setPhoneNumber(profile.getPhoneNumber());
    	
    	if(profile.getUser() != null) {
    		UserDTO userDto = new UserDTO();
    		userDto.setId(profile.getUser().getId());
    		userDto.setName(profile.getUser().getName());
    		userDto.setEmail(profile.getUser().getEmail());
    		userDto.setProfile(profileDTO);
    	}
    	
    	return profileDTO;
    }
	

}
