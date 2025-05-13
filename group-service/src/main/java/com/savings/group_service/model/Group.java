package com.savings.group_service.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "groups")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Group {
    @Id
    private String id;
    private String name;
    private String description;
    private String schemeId;
    private String groupAdminId;
    private List<String> memberIds;
}
