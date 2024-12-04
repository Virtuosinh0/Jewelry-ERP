package com.example.Jewelry.dtos;

import java.util.UUID;

public record JewelryResponseDto(
        Float price,
        String metal,
        String gemstone
) {}
