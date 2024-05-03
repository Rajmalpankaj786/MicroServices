package com.masai.user.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.user.Entity.User;

public interface UserRepositery extends JpaRepository<User, String> {
	
	@Query(value = "SELECT * FROM user_table WHERE email = :email", nativeQuery = true)
	 User findByEmail(String email);
	
	@Query(value = "SELECT * FROM user_table WHERE username = :username", nativeQuery = true)
	User findByUserName(String username);
}
