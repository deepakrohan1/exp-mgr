package com.deepakrohan.expense.controller;

import com.deepakrohan.expense.dto.CategoryDto;
import com.deepakrohan.expense.entity.Category;
import com.deepakrohan.expense.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    public static Logger LOG = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;

    /**
     * A place to put expenses into
     * @param category
     * @return
     */
    @PostMapping("/categories")
    public ResponseEntity<Category> saveCategory(@RequestBody CategoryDto category) {
        LOG.info("Save Request {}", category.toString());
        Category cat = categoryService.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(cat);
    }

    /**
     * Get all the expense related to a user
     * @return
     * TODO Add user details
//     */
//    @GetMapping("/categories")
//    public ResponseEntity<List<Category>> getCategories() {
//        return  ResponseEntity.ok(categoryService.findAllCategories());
//    }
}
