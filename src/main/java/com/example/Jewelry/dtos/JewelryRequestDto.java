    package com.example.Jewelry.dtos;

    import jakarta.validation.constraints.*;

    public record JewelryRequestDto(
            @Min(value = 1) Float price,
            @NotBlank String metal,
            String gemstone
    ) {}
