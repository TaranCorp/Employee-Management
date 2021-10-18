package com.example.management.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeRequest {
    private String name;
    private String surname;
    private String phoneNumber;
    private Date birthDate;
    private Date employmentDate;
    private String position;
}
