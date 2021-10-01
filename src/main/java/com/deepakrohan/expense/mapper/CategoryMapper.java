package com.deepakrohan.expense.mapper;

import com.deepakrohan.expense.dto.CategoryDto;
import com.deepakrohan.expense.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface CategoryMapper {

    @Mapping(source = "category", target = "expenseCat")
    @Mapping(source = "categoryDesc", target = "expenseCatDesc")
    @Mapping(source = "amount", target = "amtCategoryAlloted")
    Category categoryDtoCategory(CategoryDto categoryDto);

    @Mapping(source = "expenseCat", target = "category")
    @Mapping(source = "expenseCatDesc", target = "categoryDesc")
    @Mapping(source = "amtCategoryAlloted", target = "amount")
    List<CategoryDto> categoryListToCategoryDto(List<Category> categoriesList);

    @Mapping(source = "expenseCat", target = "category")
    @Mapping(source = "expenseCatDesc", target = "categoryDesc")
    @Mapping(source = "amtCategoryAlloted", target = "amount")
    CategoryDto categoryToCategoryDto(Category category);
}
