package com.auth.jwt.backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.auth.jwt.backend.entities.*;

public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByLogin(String login);
}
