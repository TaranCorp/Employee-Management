package com.example.management.controller;

import com.example.management.entity.Employee;
import com.example.management.entity.dto.EmployeeResponse;
import com.example.management.service.EmployeeService;
import com.example.management.entity.dto.EmployeeRequest;
import com.example.management.entity.dto.TransactionRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping(value = "api/employee")
    public ResponseEntity<List<EmployeeResponse>> getEmployees(@PathVariable(required = false) Integer page) {
        final List<EmployeeResponse> employeeList = employeeService.getEmployees(page);
        return new ResponseEntity<>(employeeList, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "api/employee/{id}")
    public ResponseEntity<EmployeeRequest> getEmployeeById(@PathVariable Long id) {
        final EmployeeRequest employeeRequest = employeeService.getEmployeeRequestById(id);
        return new ResponseEntity<>(employeeRequest, HttpStatus.OK);
    }

    @GetMapping(value = "api/employee/transactions")
    public ResponseEntity<List<TransactionRequest>> getTransactions(@RequestParam Long id) {
        return new ResponseEntity<>(employeeService.getTransactions(id), HttpStatus.OK);
    }

    @PostMapping(value = "api/employee")
    public ResponseEntity<EmployeeRequest> addEmployee(@RequestBody EmployeeRequest employeeRequest) {
        employeeService.addEmployee(employeeRequest);
        return new ResponseEntity<>(employeeRequest, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "api/employee/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

    @PutMapping(value = "api/employee/{id}")
    public ResponseEntity<EmployeeResponse> editEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.editEmployee(employee), HttpStatus.ACCEPTED);
    }
}
