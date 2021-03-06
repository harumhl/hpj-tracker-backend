package com.example.hpjtrackerbackend.service;

import com.example.hpjtrackerbackend.dto.response.CompletionUnitsPerCategory;
import com.example.hpjtrackerbackend.repository.CompletionUnitRepository;
import com.example.hpjtrackerbackend.util.Util;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CompletionUnitService {

    @NonNull
    private final CompletionUnitRepository completionUnitRepository;

    private final Util util = new Util();

    public List<CompletionUnitsPerCategory> getCompletionUnitsPerCategory() {
        return completionUnitRepository.findAll();
    }

    public List<CompletionUnitsPerCategory> getCompletionUnitsPerCategoryOfADay(String dateStr) {
        LocalDate date = util.getDate(dateStr);
        return completionUnitRepository.findAllByDoneDate(date);
    }
}
