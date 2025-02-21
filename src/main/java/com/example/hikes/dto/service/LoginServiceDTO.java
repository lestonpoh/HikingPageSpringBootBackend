package com.example.hikes.dto.service;

import com.example.hikes.dto.response.auth.LoginResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginServiceDTO {
    LoginResponseDTO loginResponseDTO;
    private String token;
}
