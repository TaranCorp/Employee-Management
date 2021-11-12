package com.example.management.controller;

import com.example.management.entity.dto.AccountResponse;
import com.example.management.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.management.entity.dto.AccountRequest;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping(value = "api/account")
    public ResponseEntity<List<AccountResponse>> getAccounts() {
        return new ResponseEntity<>(accountService.getAccounts(), HttpStatus.OK);
    }

    @PostMapping(value = "api/account")
    public ResponseEntity<Void> addAccount(@RequestBody AccountRequest accountRequest) {
        accountService.addAccount(accountRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "api/account")
    public void setEmployee(@RequestParam Long idEmployee, @RequestParam Long idAccount) {
        accountService.setEmployee(idEmployee, idAccount);
    }

    @DeleteMapping(value = "api/account")
    public ResponseEntity deleteAccount(@RequestParam Long id) {
        if(Objects.isNull(id)){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        accountService.deleteAccount(id);
        return new ResponseEntity(HttpStatus.OK);

    }
}
