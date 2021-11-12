package com.example.management.service;

import com.example.management.entity.Account;
import com.example.management.entity.dto.AccountResponse;
import com.example.management.repository.AccountRepository;
import com.example.management.service.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.management.entity.dto.AccountRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    private final EmployeeService employeeService;

    public void addAccount(AccountRequest accountRequest) {
        accountRequest.setEmail(accountRequest.getEmail().toLowerCase());
        accountRepository.save(accountMapper.mapToAccount(accountRequest));
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

    public void setEmployee(Long idEmployee, Long idAccount) {
        employeeService.getEmployeeResponseById(idEmployee);
        this.getAccountDtoById(idAccount);
        accountRepository.setEmployeeId(idEmployee, idAccount);
    }

    public AccountResponse getAccountDtoById(final Long id) {
        final Account account = accountRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Account with id " + id + " not found")
        );
        return accountMapper.mapToAccountResponse(account);
    }

    public List<AccountResponse> getAccounts() {
        return accountMapper.mapToAccountResponses(accountRepository.findAll());
    }
}
