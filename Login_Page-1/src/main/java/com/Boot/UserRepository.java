package com.Boot;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    Optional<User>  findByUsernameAndPassword(String uname,String password);
	//User findByResetToken(String token);
	boolean existsByUsername(String username);
    
    
}