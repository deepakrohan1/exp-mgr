package com.deepakrohan.expense.mapper;
import java.util.List;

import com.deepakrohan.expense.dto.ExpenseDto;
import com.deepakrohan.expense.entity.Expense;

import org.mapstruct.Mapper;

@Mapper
public interface ExpenseMapper {
    Expense expenseDtoToExpense(ExpenseDto expenseDto);
  
    List<ExpenseDto> expensesListToExpenseDto(List<Expense> expenses);

    ExpenseDto expenseToExpenseDto(Expense expense);
}
