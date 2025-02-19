package com.example.hikes.service;

import com.example.hikes.dto.request.auth.CreateUserRequestDTO;
import com.example.hikes.model.User;
import com.example.hikes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(CreateUserRequestDTO createUserRequestDTO){

    }
}
