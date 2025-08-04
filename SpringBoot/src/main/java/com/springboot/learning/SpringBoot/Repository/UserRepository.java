package com.springboot.learning.SpringBoot.Repository;

import com.springboot.learning.SpringBoot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
}
