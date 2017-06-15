package com.achille.spring.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.achille.spring.entities.User;

/**
 * @author Achille
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByEmail(String email);

	Optional<User> findByForgotPasswordCode(String forgotPasswordCode);

}
