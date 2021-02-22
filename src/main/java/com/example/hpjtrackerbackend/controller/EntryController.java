package com.example.hpjtrackerbackend.controller;

import com.example.hpjtrackerbackend.HpjException;
import com.example.hpjtrackerbackend.dto.Entry;
import com.example.hpjtrackerbackend.service.EntryService;
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

@RequestMapping("entries")
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EntryController {

    @NonNull
    private final EntryService entryService;

    @GetMapping("")
    public List<Entry> getEntries() {
        return entryService.getEntries();
    }

    @GetMapping("/today")
    public List<Entry> getEntriesOfToday() {
        return entryService.getEntriesOfToday();
    }

    @PostMapping("")
    public Entry postEntry(@RequestBody Entry entry) throws HpjException {
        return entryService.postPutEntry(entry, RequestMethod.POST);
    }

    @PutMapping("")
    public Entry putEntry(@RequestBody Entry entry) throws HpjException {
        return entryService.postPutEntry(entry, RequestMethod.PUT);
    } // todo putEntriesOfToday()?

    @PostMapping("/today")
    public List<Entry> postEntriesOfToday() {
        return entryService.postEntriesOfToday();
    }
}
