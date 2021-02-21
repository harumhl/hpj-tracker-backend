package com.example.hpjtrackerbackend.service;

import com.example.hpjtrackerbackend.HpjException;
import com.example.hpjtrackerbackend.dto.Entry;
import com.example.hpjtrackerbackend.dto.EntryView;
import com.example.hpjtrackerbackend.dto.Task;
import com.example.hpjtrackerbackend.repository.EntryRepository;
import com.example.hpjtrackerbackend.repository.EntryViewRepository;
import com.example.hpjtrackerbackend.repository.TaskRepository;
import com.example.hpjtrackerbackend.repository.TaskViewRepository;
import com.example.hpjtrackerbackend.util.Util;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EntryService {

    @NonNull
    private final TaskRepository taskRepository;
    @NonNull
    private final TaskViewRepository taskViewRepository;
    @NonNull
    private final EntryRepository entryRepository;
    @NonNull
    private final EntryViewRepository entryViewRepository;

    private final Util util = new Util();

    public List<EntryView> getEntries() {
        return entryViewRepository.findAll();
    }

    public List<EntryView> getEntriesOfToday() {
        return entryViewRepository.findAllByDoneDate(util.getToday());
    }

    public Entry postPutEntry(Entry entry, RequestMethod requestMethod) throws HpjException {
        util.validateForPostAndPut(entryRepository.findAllByName(entry.getName()).size(), requestMethod);

        return entryRepository.save(entry);
    }

    public List<Entry> postEntriesOfToday() {
        List<Task> tasksOfToday = taskRepository.findAll();
        List<Entry> entriesOfToday = new ArrayList<>();
        for (Task taskOfToday : tasksOfToday) {
            Entry entryOfToday = new Entry();
            entryOfToday.setDoneDate(util.getToday());
            entryOfToday.setName(taskOfToday.getName());
            entryOfToday.setCount(0);
            entryOfToday.setHide(false);
            entryOfToday.setGoalCount(taskOfToday.getGoalCount());
            entryOfToday.setMaxCount(taskOfToday.getMaxCount());
            entryOfToday.setCountToComparableUnit(taskOfToday.getCountToComparableUnit());
            entriesOfToday.add(entryOfToday);
        }
        return entryRepository.saveAll(entriesOfToday);
    }
}
