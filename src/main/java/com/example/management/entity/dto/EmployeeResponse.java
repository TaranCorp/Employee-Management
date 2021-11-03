package com.example.management.entity.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeResponse {
    private Long id;
    private String name;
    private String surname;
    private String phoneNumber;
    private Date birthDate;
    private Date employmentDate;
    private String position;
    private Double payment;
}
