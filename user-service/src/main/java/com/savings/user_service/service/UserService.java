package com.savings.user_service.service;

import com.savings.user_service.model.UserDTO;
import com.savings.user_service.model.SchemeDTO;
import com.savings.user_service.repository.UserRepository;
import com.savings.user_service.repository.SchemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SchemeRepository schemeRepository;

    // Get User Profile
    public ResponseEntity<?> getUserProfile(String userId) {
        Optional<UserDTO> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }

    // Get Schemes available to the User
    public ResponseEntity<List<SchemeDTO>> getUserSchemes(String userId) {
        List<SchemeDTO> schemes = schemeRepository.findAll();
        return ResponseEntity.ok(schemes);
    }

    // User applies to a Scheme
    public ResponseEntity<?> applyToScheme(String userId, String schemeId) {
        Optional<UserDTO> user = userRepository.findById(userId);
        Optional<SchemeDTO> scheme = schemeRepository.findById(schemeId);

        if (!user.isPresent()) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }

        if (!scheme.isPresent()) {
            return new ResponseEntity<>("Scheme not found", HttpStatus.NOT_FOUND);
        }

        // Add logic to associate the user with the scheme (e.g., add user to scheme's participants list)
        // For simplicity, this example doesn't modify scheme data, but in real implementation, you'd update it

        return ResponseEntity.ok("User applied to scheme successfully");
    }
}
