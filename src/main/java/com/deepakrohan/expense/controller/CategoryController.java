package com.deepakrohan.expense.controller;

import com.deepakrohan.expense.dto.CategoryDto;
import com.deepakrohan.expense.entity.Category;
import com.deepakrohan.expense.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;
import java.util.zip.DataFormatException;

@RestController
@RequestMapping("/api")
@Slf4j
public class CategoryController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/hello")
    public String getMessage(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        return messageSource.getMessage("morning.message", null, locale);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
//        TODO this logic has to be updated per user
        log.info("Get All Categories...");
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(categoryService.findAllCategories());
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable("id") Long id) {
//        TODO this logic has to be updated per user
        log.info("Get All Categories...");
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(categoryService.findByCategoryId(id));
    }
    /**
     * A place to put expenses into
     * @param category
     * @return
     */
    @PostMapping("/categories")
    public ResponseEntity<CategoryDto> saveCategory(@Valid @RequestBody CategoryDto category) {
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
        log.info("Deleting category with id {}", categoryId);
        try {
            categoryService.deleteCategoryById(categoryId);
        } catch (DataFormatException e) {
            log.error("error in processing delete for categoryId{} No category found {}", categoryId, e);
            return  new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
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
