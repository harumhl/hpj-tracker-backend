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

import java.time.LocalDate;
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

    public List<EntryResponse> getEntriesOfADay(String dateStr) {
        LocalDate date = util.getDate(dateStr);
        return entryResponseRepository.findAllByDoneDate(date);
    }

    public EntryResponse postPutEntry(Entry entry, RequestMethod requestMethod) throws HpjException {
        util.validateForPostAndPut(entryRepository.findAllByName(entry.getName()).size(), requestMethod);
        entry = entryRepository.save(entry);
        return entryResponseRepository.findById(entry.getId()).get();
    }

    public List<EntryResponse> postEntriesOfADay(String dateStr) {
        LocalDate date = util.getDate(dateStr);
        List<TaskResponse> tasks = taskResponseRepository.findAllByArchivedIsFalse();
        List<EntryResponse> existingEntriesOfTheDay = getEntriesOfADay(dateStr);
        List<Entry> entriesOfTheDay = new ArrayList<>();
        for (TaskResponse taskResponse : tasks) {
            // Skip if it already exists in the db
            if (existingEntriesOfTheDay.stream().anyMatch(e -> e.getName().equals(taskResponse.getName()))) {
                continue;
            }

            Entry entryResponseOfToday = new Entry();
            entryResponseOfToday.setDoneDate(date);
            entryResponseOfToday.setName(taskResponse.getName());
            entryResponseOfToday.setCount((double) 0);
            entryResponseOfToday.setHide(false);
            entryResponseOfToday.setGoalCount(taskResponse.getGoalCount());
            entryResponseOfToday.setMaxCount(taskResponse.getMaxCount());
            entryResponseOfToday.setMultiplier(taskResponse.getMultiplier());
            entryResponseOfToday.setTaskId(taskResponse.getId());
            entriesOfTheDay.add(entryResponseOfToday);
        }
        entriesOfTheDay = entryRepository.saveAll(entriesOfTheDay);
        List<Long> ids = entriesOfTheDay.stream().map(Entry::getId).collect(Collectors.toList());
        return entryResponseRepository.findAllById(ids);
    }
}
