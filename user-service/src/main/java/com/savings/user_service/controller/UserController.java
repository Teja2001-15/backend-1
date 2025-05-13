package com.savings.user_service.controller;

import com.savings.user_service.model.UserDTO;
import com.savings.user_service.model.SchemeDTO;
import com.savings.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Get User Profile by ID
    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserProfile(@PathVariable String userId) {
        return userService.getUserProfile(userId);
    }

    // Get Schemes available to the user
    @GetMapping("/{userId}/schemes")
    public ResponseEntity<List<SchemeDTO>> getUserSchemes(@PathVariable String userId) {
        return userService.getUserSchemes(userId);
    }

    // User applies to a Scheme
    @PostMapping("/{userId}/apply/{schemeId}")
    public ResponseEntity<?> applyToScheme(@PathVariable String userId, @PathVariable String schemeId) {
        return userService.applyToScheme(userId, schemeId);
    }
}
