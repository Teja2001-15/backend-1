package com.savings.admin_service.client;

import com.savings.admin_service.dto.GroupDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "group-service")
public interface GroupClient {

    @GetMapping("/groups")
    List<GroupDTO> getAllGroups();

    @PutMapping("/groups/{id}/approve")
    GroupDTO approveGroup(@PathVariable String id, @RequestParam boolean approved);
}
