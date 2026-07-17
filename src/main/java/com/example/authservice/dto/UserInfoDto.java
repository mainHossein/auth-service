package com.example.authservice.dto;

import com.example.authservice.database.entity.UserRoles;
import lombok.*;

import java.sql.Timestamp;
import java.util.HashSet;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInfoDto {
    private String username;
    private HashSet<UserRoles> userRoles;
    private Timestamp createdAt;

}
