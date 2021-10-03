package com.deepakrohan.expense.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CategoryDto implements Comparable<CategoryDto> {

    @Size(min = 3, message = "Should be at least 3 characters")
    private String category;
    private String categoryDesc;
    private BigDecimal amount;
    private String dateAdded;

    @Override
    public int compareTo(CategoryDto o) {
        int categoryCompare = this.category.compareTo(o.category);
        if (categoryCompare == 0) return this.categoryDesc.compareTo(o.categoryDesc);
        return categoryCompare;
    }
}
