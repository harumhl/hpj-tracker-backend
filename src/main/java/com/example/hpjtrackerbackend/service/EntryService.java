package com.example.hpjtrackerbackend.service;

import com.example.hpjtrackerbackend.HpjException;
import com.example.hpjtrackerbackend.dto.request.Entry;
import com.example.hpjtrackerbackend.dto.response.EntryResponse;
import com.example.hpjtrackerbackend.dto.response.TaskResponse;
import com.example.hpjtrackerbackend.repository.EntryRepository;
import com.example.hpjtrackerbackend.repository.EntryResponseRepository;
import com.example.hpjtrackerbackend.repository.TaskResponseRepository;
import com.example.hpjtrackerbackend.util.Util;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EntryService {

    @NonNull
    private final TaskResponseRepository taskResponseRepository;
    @NonNull
    private final EntryRepository entryRepository;
    @NonNull
    private final EntryResponseRepository entryResponseRepository;

    private final Util util = new Util();

    public List<EntryResponse> getEntries() {
        return entryResponseRepository.findAll();
    }

    public List<EntryResponse> getEntriesOfToday() {
        return entryResponseRepository.findAllByDoneDate(util.getToday());
    }

    public EntryResponse postPutEntry(Entry entry, RequestMethod requestMethod) throws HpjException {
        util.validateForPostAndPut(entryRepository.findAllByName(entry.getName()).size(), requestMethod);
        entry = entryRepository.save(entry);
        return entryResponseRepository.findById(entry.getId()).get();
    }

    public List<EntryResponse> postEntriesOfToday() {
        List<TaskResponse> tasksOfToday = taskResponseRepository.findAllByArchivedIsFalse();
        List<EntryResponse> existingEntriesOfToday = getEntriesOfToday();
        List<Entry> entriesOfToday = new ArrayList<>();
        for (TaskResponse taskResponseOfToday : tasksOfToday) {
            // Skip if it already exists in the db
            if (existingEntriesOfToday.stream().anyMatch(e -> e.getName().equals(taskResponseOfToday.getName()))) {
                continue;
            }

            Entry entryResponseOfToday = new Entry();
            entryResponseOfToday.setDoneDate(util.getToday());
            entryResponseOfToday.setName(taskResponseOfToday.getName());
            entryResponseOfToday.setCount((double) 0);
            entryResponseOfToday.setHide(false);
            entryResponseOfToday.setGoalCount(taskResponseOfToday.getGoalCount());
            entryResponseOfToday.setMaxCount(taskResponseOfToday.getMaxCount());
            entryResponseOfToday.setMultiplier(taskResponseOfToday.getMultiplier());
            entryResponseOfToday.setTaskId(taskResponseOfToday.getId());
            entriesOfToday.add(entryResponseOfToday);
        }
        entriesOfToday = entryRepository.saveAll(entriesOfToday);
        List<Long> ids = entriesOfToday.stream().map(Entry::getId).collect(Collectors.toList());
        return entryResponseRepository.findAllById(ids);
    }
}
