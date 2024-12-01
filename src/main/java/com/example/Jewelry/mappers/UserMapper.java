package com.example.Jewelry.mappers;

import com.example.Jewelry.dtos.UserResponseDto;
import com.example.Jewelry.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserResponseDto toDto(User user){
        return new UserResponseDto(
                user.getName()
        );
    }
}
