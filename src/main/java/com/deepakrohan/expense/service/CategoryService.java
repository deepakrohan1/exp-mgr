package com.deepakrohan.expense.service;

import com.deepakrohan.expense.dto.CategoryDto;
import com.deepakrohan.expense.entity.Category;
import com.deepakrohan.expense.mapper.CategoryMapper;
import com.deepakrohan.expense.mapper.CategoryMapperImpl;
import com.deepakrohan.expense.repo.CategoryRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    private CategoryMapper categoryMapper = Mappers.getMapper(CategoryMapper.class);

    public CategoryDto save(CategoryDto categoryDto) {
        Category category = categoryRepository.save(categoryMapper.categoryDtoCategory(categoryDto));
        return categoryMapper.categoryToCategoryDto(category);
    }

    public List<CategoryDto> findAllCategories() {
        return categoryMapper.categoryListToCategoryDto(categoryRepository.findAll());
    }

    public void deleteCategoryById(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).get();
        if (category != null)
             categoryRepository.delete(categoryRepository.findById(categoryId).get());
    }

    public Category updateCategoryById(Long categoryId, CategoryDto categoryDto) {
//        Cate
        return null;
    }
}
