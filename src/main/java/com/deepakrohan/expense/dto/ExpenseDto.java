package com.deepakrohan.expense.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ExpenseDto implements Serializable {
    @NotNull
    private Long expId;
    private String expenseInBrief;
    private String expenseDescription;
    private LocalDateTime expenseDateTime;
    private BigDecimal amountSpent;
    private Integer categoryId;
    private String lxImageUrl;
    private String smImageUrl;

}
