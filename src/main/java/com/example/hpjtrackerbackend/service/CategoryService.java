package com.example.hpjtrackerbackend.service;

import com.example.hpjtrackerbackend.HpjException;
import com.example.hpjtrackerbackend.dto.Category;
import com.example.hpjtrackerbackend.repository.CategoryRepository;
import com.example.hpjtrackerbackend.util.Util;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CategoryService {

    @NonNull
    private final CategoryRepository categoryRepository;

    private final Util util = new Util();

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public Category postPutCategory(Category category, RequestMethod requestMethod) throws HpjException {
        util.validateForPostAndPut(categoryRepository.findAllByName(category.getName()).size(), requestMethod);

        return categoryRepository.save(category);
    }
}
