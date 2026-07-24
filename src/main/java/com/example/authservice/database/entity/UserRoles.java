package com.example.authservice.database.entity;

import com.example.authservice.database.enumerated.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(
        name = "user_roles",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"fk_user_id", "role"})
        }
)
public class UserRoles extends AuditEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "fk_user_id")
    private UUID userId;
    @ManyToOne
    @JoinColumn(name = "fk_user_id", updatable = false, insertable = false)
    private User user;
    @Enumerated(EnumType.STRING)
    private Role role;
}
