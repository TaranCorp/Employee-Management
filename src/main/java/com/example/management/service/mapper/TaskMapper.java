package com.example.management.service.mapper;

import com.example.management.entity.Task;
import com.example.management.entity.dto.TaskRequest;
import com.example.management.entity.dto.TaskResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TaskMapper {

    private final EmployeeMapper employeeMapper;

    public TaskResponse mapToTaskResponse(Task task) {
        return TaskResponse.builder()
                .id(task.getId())
                .name(task.getName())
                .created(task.getCreated())
//                .employeeResponseList(
//                        employeeMapper.mapToEmployeesResponses(
//                        task.getEmployeeList()
//                ))
                .build();
    }

    public List<TaskResponse> mapToTaskResponses (List<Task> taskList) {
        return taskList.stream()
                .map(this::mapToTaskResponse)
                .collect(Collectors.toList());
    }

    public Task mapToTask(TaskRequest taskRequest) {
        return Task.builder()
                .name(taskRequest.getName())
                .build();
    }
}
