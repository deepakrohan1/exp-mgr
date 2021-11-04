package com.deepakrohan.expense.mapper;

import com.deepakrohan.expense.dto.CategoryDto;
import com.deepakrohan.expense.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface CategoryMapper {

    @Mapping(source = "category", target = "expenseCat")
    @Mapping(source = "categoryDesc", target = "expenseCatDesc")
    @Mapping(source = "amount", target = "amtCategoryAlloted")
    @Mapping(source = "dateAdded", target = "timeCategoryCreated")
    @Mapping(target = "expenses", ignore = true)
    Category categoryDtoToCategory(CategoryDto categoryDto);

    @Mapping(source = "category.expenseCat", target = "category")
    @Mapping(source = "category.expenseCatDesc", target = "categoryDesc")
    @Mapping(source = "category.amtCategoryAlloted", target = "amount")
    @Mapping(source = "category.timeCategoryCreated", target = "dateAdded", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "expenses", ignore = true)
    List<CategoryDto> categoryListToCategoryDto(List<Category> categoriesList);

    @Mapping(source = "category.expenseCat", target = "category")
    @Mapping(source = "category.expenseCatDesc", target = "categoryDesc")
    @Mapping(source = "category.amtCategoryAlloted", target = "amount")
    @Mapping(source = "category.timeCategoryCreated", target = "dateAdded", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "expenses", ignore = true)
    CategoryDto categoryToCategoryDto(Category category);
}
