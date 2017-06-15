package com.goodvideotutorials.spring.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goodvideotutorials.spring.entities.User;

/**
 * @author Achille
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByEmail(String email);

	Optional<User> findByForgotPasswordCode(String forgotPasswordCode);

}
