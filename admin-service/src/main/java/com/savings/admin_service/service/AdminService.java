package com.savings.admin_service.service;

import com.savings.admin_service.client.GroupClient;
import com.savings.admin_service.client.UserClient;
import com.savings.admin_service.dto.GroupDTO;
import com.savings.admin_service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private UserClient userClient;

    @Autowired
    private GroupClient groupClient;

    public List<UserDTO> getAllUsers() {
        return userClient.getAllUsers();
    }

    public List<GroupDTO> getAllGroups() {
        return groupClient.getAllGroups();
    }

    public GroupDTO approveGroup(String groupId, boolean approved) {
        return groupClient.approveGroup(groupId, approved);
    }

    public UserDTO promoteUserToGroupAdmin(String userId) {
        return userClient.updateUserRole(userId, "GROUP_ADMIN");
    }
}
