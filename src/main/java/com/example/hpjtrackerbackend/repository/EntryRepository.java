package com.example.hpjtrackerbackend.repository;

import com.example.hpjtrackerbackend.dto.request.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntryRepository extends JpaRepository<Entry, Long> {
    List<Entry> findAllByName(String name);
}
