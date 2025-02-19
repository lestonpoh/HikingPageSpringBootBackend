package com.example.hikes.service;

import com.example.hikes.dto.request.auth.CreateUserRequestDTO;
import com.example.hikes.exception.UserEmailAlreadyExistException;
import com.example.hikes.exception.UsernameAlreadyExistException;
import com.example.hikes.mapper.UserMapper;
import com.example.hikes.model.User;
import com.example.hikes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    public void createUser(CreateUserRequestDTO createUserRequestDTO){
        if(userRepository.existsByUsername(createUserRequestDTO.getUsername())){
            throw new UsernameAlreadyExistException();
        }

        if (userRepository.existsByEmail(createUserRequestDTO.getEmail())){
            throw new UserEmailAlreadyExistException();
        }

        User user = userMapper.toDocument(createUserRequestDTO);
        userRepository.insert(user);

    }
}
