package com.rms.model;


import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "profiles")
public class Profile {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phoneNumber;
    private String address;

    @OneToOne(mappedBy = "profile", fetch = FetchType.LAZY)
    private User user;
	
    
}
