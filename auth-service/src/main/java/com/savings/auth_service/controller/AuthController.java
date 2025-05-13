package com.savings.auth_service.controller;

import com.savings.auth_service.model.UserLoginDTO;
import com.savings.auth_service.service.AuthService;
import com.savings.auth_service.util.JwtUtil;
import com.savings.auth_service.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtUtil jwtUtil;

    // Register a new user
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO) {
        return authService.register(userDTO);
    }

    // User login (returns JWT token)
    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody UserLoginDTO userDTO) {
        return authService.authenticate(userDTO);
    }

    // Validate JWT token
    @GetMapping("/validate")
    public ResponseEntity<?> validateToken(@RequestHeader("Authorization") String token) {
        return authService.validateToken(token);
    }
}
