package com.example.management.service;

import com.example.management.entity.Employee;
import com.example.management.entity.Transaction;
import com.example.management.entity.dto.EmployeeResponse;
import com.example.management.entity.dto.TransactionResponse;
import com.example.management.repository.EmployeeRepository;
import com.example.management.entity.dto.TransactionRequest;
import com.example.management.service.mapper.EmployeeMapper;
import com.example.management.entity.dto.EmployeeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final TransactionService transactionService;
    final Integer SIZE  = 10;

    public List<EmployeeResponse> getEmployees(Integer page) {
        if(Objects.isNull(page)) {
            page = 0;
        }
        Page<Employee> employeePage = employeeRepository.findAll(PageRequest.of(page, SIZE));
        List<Employee> employeeList = employeePage.stream()
                .collect(Collectors.toList());
        return employeeMapper.mapToEmployeesResponses(employeeList);
    }

    public List<TransactionResponse> getTransactions(final Long id) {
        List<Long> ids = employeeRepository.findById(id)
                .get()
                .getTransactionList().stream()
                .map(Transaction::getId)
                .collect(Collectors.toList());

        return transactionService.getTransactions(ids);
    }

    public Employee addEmployee(EmployeeRequest employeeRequest) {

        String name = employeeRequest.getName();
        name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
        employeeRequest.setName(name);

        String surname = employeeRequest.getSurname();
        surname = surname.substring(0,1).toUpperCase() + surname.substring(1).toLowerCase();
        employeeRequest.setSurname(surname);

        return employeeRepository.save(employeeMapper.mapToEmployee(employeeRequest)) ;
    }

    public EmployeeResponse getEmployeeResponseById(Long id) {
        final Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Employee with id " + id + " not found")
        );
        return new EmployeeMapper().mapToEmployeeResponse(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public EmployeeResponse editEmployee(EmployeeResponse employeeResponse) {
        return employeeMapper.mapToEmployeeResponse(
                employeeRepository.saveAndFlush(
                        employeeMapper.mapToEmployee(
                                employeeResponse
                        )));
    }
}
