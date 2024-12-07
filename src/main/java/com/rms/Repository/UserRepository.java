package com.rms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rms.model.User;

public interface UserRepository extends JpaRepository<User,Long> {

}
