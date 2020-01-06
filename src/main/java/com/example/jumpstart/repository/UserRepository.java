package com.example.jumpstart.repository;

import com.example.jumpstart.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);
}
