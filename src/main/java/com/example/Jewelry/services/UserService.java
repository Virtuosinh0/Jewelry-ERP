package com.example.Jewelry.services;

import com.example.Jewelry.dtos.UserRequestDto;
import com.example.Jewelry.dtos.UserResponseDto;
import com.example.Jewelry.mappers.UserMapper;
import com.example.Jewelry.models.User;
import com.example.Jewelry.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;

    public UserResponseDto insertUser(UserRequestDto userRequestDto){
        User user = new User();
        user.setName(userRequestDto.name());
        user.setEmail(userRequestDto.email());
        user.setPassword(userRequestDto.password());

        userRepository.save(user);
        return userMapper.toDto(user);
    }
}
