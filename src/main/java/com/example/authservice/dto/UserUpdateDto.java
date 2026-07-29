package com.example.authservice.dto;

import com.example.authservice.database.entity.UserRoles;
import com.example.authservice.database.enumerated.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserUpdateDto {
    @NotNull(message = "username couldn't be null")
    @NotBlank(message = "username is required")
    private String username;
    @NotNull(message = "roles couldn't be null")
    private HashSet<String> userRoles;
}
