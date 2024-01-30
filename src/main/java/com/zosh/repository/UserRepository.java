package com.zosh.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zosh.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	public Optional<User> findByEmail(String username);
	
	
	@Query("SELECT DISTINCT u FROM User u WHERE u.username LIKE %:query% OR u.email LIKE %:query%")
	public Set<User> findByQuery(@Param("query") String query);

	
	@Query("SELECT u FROM User u WHERE u.username LIKE %:name%")
	List<User> searchUsers(@Param("name") String name);


}
