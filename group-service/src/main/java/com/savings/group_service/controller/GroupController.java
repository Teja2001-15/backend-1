package com.savings.group_service.controller;

import com.savings.group_service.model.Group;
import com.savings.group_service.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @PostMapping
    public ResponseEntity<Group> createGroup(@RequestBody Group group) {
        return ResponseEntity.ok(groupService.createGroup(group));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Group> getGroupById(@PathVariable String id) {
        return groupService.getGroupById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/admin/{adminId}")
    public ResponseEntity<List<Group>> getGroupsByAdmin(@PathVariable String adminId) {
        return ResponseEntity.ok(groupService.getGroupsByAdmin(adminId));
    }

    @GetMapping("/member/{memberId}")
    public ResponseEntity<List<Group>> getGroupsByMember(@PathVariable String memberId) {
        return ResponseEntity.ok(groupService.getGroupsByMember(memberId));
    }

    @PutMapping("/{groupId}/add-member/{memberId}")
    public ResponseEntity<Group> addMember(@PathVariable String groupId, @PathVariable String memberId) {
        return ResponseEntity.ok(groupService.addMember(groupId, memberId));
    }

    @DeleteMapping("/{groupId}")
    public ResponseEntity<Void> deleteGroup(@PathVariable String groupId) {
        groupService.deleteGroup(groupId);
        return ResponseEntity.noContent().build();
    }
}
