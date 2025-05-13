package com.savings.user_service.repository;

import com.savings.userservice.model.UserDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserDTO, String> {
}
