package com.example.hpjtrackerbackend.repository;

import com.example.hpjtrackerbackend.dto.EntryView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EntryViewRepository extends JpaRepository<EntryView, Long> {
    List<EntryView> findAllByDoneDate(LocalDate doneDate);
    List<EntryView> findAllByName(String name);
}
