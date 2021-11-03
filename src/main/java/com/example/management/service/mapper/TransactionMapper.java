package com.example.management.service.mapper;

import com.example.management.entity.Transaction;
import com.example.management.entity.dto.TransactionRequest;
import com.example.management.entity.dto.TransactionResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TransactionMapper {

    public Transaction mapToTransaction(TransactionRequest transactionRequest) {
        return Transaction.builder()
                .employee_id(transactionRequest.getEmployee_id())
                .amount(transactionRequest.getAmount())
                .build();
    }

    public List<TransactionRequest> mapToTransactionRequests(List<Transaction> transactionList) {
        return transactionList.stream()
                .map(this::mapToTransactionRequest)
                .collect(Collectors.toList());
    }

    public TransactionRequest mapToTransactionRequest(Transaction transaction) {
        return TransactionRequest.builder()
                .employee_id(transaction.getEmployee_id())
                .amount(transaction.getAmount())
                .build();
    }

    public List<TransactionResponse> mapToTransactionResponses(List<Transaction> transactionList) {
        return transactionList.stream()
                .map(this::mapToTransactionResponse)
                .collect(Collectors.toList());
    }

    public TransactionResponse mapToTransactionResponse(Transaction transaction) {
        return TransactionResponse.builder()
                .id(transaction.getId())
                .created(transaction.getCreated())
                .amount(transaction.getAmount())
                .build();
    }
}
