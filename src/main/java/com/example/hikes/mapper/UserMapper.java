package com.example.hikes.mapper;

import com.example.hikes.dto.request.auth.CreateUserRequestDTO;

import com.example.hikes.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class UserMapper {
    @Autowired
    PasswordEncoder encoder;

    public User toDocument(CreateUserRequestDTO createUserRequestDTO){
        User user = new User();
        user.setUsername(createUserRequestDTO.getUsername());
        user.setEmail(createUserRequestDTO.getEmail());
        user.setPassword(encoder.encode(createUserRequestDTO.getPassword()));
        return user;
    }
}
