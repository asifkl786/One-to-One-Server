package com.rms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rms.model.Profile;

public interface ProfileRepository extends JpaRepository<Profile,Long>{

}
