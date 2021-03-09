package br.com.pierredev.hruser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pierredev.hruser.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);
}
