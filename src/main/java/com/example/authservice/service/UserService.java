package com.example.authservice.service;

import com.example.authservice.database.repository.UserRepository;
import com.example.authservice.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public ResponseEntity<Page<UserInfoDto>> findAll(Pageable pageable) {
        return null;
    }

    public ResponseEntity<UserInfoDto> findByUsername(String username) {
        return null;
    }

    public ResponseEntity<UserInfoDto> create(UserCreateDto user) {
        return null;
    }

    public ResponseEntity<UserInfoDto> update(String username, UserUpdateDto user) {
        return null;
    }

    public ResponseEntity<ResponseDto> updatePassword(String username, PasswordDto password) {
        return null;
    }
}
