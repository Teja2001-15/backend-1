package com.savings.user_service.repository;

import com.savings.userservice.model.SchemeDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SchemeRepository extends MongoRepository<SchemeDTO, String> {
}
