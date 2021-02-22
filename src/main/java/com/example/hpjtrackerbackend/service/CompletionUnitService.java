package com.example.hpjtrackerbackend.service;

import com.example.hpjtrackerbackend.dto.CompletionUnitsPerCategory;
import com.example.hpjtrackerbackend.repository.CompletionUnitRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CompletionUnitService {

    @NonNull
    private final CompletionUnitRepository completionUnitRepository;

    public List<CompletionUnitsPerCategory> getCompletionUnitsPerCategory() {
        return completionUnitRepository.findAll();
    }
}
