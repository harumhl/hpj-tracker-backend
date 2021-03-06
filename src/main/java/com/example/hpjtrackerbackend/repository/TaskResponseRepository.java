package com.example.hpjtrackerbackend.repository;

import com.example.hpjtrackerbackend.dto.response.TaskResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskResponseRepository extends JpaRepository<TaskResponse, Long> {
    List<TaskResponse> findAllByName(String name);
    List<TaskResponse> findAllByArchivedIsFalse();
}
