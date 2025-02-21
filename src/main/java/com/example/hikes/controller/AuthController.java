package com.example.hikes.controller;


import com.example.hikes.dto.request.auth.CreateUserRequestDTO;
import com.example.hikes.dto.request.auth.LoginRequestDTO;
import com.example.hikes.dto.response.auth.LoginResponseDTO;
import com.example.hikes.dto.service.LoginServiceDTO;
import com.example.hikes.service.AuthService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody @Valid CreateUserRequestDTO createUserRequestDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Validation failed");
        }
        authService.createUser(createUserRequestDTO);
        return ResponseEntity.ok().body("User successfully created!");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequestDTO loginRequestDTO, BindingResult bindingResult, HttpServletResponse response){
        if (bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body("Validation failed");
        }
        LoginServiceDTO loginServiceDTO = authService.Login(loginRequestDTO);
        Cookie cookie = new Cookie("accessToken", loginServiceDTO.getToken());
        cookie.setPath("/");
        response.addCookie(cookie);

        return ResponseEntity.ok().body(loginServiceDTO.getLoginResponseDTO());
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletResponse response){
        Cookie cookie = new Cookie("accessToken", null);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        return ResponseEntity.ok("Logged out successfully.");
    }
}
