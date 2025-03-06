package com.rms.DTO;

import lombok.Data;

@Data
public class UserDTO {

	private Long id;
	private String name;
	private String email;
	private ProfileDTO profile;
   
}
