package com.example.management.service;

import com.example.management.entity.dto.TransactionResponse;
import com.example.management.repository.TransactionRepository;
import com.example.management.entity.dto.TransactionRequest;
import com.example.management.service.mapper.TransactionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    public List<TransactionResponse> getTransactions (List<Long> id) {
        return transactionMapper.mapToTransactionResponses(transactionRepository.findAllById(id));
    }

    public void addTransaction(TransactionRequest transactionRequest) {
        transactionRepository.save(transactionMapper.mapToTransaction(transactionRequest));
    }
}
