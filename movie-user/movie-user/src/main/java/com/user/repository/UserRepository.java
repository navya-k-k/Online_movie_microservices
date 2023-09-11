package com.user.repository;

//import java.sql.Date;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.entity.User;

@Repository(value="userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {
	 User findByUsername(String username);
	
}
