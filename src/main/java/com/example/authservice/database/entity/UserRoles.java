package com.example.authservice.database.entity;

import com.example.authservice.database.enumerated.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
public class UserRoles extends AuditEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "fk_user_id" , nullable = false)
    private User user;
    @Enumerated(EnumType.STRING)
    private Role role;

    public UserRoles(Role role) {
        this.role = role;
    }

    public UserRoles(User user, Role role) {
        this.user = user;
        this.role = role;
    }
}
