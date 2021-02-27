package com.example.hpjtrackerbackend.service;

import com.example.hpjtrackerbackend.HpjException;
import com.example.hpjtrackerbackend.dto.response.EntryResponse;
import com.example.hpjtrackerbackend.dto.response.TaskResponse;
import com.example.hpjtrackerbackend.repository.EntryRepository;
import com.example.hpjtrackerbackend.repository.TaskRepository;
import com.example.hpjtrackerbackend.util.Util;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EntryService {

    @NonNull
    private final TaskRepository taskRepository;
    @NonNull
    private final EntryRepository entryRepository;

    private final Util util = new Util();

    public List<EntryResponse> getEntries() {
        return entryRepository.findAll();
    }

    public List<EntryResponse> getEntriesOfToday() {
        return entryRepository.findAllByDoneDate(util.getToday());
    }

    public EntryResponse postPutEntry(EntryResponse entryResponse, RequestMethod requestMethod) throws HpjException {
        util.validateForPostAndPut(entryRepository.findAllByName(entryResponse.getName()).size(), requestMethod);

        return entryRepository.save(entryResponse);
    }

    public List<EntryResponse> postEntriesOfToday() {
        List<TaskResponse> tasksOfToday = taskRepository.findAll();
        List<EntryResponse> existingEntriesOfToday = getEntriesOfToday();
        List<EntryResponse> entriesOfToday = new ArrayList<>();
        for (TaskResponse taskResponseOfToday : tasksOfToday) {
            // Skip if it already exists in the db
            if (existingEntriesOfToday.stream().anyMatch(e -> e.getName().equals(taskResponseOfToday.getName()))) {
                continue;
            }

            EntryResponse entryResponseOfToday = new EntryResponse();
            entryResponseOfToday.setDoneDate(util.getToday());
            entryResponseOfToday.setName(taskResponseOfToday.getName());
            entryResponseOfToday.setCount((double) 0);
            entryResponseOfToday.setHide(false);
            entryResponseOfToday.setGoalCount(taskResponseOfToday.getGoalCount());
            entryResponseOfToday.setMaxCount(taskResponseOfToday.getMaxCount());
            entryResponseOfToday.setMultiplier(taskResponseOfToday.getMultiplier());
            entryResponseOfToday.setTaskResponse(taskResponseOfToday);
            entriesOfToday.add(entryResponseOfToday);
        }
        return entryRepository.saveAll(entriesOfToday);
    }
}
