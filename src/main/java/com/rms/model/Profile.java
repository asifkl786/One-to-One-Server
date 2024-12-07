package com.rms.model;


import jakarta.persistence.*;


@Entity
@Table(name = "profiles")
public class Profile {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phoneNumber;
    private String address;

    @OneToOne(mappedBy = "profile", fetch = FetchType.LAZY)
    private User user;

	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Profile(Long id, String phoneNumber, String address, User user) {
		super();
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Profile [id=" + id + ", phoneNumber=" + phoneNumber + ", address=" + address + ", user=" + user + "]";
	}
    
    
}
