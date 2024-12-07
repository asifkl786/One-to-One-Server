package com.rms.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rms.DTO.UserDTO;
import com.rms.Service.UserService;

import lombok.AllArgsConstructor;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	
	// Build Create User REST API
	@PostMapping("/create")
	private ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
		logger.info("Receaived request to create User: {}", userDTO);
	     UserDTO savedUser = userService.createUser(userDTO);
		return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
	}
	
	// Build Get User By Id REST API
	@GetMapping("/{id}")
	private ResponseEntity<UserDTO> getUserById(@PathVariable Long id){
		logger.info("Received request to fetch User With ID: {}", id);
		UserDTO user = userService.getUserById(id);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	// Build Get All User REST API
	@GetMapping("/getAllUsers")
	private ResponseEntity<List<UserDTO>> getAllUser(){
		logger.info("Received request to fetch All User");
		List<UserDTO> users = userService.getAllUser();
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	
	// Build Update User REST API
	@PutMapping("/{id}")
	private ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO){
		logger.info("Received request to update User with ID: {}", id);
	UserDTO updatedUser = userService.updateUser(id, userDTO);
		return new ResponseEntity<>(updatedUser,HttpStatus.OK);
	}
	
	// Build Delete User REST API
	@DeleteMapping("/{id}")
	private ResponseEntity<String> deleteUser(@PathVariable Long id){
		logger.info("Received request to Delete User with ID: {}", id);
		userService.deleteUser(id);
		return new ResponseEntity<>("User Delete Successfully",HttpStatus.OK);
	}

}