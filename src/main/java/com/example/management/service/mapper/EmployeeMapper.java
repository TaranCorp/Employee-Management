package com.example.management.service.mapper;

import com.example.management.entity.Employee;
import com.example.management.entity.dto.EmployeeRequest;
import com.example.management.entity.dto.EmployeeResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeMapper {

    public Employee mapToEmployee(EmployeeRequest employeeRequest) {
        return Employee.builder()
                .name(employeeRequest.getName())
                .surname(employeeRequest.getSurname())
                .employmentDate(employeeRequest.getEmploymentDate())
                .birthDate(employeeRequest.getBirthDate())
                .phoneNumber(employeeRequest.getPhoneNumber())
                .position(employeeRequest.getPosition())
                .build();
    }

    public List<EmployeeRequest> mapToEmployeesRequests(List<Employee> employeeList) {
        return employeeList.stream()
                .map(this::mapToEmployeeRequest)
                .collect(Collectors.toList());
    }

    public List<EmployeeResponse> mapToEmployeesResponses(List<Employee> employeeList) {
        return employeeList.stream()
                .map(this::mapToEmployeeResponse)
                .collect(Collectors.toList());
    }

    public EmployeeRequest mapToEmployeeRequest(Employee employee) {
        return EmployeeRequest.builder()
                .name(employee.getName())
                .surname(employee.getSurname())
                .employmentDate(employee.getEmploymentDate())
                .birthDate(employee.getBirthDate())
                .phoneNumber(employee.getPhoneNumber())
                .position(employee.getPosition())
                .payment(employee.getPayment())
                .build();
    }

    public EmployeeResponse mapToEmployeeResponse(Employee employee) {
        return EmployeeResponse.builder()
                .id(employee.getId())
                .name(employee.getName())
                .surname(employee.getSurname())
                .employmentDate(employee.getEmploymentDate())
                .birthDate(employee.getBirthDate())
                .phoneNumber(employee.getPhoneNumber())
                .position(employee.getPosition())
                .payment(employee.getPayment())
                .build();
    }
}
