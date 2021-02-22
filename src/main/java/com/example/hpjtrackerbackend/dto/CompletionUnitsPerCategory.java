package com.example.hpjtrackerbackend.dto;

import com.example.hpjtrackerbackend.dto.helper.CompletionUnitsPerCategoryId;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "completion_units_per_category")
@Data
@IdClass(CompletionUnitsPerCategoryId.class)
public class CompletionUnitsPerCategory {
    @Id
    private LocalDate doneDate;
    @Id
    private String categoryName;

    private Double percentSum;
    private Integer goalInComparableUnit;
    private Double completionPercent;
}
