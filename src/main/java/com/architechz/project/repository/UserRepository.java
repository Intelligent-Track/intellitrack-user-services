package com.architechz.project.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.architechz.project.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findByUsername(String username);
	Boolean existsByUsername(String username);
    String deleteByUsername(String username);
    //User findByUsername(String username);
}
