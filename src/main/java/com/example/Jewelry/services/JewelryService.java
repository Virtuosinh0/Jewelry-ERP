package com.example.Jewelry.services;

import com.example.Jewelry.dtos.JewelryRequestDto;
import com.example.Jewelry.dtos.JewelryResponseDto;
import com.example.Jewelry.mappers.JewerlyMapper;
import com.example.Jewelry.models.Jewelry;
import com.example.Jewelry.repositories.GroupRepository;
import com.example.Jewelry.repositories.JewerlyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class JewelryService {
    @Autowired
    JewerlyRepository jewerlyRepository;
    @Autowired
    JewerlyMapper jewerlyMapper;
    //@Autowired
    //GroupRepository groupRepository;

    public JewelryResponseDto insertJewelry(JewelryRequestDto jewelryRequestDto){
        Jewelry jewelry = new Jewelry();

        jewelry.setPrice(jewelryRequestDto.price());
        jewelry.setMetal(jewelryRequestDto.metal());
        jewelry.setGemstone(jewelryRequestDto.gemstone());

        jewerlyRepository.save(jewelry);
        return jewerlyMapper.toDto(jewelry);
    }

    public List<JewelryResponseDto> returnJewelry(Integer page, Integer pageSize){
        Pageable pageConfig = PageRequest.of(page, pageSize);
        return jewerlyRepository.findAll(pageConfig).stream().map(jewerlyMapper::toDto).toList();
    }

    public JewelryResponseDto returnJewelryByID (UUID id){
        Jewelry jewelry = jewerlyRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Jóia não encontrada")
        );
        return jewerlyMapper.toDto(jewelry);
    }

    public JewelryResponseDto deleteJewelryByID (UUID id){
        Jewelry jewelry = jewerlyRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Jóia não encontrada")
        );
        jewerlyRepository.delete(jewelry);
        return jewerlyMapper.toDto(jewelry);
    }
}
