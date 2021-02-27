package com.example.hpjtrackerbackend.controller;

import com.example.hpjtrackerbackend.HpjException;
import com.example.hpjtrackerbackend.dto.response.Category;
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
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @PostMapping("")
    public Category postCategory(@RequestBody Category category) throws HpjException {
        return categoryService.postPutCategory(category, RequestMethod.POST);
    }

    @PutMapping("")
    public Category putCategory(@RequestBody Category category) throws HpjException {
        return categoryService.postPutCategory(category, RequestMethod.PUT);
    }
}
