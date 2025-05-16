package com.fusionpulse.userhub.auth.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fusionpulse.userhub.auth.model.dto.RegisterRequestDto;
import com.fusionpulse.userhub.common.enumlist.UserRole;
import com.fusionpulse.userhub.user.model.entity.User;
import com.fusionpulse.userhub.user.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public String register(RegisterRequestDto dto){
        if(userRepository.existsByEmail(dto.getEmail())){
            throw new RuntimeException("Email already exists");
        }

        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setRole(dto.getRole() == null ? UserRole.CUSTOMER: dto.getRole());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        userRepository.save(user);

        return "Successfully registered";
    }
    
}
