package com.example.management.controller;

import com.example.management.entity.dto.TaskRequest;
import com.example.management.entity.dto.TaskResponse;
import com.example.management.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping(value = "api/task")
    public ResponseEntity<List<TaskResponse>> getTasks() {
        return new ResponseEntity<>(taskService.getTasks(), HttpStatus.OK);
    }

    @PostMapping(value = "api/task")
    public ResponseEntity<TaskResponse> addTask(@RequestBody TaskRequest taskRequest) {
        return new ResponseEntity<>(taskService.addTask(taskRequest), HttpStatus.CREATED);
    }

    @PutMapping(value = "api/task")
    public ResponseEntity setEmployeeToTask(@RequestParam Long taskId, @RequestParam Long employeeId) {
        taskService.setEmployeeToTask(taskId, employeeId);
        return new ResponseEntity(HttpStatus.OK);
    }

    static double add(int a, double b) {
        return a + b;
    }

}
