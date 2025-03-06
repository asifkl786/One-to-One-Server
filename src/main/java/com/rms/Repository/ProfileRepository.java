package com.rms.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rms.model.Profile;

public interface ProfileRepository extends JpaRepository<Profile,Long>{
	
	 // This is custom search method JPQL QUERY
    @Query("SELECT p FROM Profile p WHERE " +
           "p.phoneNumber LIKE CONCAT('%', :query, '%')" +
            "Or p.address LIKE CONCAT('%', :query, '%')" )
    List<Profile> SearchUserByProfile(String query);

}
