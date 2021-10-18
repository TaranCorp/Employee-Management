package com.example.management.service.mapper;

import com.example.management.entity.Transaction;
import com.example.management.entity.dto.TransactionRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TransactionMapper {

    public Transaction mapToTransaction(TransactionRequest transactionRequest) {
        return Transaction.builder()
                .id(transactionRequest.getId())
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
                .id(transaction.getId())
                .amount(transaction.getAmount())
                .build();
    }
}
