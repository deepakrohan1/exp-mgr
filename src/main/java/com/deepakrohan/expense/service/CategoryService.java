package com.deepakrohan.expense.service;

import com.deepakrohan.expense.dto.CategoryDto;
import com.deepakrohan.expense.dto.ExpenseResponseTotal;
import com.deepakrohan.expense.entity.Category;
import com.deepakrohan.expense.entity.Expense;
import com.deepakrohan.expense.exception.CategoryNotFoundException;
import com.deepakrohan.expense.mapper.CategoryMapper;
import com.deepakrohan.expense.mapper.ExpenseMapper;
import com.deepakrohan.expense.repo.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.zip.DataFormatException;

@Slf4j
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CalculateServiceExpCheck calculateServiceExpCheck;

    private CategoryMapper categoryMapper = Mappers.getMapper(CategoryMapper.class);
    private ExpenseMapper expenseMapper = Mappers.getMapper(ExpenseMapper.class);

    public CategoryDto save(CategoryDto categoryDto) {
        Category category = categoryRepository.save(categoryMapper.categoryDtoToCategory(categoryDto));
        return categoryMapper.categoryToCategoryDto(category);
    }

    public List<CategoryDto> findAllCategories() {
        log.info("Found all categories {}", categoryRepository.findAll());
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
        log.info("Found all categories {}", category);
        ExpenseResponseTotal exp = new ExpenseResponseTotal();
        exp.setExpenses(expenseMapper.expensesListToExpenseDto(category.getExpenses()));
        exp.setTotal(getTotalAmt(category.getExpenses()));

        CategoryDto categoryDto =  categoryMapper.categoryToCategoryDto(category);
        categoryDto.setExpenses(exp);
        calculateServiceExpCheck.calculateIfExpExceedsPrice(categoryDto);
        return categoryDto;
    }

    public BigDecimal getTotalAmt(List<Expense> exp) {
        return exp.stream()
                .map(Expense::getAmountSpent)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }


}
