package com.example.hpjtrackerbackend.controller;

import com.example.hpjtrackerbackend.HpjException;
import com.example.hpjtrackerbackend.dto.response.TaskResponse;
import com.example.hpjtrackerbackend.service.TaskService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("tasks")
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TaskController {

    @NonNull
    private final TaskService taskService;

    @GetMapping("")
    public List<TaskResponse> getTasks() {
        return taskService.getTasks();
    }

    @PostMapping("")
    public TaskResponse postTask(@RequestBody TaskResponse taskResponse) throws HpjException {
        return taskService.postPutTask(taskResponse, RequestMethod.POST);
    }

    @PutMapping("")
    public TaskResponse putTask(@RequestBody TaskResponse taskResponse) throws HpjException {
        return taskService.postPutTask(taskResponse, RequestMethod.PUT);
    }
}
