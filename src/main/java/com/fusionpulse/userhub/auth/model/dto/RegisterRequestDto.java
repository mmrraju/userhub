package com.fusionpulse.userhub.auth.model.dto;

import com.fusionpulse.userhub.common.enumlist.UserRole;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class RegisterRequestDto {
    @NotBlank
    private String name;

    @Email
    private String email;

    @NotBlank
    private String password;

    private UserRole role; // ADMIN, EMPLOYEE, CUSTOMER    
}
