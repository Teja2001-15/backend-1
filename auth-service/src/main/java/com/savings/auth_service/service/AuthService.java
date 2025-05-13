package com.savings.authservice.service;

import com.savings.auth_service.model.UserDTO;
import com.savings.auth_service.model.UserLoginDTO;
import com.savings.auth_service.repository.UserRepository;
import com.savings.auth_service.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Register user and save to the database
    public ResponseEntity<?> register(UserDTO userDTO) {
        if (userRepository.existsByUsername(userDTO.getUsername())) {
            return new ResponseEntity<>("User already exists!", HttpStatus.BAD_REQUEST);
        }
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userRepository.save(userDTO);
        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
    }

    // Authenticate user and return JWT token
    public ResponseEntity<?> authenticate(UserLoginDTO userDTO) {
        UserDTO existingUser = userRepository.findByUsername(userDTO.getUsername());
        if (existingUser == null || !passwordEncoder.matches(userDTO.getPassword(), existingUser.getPassword())) {
            return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
        }
        String token = jwtUtil.generateToken(userDTO.getUsername());
        return ResponseEntity.ok("Bearer " + token);
    }

    // Validate JWT token
    public ResponseEntity<?> validateToken(String token) {
        if (jwtUtil.validateToken(token)) {
            String username = jwtUtil.extractUsername(token);
            return ResponseEntity.ok("Token is valid for user: " + username);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
    }
}
