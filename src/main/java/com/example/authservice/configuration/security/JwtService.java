package com.example.authservice.configuration.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {

    private final String SECRET_KEY = "this is too much secret";

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String getUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    public Boolean isTokenValid(String token) {
        return extractAllClaims(token).getExpiration().after(new Date());
    }

    private Key getKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

}
