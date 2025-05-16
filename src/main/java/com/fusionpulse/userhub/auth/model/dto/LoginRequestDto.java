package com.fusionpulse.userhub.auth.model.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class LoginRequestDto {
    @Email
    private String email;

    @NotBlank
    private String password;    
}
