package com.example.hpjtrackerbackend.dto;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Map;

@Entity
@Table(name="entry_with_category_name_and_goal_name")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
@Data
public class EntryView extends Entry {
    private String categoryName;
    private String taskName;
}
