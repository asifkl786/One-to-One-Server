package com.rms.Service;

import java.util.List;

import com.rms.DTO.UserDTO;

public interface UserService {
	 UserDTO createUser(UserDTO userDTO);
	 UserDTO getUserById(Long id);
	 List<UserDTO> getAllUser();
	 UserDTO updateUser(Long id , UserDTO userDTO);
	 void deleteUser(Long id);
	 List<UserDTO> SearchUser(String query);

}
