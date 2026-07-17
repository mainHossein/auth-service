package com.example.authservice.controller;

import com.example.authservice.dto.*;
import com.example.authservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<Page<UserInfoDto>> getAllUsers(Pageable pageable) {
        return userService.findAll(pageable);
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserInfoDto> getUserByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @PostMapping
    public ResponseEntity<UserInfoDto> createUser(@RequestBody UserCreateDto user) {
        return userService.create(user);
    }

    @PatchMapping("/update-user/{username}")
    public ResponseEntity<UserInfoDto> updateUser(@PathVariable String username,
                                                  @RequestBody UserUpdateDto user) {
        return userService.update(username, user);
    }

    @PatchMapping("/reset-password/{username}")
    public ResponseEntity<ResponseDto> resetPassword(@PathVariable String username,
                                                     @RequestBody PasswordDto password) {
        return userService.updatePassword(username, password);
    }
}
