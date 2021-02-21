package com.example.hpjtrackerbackend.dto;

import com.vladmihalcea.hibernate.type.array.ListArrayType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="task_with_category_name")
@TypeDef(name = "list-array", typeClass = ListArrayType.class)
@Data
public class TaskView extends Task {
    private String categoryName;
}
