package com.example.hpjtrackerbackend.service;

import com.example.hpjtrackerbackend.dto.Task;
import com.example.hpjtrackerbackend.dto.TaskView;
import com.example.hpjtrackerbackend.repository.TaskRepository;
import com.example.hpjtrackerbackend.repository.TaskViewRepository;
import com.example.hpjtrackerbackend.util.Util;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TaskService {

    @NonNull
    private final TaskRepository taskRepository;
    @NonNull
    private final TaskViewRepository taskViewRepository;

    private final Util util = new Util();

    public List<TaskView> getTasks() {
        return taskViewRepository.findAll();
    }

    public Task postPutTask(Task task, RequestMethod requestMethod) throws Exception {
        util.validateForPostAndPut(
                Collections.singletonList(taskRepository.findAllByName(task.getName())),
                requestMethod
        );

        return taskRepository.save(task);
    }
}
