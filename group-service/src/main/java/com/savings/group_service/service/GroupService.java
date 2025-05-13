package com.savings.group_service.service;

import com.savings.group_service.model.Group;
import com.savings.group_service.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    public Group createGroup(Group group) {
        return groupRepository.save(group);
    }

    public Optional<Group> getGroupById(String groupId) {
        return groupRepository.findById(groupId);
    }

    public List<Group> getGroupsByAdmin(String adminId) {
        return groupRepository.findByGroupAdminId(adminId);
    }

    public List<Group> getGroupsByMember(String memberId) {
        return groupRepository.findByMemberIdsContaining(memberId);
    }

    public Group addMember(String groupId, String memberId) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Group not found"));
        if (!group.getMemberIds().contains(memberId)) {
            group.getMemberIds().add(memberId);
        }
        return groupRepository.save(group);
    }

    public void deleteGroup(String groupId) {
        groupRepository.deleteById(groupId);
    }
}
