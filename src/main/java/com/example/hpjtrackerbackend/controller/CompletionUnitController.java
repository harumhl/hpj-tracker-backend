package com.example.hpjtrackerbackend.controller;

import com.example.hpjtrackerbackend.dto.CompletionUnitsPerCategory;
import com.example.hpjtrackerbackend.service.CompletionUnitService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("completion-unit")
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CompletionUnitController {

    @NonNull
    private final CompletionUnitService completionUnitService;

    @GetMapping("")
    public List<CompletionUnitsPerCategory> getCompletionUnitsPerCategory() {
        return completionUnitService.getCompletionUnitsPerCategory();
    }

    @GetMapping("/today")
    public List<CompletionUnitsPerCategory> getCompletionUnitsPerCategoryOfToday() {
        return completionUnitService.getCompletionUnitsPerCategoryOfToday();
    }
}
