package com.savings.admin_service.controller;

import com.savings.admin_service.dto.GroupDTO;
import com.savings.admin_service.dto.UserDTO;
import com.savings.admin_service.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(adminService.getAllUsers());
    }

    @GetMapping("/groups")
    public ResponseEntity<List<GroupDTO>> getAllGroups() {
        return ResponseEntity.ok(adminService.getAllGroups());
    }

    @PutMapping("/groups/{id}/approve")
    public ResponseEntity<GroupDTO> approveGroup(@PathVariable String id, @RequestParam boolean approved) {
        return ResponseEntity.ok(adminService.approveGroup(id, approved));
    }

    @PutMapping("/users/{id}/promote")
    public ResponseEntity<UserDTO> promoteToAdmin(@PathVariable String id) {
        return ResponseEntity.ok(adminService.promoteUserToGroupAdmin(id));
    }
}
