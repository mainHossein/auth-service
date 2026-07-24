package com.example.authservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class PasswordDto {
    @NotNull(message = "password couldn't be null")
    @NotBlank(message = "password couldn't be blank")
    private String password;
}
