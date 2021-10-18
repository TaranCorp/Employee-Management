package com.example.management.entity.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountRequest {
    private String login;
    private String password;
    private String email;
}
