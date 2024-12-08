package com.rms.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.rms.DTO.UserDTO;
import com.rms.Exception.ResourceNotFoundException;
import com.rms.ManualMapper.UserMapper;
import com.rms.Repository.UserRepository;
import com.rms.model.Profile;
import com.rms.model.User;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImple implements UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImple.class);
	
	@Autowired
	private UserRepository userRepository;
	
	
    // Create User
	@Override
	public UserDTO createUser(UserDTO userDTO) {
		logger.info("Creating user: {}", userDTO);
	User ConvertedUserDToToEntityObject = UserMapper.toEntity(userDTO);
	User savedUserObject = userRepository.save(ConvertedUserDToToEntityObject);
		return UserMapper.toDTO(savedUserObject);
	}

	// Get User By Id
	@Override
	public UserDTO getUserById(Long id) {
		logger.info("Fetching User with ID: {}", id);
	    User user = userRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("User is not exists with given id :"  + id));
		return UserMapper.toDTO(user);
	}

	
	// Get All Users
	@Override
	public List<UserDTO> getAllUser() {
		logger.info("Fetching Users");
		List<User> users = userRepository.findAll();
		return users.stream().map(UserMapper::toDTO).collect(Collectors.toList());
	}
    
	// Update User
	@Override
	public UserDTO updateUser(Long id, UserDTO userDTO) {
		logger.info("Update User with ID: {}", id);
		// get user from the repository
		 User user = userRepository.findById(id)
		        .orElseThrow(() -> new ResourceNotFoundException("User is not exists with given id :"  + id));
		 user.setId(userDTO.getId());
		 user.setName(userDTO.getName());
		 user.setEmail(userDTO.getEmail());
		 
		 // set values to user from profileDTO Object
		 Profile profile = new Profile();
		 profile.setAddress(userDTO.getProfile().getAddress());
		 profile.setPhoneNumber(userDTO.getProfile().getPhoneNumber());
		 user.setProfile(profile);
		 
		 // save User in the repository
		 User savedUser = userRepository.save(user);
		return UserMapper.toDTO(savedUser);
	}

	@Override
	public void deleteUser(Long id) {
		logger.info("Update User with ID: {}", id);
		User user = userRepository.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("User is not exists with given id :"  + id));
		userRepository.delete(user);	
	}

	@Override
	public List<UserDTO> SearchUser(String query) {
		logger.info("Search User with query: {}", query);
		List<User> users = userRepository.SearchUser(query);
				if (users.isEmpty()) {
		            throw new ResourceNotFoundException("No users found in with query: " + query);
		        }
				//.orElseThrow(() -> new ResourceNotFoundException("User is not exists with given id :"  + id));
		return users.stream().map(UserMapper::toDTO).collect(Collectors.toList());
	}

	

}
