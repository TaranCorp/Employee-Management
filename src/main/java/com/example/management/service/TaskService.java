package com.example.management.service;

import com.example.management.entity.Employee;
import com.example.management.entity.Task;
import com.example.management.entity.Transaction;
import com.example.management.entity.dto.TaskRequest;
import com.example.management.entity.dto.TaskResponse;
import com.example.management.repository.EmployeeRepository;
import com.example.management.repository.TaskRepository;
import com.example.management.service.mapper.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final EmployeeRepository employeeRepository;
    private final TaskMapper taskMapper;

    public List<TaskResponse> getTasks() {
        return taskMapper.mapToTaskResponses(taskRepository.findAll());
    }

    public TaskResponse addTask(TaskRequest taskRequest) {
        return taskMapper.mapToTaskResponse(
                taskRepository.save(
                        taskMapper.mapToTask(
                                taskRequest
                        ))
        );
    }

    public void setEmployeeToTask(Long taskId, Long employeeId) {
        Task task = taskRepository.getById(taskId);
        Employee employee = employeeRepository.getById(employeeId);
        employee.addTask(task);
        employeeRepository.save(employee);
    }
}
