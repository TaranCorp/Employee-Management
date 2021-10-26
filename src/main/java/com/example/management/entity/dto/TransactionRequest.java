package com.example.management.entity.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionRequest {
    private Double amount;
    private Long employee_id;
}
