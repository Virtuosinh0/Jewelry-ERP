package com.example.Jewelry.dtos;

public record ErrorDto(
        org.springframework.http.HttpStatus status,
        String reason
) {
}
