package com.example.management.service.mapper;

import com.example.management.entity.Account;
import com.example.management.entity.dto.AccountRequest;
import com.example.management.entity.dto.AccountResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AccountMapper {

    private final EmployeeMapper employeeMapper;

    public Account mapToAccount (AccountRequest accountRequest){
        return Account.builder()
                .login(accountRequest.getLogin())
                .email(accountRequest.getEmail())
                .password(accountRequest.getPassword())
                .email(accountRequest.getEmail())
                .build();
    }

    public List<AccountResponse> mapToAccountResponses(List<Account> accounts) {
        return accounts.stream()
                .map(this::mapToAccountResponse)
                .collect(Collectors.toList());
    }

    public AccountResponse mapToAccountResponse(Account account){
        return AccountResponse.builder()
                .id(account.getId())
                .login(account.getLogin())
                .password(account.getPassword())
                .email(account.getEmail())
                .build();
    }
}
