package com.deepakrohan.expense.service;

import com.deepakrohan.expense.dto.CategoryDto;
import com.deepakrohan.expense.entity.Category;
import com.deepakrohan.expense.repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category save(CategoryDto category) {
        Category category1 = new Category();
        category1.setExpenseCat(category.getCategory());
        category1.setExpenseCatDesc(category.getCategoryDesc());
        category1.setTimeCategoryCreated(LocalDateTime.now());
        category1.setAmtCategoryAlloted(category.getLimit());
         categoryRepository.save(category1);
        return category1;
    }

}
