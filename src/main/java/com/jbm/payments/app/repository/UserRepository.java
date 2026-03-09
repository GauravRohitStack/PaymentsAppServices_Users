package com.jbm.payments.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jbm.payments.app.entity.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Find user by email (used for login)
    Optional<User> findByEmail(String email);

    // Check if email already exists (used during registration)
    boolean existsByEmail(String email);
}