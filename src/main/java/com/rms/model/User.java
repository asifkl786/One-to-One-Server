package com.rms.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name = "users")
public class User {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotBlank(message = "Name is required")
	    private String name;

	    @Email(message = "Email should be valid")
	    @Column(unique = true, nullable = false)
	    private String email;

	    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    @JoinColumn(name = "profile_id", referencedColumnName = "id")
	    private Profile profile;

		public User() {
			super();
			// TODO Auto-generated constructor stub
		}

		public User(Long id, @NotBlank(message = "Name is required") String name,
				@Email(message = "Email should be valid") String email, Profile profile) {
			super();
			this.id = id;
			this.name = name;
			this.email = email;
			this.profile = profile;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Profile getProfile() {
			return profile;
		}

		public void setProfile(Profile profile) {
			this.profile = profile;
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", name=" + name + ", email=" + email + ", profile=" + profile + "]";
		}
	    
	    

}
