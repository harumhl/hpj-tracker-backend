package com.example.hpjtrackerbackend.dto.helper;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class CompletionUnitsPerCategoryId implements Serializable {
    private LocalDate doneDate;
    private String categoryName;
}
