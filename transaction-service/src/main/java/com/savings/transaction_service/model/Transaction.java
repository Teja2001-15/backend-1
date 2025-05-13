package com.savings.transaction_service.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "transactions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {

    @Id
    private String id;
    private String userId;
    private String groupId;
    private double amount;
    private TransactionType type; // DEPOSIT, WITHDRAWAL, TRANSFER
    private String description;
    private LocalDateTime timestamp;
}
