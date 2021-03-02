package com.example.hpjtrackerbackend.repository;

import com.example.hpjtrackerbackend.dto.request.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
