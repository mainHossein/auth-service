package com.example.authservice.database.repository;

import com.example.authservice.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    @Query("""
            select distinct u
            from User u
            left join fetch u.userRoles
            """)
    List<User> getAllUsers();
}
