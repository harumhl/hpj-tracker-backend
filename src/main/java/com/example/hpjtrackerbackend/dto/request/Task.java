package com.example.hpjtrackerbackend.dto.request;

import com.vladmihalcea.hibernate.type.array.ListArrayType;
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
import java.util.List;

@Entity
@Table(name = "task")
@TypeDef(name = "list-array", typeClass = ListArrayType.class)
@Data
public class Task {
    @Id
    @SequenceGenerator(name = "task_id_seq", sequenceName = "task_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_id_seq")
    private Long id;
    private String name;
    private Boolean archived;
    private Integer goalCount;
    private Integer maxCount;
    /*  multiplier shows how much a task is worth. So it allows tasks to be comparable.
        e.g. 5 min done / 10 min goal * 2.0 multiplier = worth 1 comparable unit
        e.g. 10 min done / 5 min goal * 0.5 multiplier = worth 1 comparable unit */
    private Double multiplier;
    private String unit;

    @Type(type = "list-array")
    @Column(columnDefinition = "text[]")
    private List<String> expectedTimesOfCompletion;

    private String details;

    private Long categoryId;
}
