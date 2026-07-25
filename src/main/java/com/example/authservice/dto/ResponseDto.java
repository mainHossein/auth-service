package com.example.authservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDto {
    private String message;

    public ResponseDto(String message) {
        this.message = message;
    }
}
