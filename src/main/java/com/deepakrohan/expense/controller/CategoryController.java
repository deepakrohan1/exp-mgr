package com.deepakrohan.expense.controller;

import com.deepakrohan.events.ExceededCostNotificationEvent;
import com.deepakrohan.expense.dto.CategoryDto;
import com.deepakrohan.expense.entity.Category;
import com.deepakrohan.expense.service.CategoryService;
import com.deepakrohan.expense.service.ExceededAmountNotificationService;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.deepakrohan.expense.messaging.SQSProducerService;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.zip.DataFormatException;

@RestController
@RequestMapping("/api")
@Slf4j
public class CategoryController {

    private MessageSource messageSource;
    private CategoryService categoryService;
    private ExceededAmountNotificationService exceededAmountNotificationService;
    private SQSProducerService sqsProducerService;

    public CategoryController(MessageSource messageSource,
                              CategoryService categoryService,
                              ExceededAmountNotificationService exceededAmountNotificationService,
                              SQSProducerService sqsProducerService) {
        this.messageSource = messageSource;
        this.categoryService = categoryService;
        this.exceededAmountNotificationService = exceededAmountNotificationService;
        this.sqsProducerService = sqsProducerService;
    }

    @GetMapping("/hello")
    public String getMessage() {
        log.info("Triggering the getMessage API");
        Map<String, Object> headers = new HashMap<>();
        headers.put("Message-Type", "some");
        headers.put("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        sqsProducerService.send("Hello", headers);

        return messageSource.getMessage("morning.message", null, LocaleContextHolder.getLocale());
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

    @GetMapping("/some")
    public CategoryDto getCategories() {
        CategoryDto categoryDto = CategoryDto
                .builder()
                .amount(BigDecimal.ONE)
                .category("Health")
                .categoryDesc("Exp for health")
                .build();

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("amount", "category");

        FilterProvider filters = new SimpleFilterProvider().addFilter("CategoryBeanFilter", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(categoryDto);
        mapping.setFilters(filters);

        return categoryDto;

    }

}
