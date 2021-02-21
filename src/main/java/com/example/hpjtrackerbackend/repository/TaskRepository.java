package com.example.hpjtrackerbackend.repository;

import com.example.hpjtrackerbackend.dto.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByName(String name);
}
