package com.rms.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rms.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
	
	// This is custom search method JPQL QUERY
    @Query("SELECT p FROM User p WHERE " +
           "p.name LIKE CONCAT('%', :query, '%')" +
            "Or p.email LIKE CONCAT('%', :query, '%')" )
    List<User> SearchUser(String query);

}
