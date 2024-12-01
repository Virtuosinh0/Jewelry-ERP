package com.example.Jewelry.controllers;

import com.example.Jewelry.dtos.ErrorDto;
import com.example.Jewelry.dtos.UserRequestDto;
import com.example.Jewelry.dtos.UserResponseDto;
import com.example.Jewelry.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class  UserController {
    @Autowired
    UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto insertUser(@RequestBody @Valid UserRequestDto userRequestDto) {
        return userService.insertUser(userRequestDto);
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
