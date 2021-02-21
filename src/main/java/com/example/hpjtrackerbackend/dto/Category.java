package com.example.hpjtrackerbackend.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category")
@Data
public class Category {
    @Id
    private String name;
    private String color;
    private Integer goalInComparableUnit; // Integer instead of int, so it can be null
}
