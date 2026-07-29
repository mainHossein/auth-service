package com.example.authservice.controller;

import com.example.authservice.dto.*;
import com.example.authservice.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Tag(name = "Users")
public class UserController {
    private final UserService userService;

    @Operation(summary = "Get all users with pagination")
    @GetMapping
    public ResponseEntity<Page<UserInfoDto>> getAllUsers(Pageable pageable) {
        return userService.findAll(pageable);
    }

    @Operation(summary = "Get users by username")
    @GetMapping("/{username}")
    public ResponseEntity<UserInfoDto> getUserByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @Operation(summary = "Create users")
    @PostMapping
    public ResponseEntity<UserInfoDto> createUser(@Valid @RequestBody UserCreateDto user) {
        return userService.create(user);
    }

    @Operation(summary = "grant roles to users")
    @PatchMapping("/grant-roles/{username}")
    public ResponseEntity<UserInfoDto> grantRoles(@PathVariable String username,
                                                @RequestBody HashSet<String> roles) {
        return userService.grantRoles(username, roles);
    }

    @Operation(summary = "revoke roles from users")
    @PatchMapping("/revoke-roles/{username}")
    public ResponseEntity<UserInfoDto> revokeRoles(@PathVariable String username,
                                                  @RequestBody HashSet<String> roles) {
        return userService.revokeRoles(username, roles);
    }

    @Operation(summary = "Reset users password")
    @PatchMapping("/reset-password/{username}")
    public ResponseEntity<ResponseDto> resetPassword(@PathVariable String username,
                                                     @Valid @RequestBody PasswordDto password) {
        return userService.updatePassword(username, password);
    }

    @Operation(summary = "Delete users")
    @DeleteMapping("/delete/{username}")
    public ResponseEntity<ResponseDto> deleteUser(@PathVariable String username) {
        return userService.delete(username);
    }
}
