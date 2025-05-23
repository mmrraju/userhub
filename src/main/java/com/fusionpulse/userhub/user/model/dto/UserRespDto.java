package com.fusionpulse.userhub.user.model.dto;

import com.fusionpulse.userhub.common.enumlist.UserRole;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UserRespDto {
    @NotBlank(message = "id is required")
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @Enumerated(EnumType.STRING)
    private UserRole role;        
}
