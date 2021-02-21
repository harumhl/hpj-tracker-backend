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
@Table(name="entry")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
@Data
public class Entry {
    @Id
    private long id;
    private long taskId;
    private LocalDate doneDate;
    private String name;
    private int count;
    private boolean hide;
    private int goalCount;
    private int maxCount;
    private double countToComparableUnit;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private Map<String, Object> details; // TODO maybe Map<String, String>
}
