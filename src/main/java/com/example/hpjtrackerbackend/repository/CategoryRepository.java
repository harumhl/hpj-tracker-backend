package com.example.hpjtrackerbackend.repository;

import com.example.hpjtrackerbackend.dto.response.CategoryResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryResponse, Long> {
    List<CategoryResponse> findAllByName(String name);
}
