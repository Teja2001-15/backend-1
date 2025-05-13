package com.savings.admin_service.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupDTO {
    private String id;
    private String name;
    private String ownerId;
    private boolean approved;
}
