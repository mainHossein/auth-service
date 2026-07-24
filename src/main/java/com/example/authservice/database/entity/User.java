package com.example.authservice.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(
        name = "user_credential",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username")
        }
)
public class User extends AuditEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String username;
    private String password;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<UserRoles> userRoles;
}
