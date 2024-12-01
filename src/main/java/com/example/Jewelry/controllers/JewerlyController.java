package com.example.Jewelry.controllers;

import com.example.Jewelry.dtos.ErrorDto;
import com.example.Jewelry.dtos.JewelryRequestDto;
import com.example.Jewelry.dtos.JewelryResponseDto;
import com.example.Jewelry.services.JewelryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("/jewelry")
public class JewerlyController {
    @Autowired
    JewelryService jewelryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public JewelryResponseDto insertJewelry(@RequestBody @Valid JewelryRequestDto jewelryRequestDto){
        return jewelryService.insertJewelry(jewelryRequestDto);
    }

    @GetMapping
    public List<JewelryResponseDto> returnJewelry(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "5") Integer pageSize
    ){
        return jewelryService.returnJewelry(page, pageSize);
    }

    @GetMapping("/{id}")
    public JewelryResponseDto returnById(@PathVariable UUID id){
        return jewelryService.returnJewelryByID(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public JewelryResponseDto deleteById(@PathVariable UUID id){
        return jewelryService.deleteJewelryByID(id);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto validationError(HttpServletRequest req, MethodArgumentNotValidException exception) {
        return new ErrorDto(
                HttpStatus.BAD_REQUEST,
                exception.getAllErrors().get(0).getDefaultMessage()
        );
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDto validationError(RuntimeException exception) {
        return new ErrorDto(
                HttpStatus.INTERNAL_SERVER_ERROR,
                exception.getMessage()
        );
    }
}
