package com.example.hpjtrackerbackend.repository;

import com.example.hpjtrackerbackend.dto.CompletionUnitsPerCategory;
import com.example.hpjtrackerbackend.dto.helper.CompletionUnitsPerCategoryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompletionUnitRepository extends JpaRepository<CompletionUnitsPerCategory, CompletionUnitsPerCategoryId> {
}
