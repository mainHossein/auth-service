package com.example.authservice.service;

import com.example.authservice.database.entity.User;
import com.example.authservice.database.repository.UserRepository;
import com.example.authservice.dto.*;
import com.example.authservice.exception.DuplicateUserException;
import com.example.authservice.exception.UsernameNotFoundException;
import com.example.authservice.mapper.UserCreateMapper;
import com.example.authservice.mapper.UserInfoMapper;
import com.example.authservice.mapper.UserUpdateMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserInfoMapper userInfoMapper;
    private final UserCreateMapper userCreateMapper;
    private final UserUpdateMapper userUpdateMapper;
    private final PasswordEncoder passwordEncoder;

    public ResponseEntity<Page<UserInfoDto>> findAll(Pageable pageable) {
        Page<User> users = userRepository.findAll(pageable);
        List<UserInfoDto> userInfoDtos = new ArrayList<>();
        users.forEach(user -> {
            userInfoDtos.add(userInfoMapper.toDestination(user));
        });
        Page<UserInfoDto> userInfoDtoPage = new PageImpl<>(userInfoDtos, pageable, userInfoDtos.size());
        return new ResponseEntity<>(userInfoDtoPage, HttpStatus.OK);
    }

    public ResponseEntity<UserInfoDto> findByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(
                "user with username %s not found".formatted(username)));
        return new ResponseEntity<>(userInfoMapper.toDestination(user), HttpStatus.OK);
    }

    public ResponseEntity<UserInfoDto> create(UserCreateDto user) {
        checkDuplicateUser(user.getUsername());
        User source = userCreateMapper.toSource(user);
        source.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(source);
        return new ResponseEntity<>(userInfoMapper.toDestination(savedUser), HttpStatus.CREATED);
    }

    public ResponseEntity<UserInfoDto> update(String username, UserUpdateDto user) {
        User fetchedUser = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(
                "user with username %s not found".formatted(username)));
        userUpdateMapper.partialUpdate(fetchedUser, user);
        User savedUser = userRepository.save(fetchedUser);
        return new ResponseEntity<>(userInfoMapper.toDestination(savedUser), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDto> updatePassword(String username, PasswordDto password) {
        User fetchedUser = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(
                "user with username %s not found".formatted(username)));
        fetchedUser.setPassword(passwordEncoder.encode(password.getPassword()));
        userRepository.save(fetchedUser);
        return new ResponseEntity<>(new ResponseDto("password is updated"), HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<ResponseDto> delete(String username) {
        userRepository.deleteByUsername(username);
        return new ResponseEntity<>(new ResponseDto("user is deleted"), HttpStatus.NO_CONTENT);
    }

    private void checkDuplicateUser(String username) {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new DuplicateUserException("this user already exists");
        }
    }
}
