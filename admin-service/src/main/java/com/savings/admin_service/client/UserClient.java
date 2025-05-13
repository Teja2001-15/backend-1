package com.savings.admin_service.client;

import com.savings.admin_service.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "user-service")
public interface UserClient {

    @GetMapping("/users")
    List<UserDTO> getAllUsers();

    @PutMapping("/users/{id}/role")
    UserDTO updateUserRole(@PathVariable String id, @RequestParam String role);
}
