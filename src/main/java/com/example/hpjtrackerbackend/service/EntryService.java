package com.example.hpjtrackerbackend.service;

import com.example.hpjtrackerbackend.HpjException;
import com.example.hpjtrackerbackend.dto.Entry;
import com.example.hpjtrackerbackend.dto.Task;
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

    public List<Entry> getEntries() {
        return entryRepository.findAll();
    }

    public List<Entry> getEntriesOfToday() {
        return entryRepository.findAllByDoneDate(util.getToday());
    }

    public Entry postPutEntry(Entry entry, RequestMethod requestMethod) throws HpjException {
        util.validateForPostAndPut(entryRepository.findAllByName(entry.getName()).size(), requestMethod);

        return entryRepository.save(entry);
    }

    public List<Entry> postEntriesOfToday() {
        List<Task> tasksOfToday = taskRepository.findAll();
        List<Entry> existingEntriesOfToday = getEntriesOfToday();
        List<Entry> entriesOfToday = new ArrayList<>();
        for (Task taskOfToday : tasksOfToday) {
            // Skip if it already exists in the db
            if (existingEntriesOfToday.stream().anyMatch(e -> e.getName().equals(taskOfToday.getName()))) {
                continue;
            }

            Entry entryOfToday = new Entry();
            entryOfToday.setDoneDate(util.getToday());
            entryOfToday.setName(taskOfToday.getName());
            entryOfToday.setCount((double) 0);
            entryOfToday.setHide(false);
            entryOfToday.setGoalCount(taskOfToday.getGoalCount());
            entryOfToday.setMaxCount(taskOfToday.getMaxCount());
            entryOfToday.setMultiplier(taskOfToday.getMultiplier());
            entryOfToday.setTask(taskOfToday);
            entriesOfToday.add(entryOfToday);
        }
        return entryRepository.saveAll(entriesOfToday);
    }
}
