package com.example.hpjtrackerbackend.controller;

import com.example.hpjtrackerbackend.HpjException;
import com.example.hpjtrackerbackend.dto.response.CategoryResponse;
import com.example.hpjtrackerbackend.service.CategoryService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("categories")
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CategoryController {

    @NonNull
    private final CategoryService categoryService;

    @GetMapping("")
    public List<CategoryResponse> getCategories() {
        return categoryService.getCategories();
    }

    @PostMapping("")
    public CategoryResponse postCategory(@RequestBody CategoryResponse categoryResponse) throws HpjException {
        return categoryService.postPutCategory(categoryResponse, RequestMethod.POST);
    }

    @PutMapping("")
    public CategoryResponse putCategory(@RequestBody CategoryResponse categoryResponse) throws HpjException {
        return categoryService.postPutCategory(categoryResponse, RequestMethod.PUT);
    }
}
