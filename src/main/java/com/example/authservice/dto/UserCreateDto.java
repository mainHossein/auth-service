package com.example.authservice.dto;

import com.example.authservice.database.entity.UserRoles;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreateDto {
    @NotNull(message = "username couldn't be null")
    @NotBlank(message = "username is required")
    private String username;
    @NotNull(message = "password couldn't be null")
    @NotBlank(message = "password couldn't be empty")
    private String password;
    @NotNull(message = "roles couldn't be null")
    @NotBlank(message = "at least one role is required")
    private HashSet<UserRoles> userRoles;
}
