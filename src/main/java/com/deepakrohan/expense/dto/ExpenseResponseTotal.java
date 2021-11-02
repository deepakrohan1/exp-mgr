package com.deepakrohan.expense.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseResponseTotal {
    public BigDecimal total;
    public List<ExpenseDto> expenses;
}
