package com.example.hpjtrackerbackend.service;

import com.example.hpjtrackerbackend.HpjException;
import com.example.hpjtrackerbackend.dto.request.Task;
import com.example.hpjtrackerbackend.dto.response.TaskResponse;
import com.example.hpjtrackerbackend.repository.TaskRepository;
import com.example.hpjtrackerbackend.repository.TaskResponseRepository;
import com.example.hpjtrackerbackend.util.Util;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TaskService {

    @NonNull
    private final TaskRepository taskRepository;
    @NonNull
    private final TaskResponseRepository taskResponseRepository;

    private final Util util = new Util();

    public List<TaskResponse> getTasks() {
        return taskResponseRepository.findAll();
    }

    public TaskResponse postPutTask(Task task, RequestMethod requestMethod) throws HpjException {
        util.validateForPostAndPut(taskResponseRepository.findAllByName(task.getName()).size(), requestMethod);
        task = taskRepository.saveAndFlush(task);
        return taskResponseRepository.findById(task.getId()).get();
    }
}
