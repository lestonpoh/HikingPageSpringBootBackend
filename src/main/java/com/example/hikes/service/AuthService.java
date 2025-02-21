package com.example.hikes.service;

import com.example.hikes.dto.request.auth.CreateUserRequestDTO;
import com.example.hikes.dto.request.auth.LoginRequestDTO;
import com.example.hikes.dto.service.LoginServiceDTO;
import com.example.hikes.exception.BadRequestException;
import com.example.hikes.exception.NotFoundException;
import com.example.hikes.exception.UnauthorizedException;
import com.example.hikes.mapper.UserMapper;
import com.example.hikes.model.User;
import com.example.hikes.repository.UserRepository;
import com.example.hikes.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    public void createUser(CreateUserRequestDTO createUserRequestDTO){
        if(userRepository.existsByUsername(createUserRequestDTO.getUsername())){
            throw new BadRequestException("Username already exist.");
        }

        if (userRepository.existsByEmail(createUserRequestDTO.getEmail())){
            throw new BadRequestException("Email already exist.");
        }

        User user = userMapper.toDocument(createUserRequestDTO);
        userRepository.insert(user);

    }

    public LoginServiceDTO Login(LoginRequestDTO loginRequestDTO){
        if(!userRepository.existsByEmail(loginRequestDTO.getEmail())){
            throw new NotFoundException("User not found.");
        }

        User user = userRepository.findByEmail(loginRequestDTO.getEmail());
        if (encoder.matches(loginRequestDTO.getPassword(), user.getPassword())){
            return new LoginServiceDTO(
                    userMapper.toLoginResponseDTO(user),
                    jwtTokenUtil.createToken(user.getId().toString())
            );
        } else{
            throw new UnauthorizedException("Invalid password.");
        }
    }
}
