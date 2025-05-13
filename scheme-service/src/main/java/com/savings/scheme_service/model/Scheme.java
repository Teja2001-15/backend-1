package com.savings.scheme_service.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "schemes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Scheme {
    @Id
    private String id;
    private String name;
    private String description;
    private double interestRate;
    private String eligibility;
    private String type; // "saving" or "loan"
}
