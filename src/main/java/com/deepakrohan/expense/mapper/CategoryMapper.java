package com.deepakrohan.expense.mapper;

import com.deepakrohan.expense.dto.CategoryDto;
import com.deepakrohan.expense.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CategoryMapper {

    @Mapping(source = "category", target = "expenseCat")
    @Mapping(source = "categoryDesc", target = "expenseCatDesc")
    @Mapping(source = "amount", target = "amtCategoryAlloted")
    Category categoryDtoCategory(CategoryDto categoryDto);

    @Mapping(source = "expenseCat", target = "category")
    @Mapping(source = "expenseCatDesc", target = "categoryDesc")
    @Mapping(source = "amtCategoryAlloted", target = "amount")
    CategoryDto categoryToCategoryDto(Category category);
}
