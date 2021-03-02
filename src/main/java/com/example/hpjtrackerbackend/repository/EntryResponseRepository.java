package com.example.hpjtrackerbackend.repository;

import com.example.hpjtrackerbackend.dto.response.EntryResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EntryResponseRepository extends JpaRepository<EntryResponse, Long> {
    List<EntryResponse> findAllByDoneDate(LocalDate name);
}
