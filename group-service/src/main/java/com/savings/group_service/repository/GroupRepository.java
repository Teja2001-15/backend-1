package com.savings.group_service.repository;

import com.savings.group_service.model.Group;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface GroupRepository extends MongoRepository<Group, String> {
    List<Group> findByGroupAdminId(String groupAdminId);
    List<Group> findByMemberIdsContaining(String userId);
}
