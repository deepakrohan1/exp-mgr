package com.deepakrohan.expense.service;

import com.deepakrohan.expense.dto.CategoryDto;
import com.deepakrohan.expense.entity.Category;
import com.deepakrohan.expense.exception.CategoryNotFoundException;
import com.deepakrohan.expense.mapper.CategoryMapper;
import com.deepakrohan.expense.repo.CategoryRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.zip.DataFormatException;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    private CategoryMapper categoryMapper = Mappers.getMapper(CategoryMapper.class);

    public CategoryDto save(CategoryDto categoryDto) {
        Category category = categoryRepository.save(categoryMapper.categoryDtoToCategory(categoryDto));
        return categoryMapper.categoryToCategoryDto(category);
    }

    public List<CategoryDto> findAllCategories() {
        List<CategoryDto> categories = categoryMapper.categoryListToCategoryDto(categoryRepository.findAll());
        Collections.sort(categories);
        return categories;
    }

    public void deleteCategoryById(Long categoryId) throws DataFormatException {
        Category category = categoryRepository.findById(categoryId).orElseThrow(DataFormatException::new);
        categoryRepository.delete(category);
    }

    public Category updateCategoryById(Long categoryId, CategoryDto categoryDto) {
//        Cate
        return null;
    }

    public CategoryDto findByCategoryId(Long id) {
        Category category = categoryRepository
                .findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with id: " +id));

        return categoryMapper.categoryToCategoryDto(category);
    }
}
