package com.deepakrohan.expense.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ExpenseDto {
    private Long expId;
    private String expenseInBrief;
    private String expenseDescription;
    private LocalDateTime expenseDateTime;
    private BigDecimal amountSpent;
    private Integer categoryId;
    private String lxImageUrl;
    private String smImageUrl;

}
