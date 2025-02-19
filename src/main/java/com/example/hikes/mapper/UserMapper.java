package com.example.hikes.mapper;

import com.example.hikes.dto.request.auth.CreateUserRequestDTO;

import com.example.hikes.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserMapper {
    public User toDocument(CreateUserRequestDTO createUserRequestDTO){
        User user = new User();
        user.setUsername(createUserRequestDTO.getUserName());
        user.setEmail(createUserRequestDTO.getEmail());
        user.setPassword(createUserRequestDTO.getPassword());
        return user;
    }
}
