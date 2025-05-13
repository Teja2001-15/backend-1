package com.savings.auth_service.repository;

import com.savings.auth_service.model.UserDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserDTO, String> {
    boolean existsByUsername(String username);
    UserDTO findByUsername(String username);
}
