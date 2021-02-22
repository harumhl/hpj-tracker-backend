package com.example.hpjtrackerbackend.dto;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Map;

@Entity
@Table(name = "entry")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
@Data
public class Entry {
    @Id
    @SequenceGenerator(name = "entry_id_seq", sequenceName = "entry_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entry_id_seq")
    private Long id;

    private LocalDate doneDate;
    private String name;
    private Integer count;
    private Boolean hide;
    private Integer goalCount;
    private Integer maxCount;
    private Double countToComparableUnit;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private Map<String, Object> details; // TODO maybe Map<String, String>

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id", referencedColumnName = "id")
    private Task task;
}
