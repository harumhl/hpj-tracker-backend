package com.example.hpjtrackerbackend.controller;

import com.example.hpjtrackerbackend.HpjException;
import com.example.hpjtrackerbackend.dto.request.Entry;
import com.example.hpjtrackerbackend.dto.response.EntryResponse;
import com.example.hpjtrackerbackend.service.EntryService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public List<EntryResponse> getEntries() {
        return entryService.getEntries();
    }

    @GetMapping("/{date}")
    public List<EntryResponse> getEntriesOfADay(@PathVariable String date) {
        return entryService.getEntriesOfADay(date);
    }

    @PostMapping("")
    public EntryResponse postEntry(@RequestBody Entry entry) {
        return entryService.postPutEntry(entry, RequestMethod.POST);
    }

    @PutMapping("")
    public EntryResponse putEntry(@RequestBody Entry entry) {
        return entryService.postPutEntry(entry, RequestMethod.PUT);
    } // todo putEntriesOfToday()?

    @PostMapping("/{date}")
    public List<EntryResponse> postEntriesOfADay(@PathVariable String date) {
        return entryService.postEntriesOfADay(date);
    }
}
