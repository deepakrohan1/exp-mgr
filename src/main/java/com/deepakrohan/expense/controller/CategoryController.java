package com.deepakrohan.expense.controller;

import com.deepakrohan.expense.dto.CategoryDto;
import com.deepakrohan.expense.entity.Category;
import com.deepakrohan.expense.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class CategoryController {


    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategories() {
//        TODO this logic has to be updated per user
        log.info("Get All Categories...");
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(categoryService.findAllCategories());
    }

    /**
     * A place to put expenses into
     * @param category
     * @return
     */
    @PostMapping("/categories")
    public ResponseEntity<CategoryDto> saveCategory(@RequestBody CategoryDto category) {
        log.info("Save Request {}", category.toString());
        CategoryDto cat = categoryService.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(cat);
    }

    /**
     * Handle Delete of category
     * @param categoryId
     * @return
     */
    @DeleteMapping("/categories/{categoryId}")
    public ResponseEntity deleteCategory(@PathVariable("categoryId") Long categoryId ) {
        log.info("Deleteing category with id {}", categoryId);
        categoryService.deleteCategoryById(categoryId);
        return (ResponseEntity) ResponseEntity.status(HttpStatus.NO_CONTENT);
    }


    /**
     * Update category Id
     * @param categoryId
     * @param categoryDto
     * @return
     */
    @PutMapping("/categories/{categoryId}")
    public ResponseEntity<Category> putCategory(@PathVariable("categoryId") Long categoryId,
                                                @RequestBody CategoryDto categoryDto) {
        categoryService.updateCategoryById(categoryId, categoryDto);
        return null;

    }

}
