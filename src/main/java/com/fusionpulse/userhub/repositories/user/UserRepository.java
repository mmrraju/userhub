package com.fusionpulse.userhub.repositories.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fusionpulse.userhub.model.user.entity.User;

public interface UserRepository  extends JpaRepository<User, Long>{

    boolean existsByEmail(String email);
    Optional<User> findById(Long id);
}