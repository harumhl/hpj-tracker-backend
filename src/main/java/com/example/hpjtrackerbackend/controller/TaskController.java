package com.example.hpjtrackerbackend.controller;

import com.example.hpjtrackerbackend.HpjException;
import com.example.hpjtrackerbackend.dto.Task;
import com.example.hpjtrackerbackend.dto.TaskView;
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
    public List<TaskView> getTasks() {
        return taskService.getTasks();
    }

    @PostMapping("")
    public Task postTask(@RequestBody Task task) throws HpjException {
        return taskService.postPutTask(task, RequestMethod.POST);
    }

    @PutMapping("")
    public Task putTask(@RequestBody Task task) throws HpjException {
        return taskService.postPutTask(task, RequestMethod.PUT);
    }
}
