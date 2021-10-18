package com.example.management.entity.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionRequest {
    private Long id;
    private Double amount;
    private Long employee_id;
}
