package com.example.management.entity;

import liquibase.pro.packaged.C;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "created")
    private LocalDateTime created;
    @ManyToMany(mappedBy = "taskList", cascade = CascadeType.ALL)
    private List<Employee> employeeList;
}
