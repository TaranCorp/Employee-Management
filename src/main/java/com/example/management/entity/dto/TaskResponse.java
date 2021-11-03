package com.example.management.entity.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskResponse {
    private Long id;
    private String name;
    private LocalDateTime created;
    //private List<EmployeeResponse> employeeResponseList  = new ArrayList<>();
}
