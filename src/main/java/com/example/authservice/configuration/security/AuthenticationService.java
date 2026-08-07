package com.example.authservice.configuration.security;

import com.example.authservice.database.entity.User;
import com.example.authservice.database.repository.UserRepository;
import com.example.authservice.dto.LoginRequestDto;
import com.example.authservice.dto.TokenResponseDto;
import com.example.authservice.exception.InvalidCredentialException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public ResponseEntity<TokenResponseDto> handleLogin(LoginRequestDto loginRequestDto) {
        User user = userRepository.findByUsername(loginRequestDto.getUsername()).orElseThrow(
                InvalidCredentialException::new);
        if (passwordEncoder.matches(loginRequestDto.getPassword(), user.getPassword())) {
            TokenResponseDto tokenResponseDto = new TokenResponseDto(
                    jwtService.generateToken(loginRequestDto.getUsername()));
            return new ResponseEntity<>(tokenResponseDto, HttpStatus.OK);
        } else {
            throw new InvalidCredentialException();
        }
    }
}
