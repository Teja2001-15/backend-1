package com.savings.scheme_service.repository;

import com.savings.scheme_service.model.Scheme;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SchemeRepository extends MongoRepository<Scheme, String> {
}
