package com.example.hpjtrackerbackend.repository;

import com.example.hpjtrackerbackend.dto.TaskView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskViewRepository extends JpaRepository<TaskView, Long> {
    List<TaskView> findAllByName(String name);
}
