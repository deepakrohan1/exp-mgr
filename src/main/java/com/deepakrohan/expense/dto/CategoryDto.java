package com.deepakrohan.expense.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel("To Handle Category requests sent by API")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonIgnoreProperties(value = {"dateAdded"})
public class CategoryDto implements Comparable<CategoryDto> {

    @Size(min = 3, message = "Should be at least 3 characters")
    @ApiModelProperty(notes = "this should have atleast 3 characters")
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
