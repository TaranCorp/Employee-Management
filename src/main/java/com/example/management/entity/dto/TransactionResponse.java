package com.example.management.entity.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionResponse {
    private Long id;
    private LocalDateTime created;
    private Double amount;
    private Long employee_id;
}
