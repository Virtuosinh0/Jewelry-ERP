package com.example.Jewelry.mappers;


import com.example.Jewelry.dtos.JewelryResponseDto;
import com.example.Jewelry.models.Jewelry;
import org.springframework.stereotype.Component;

@Component
public class JewerlyMapper {
    public JewelryResponseDto toDto(Jewelry jewelry){
        return new JewelryResponseDto(
                jewelry.getPrice(),
                jewelry.getMetal(),
                jewelry.getGemstone()
                );
    }
}
