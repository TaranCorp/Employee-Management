package com.example.management.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", insertable = false)
    private Employee employee;
}
