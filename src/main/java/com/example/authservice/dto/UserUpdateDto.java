package com.example.authservice.dto;

import com.example.authservice.database.entity.UserRoles;
import lombok.*;

import java.util.HashSet;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserUpdateDto {
    private String username;
    private HashSet<UserRoles> userRoles;
}
