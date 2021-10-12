package com.deepakrohan.expense.service;

import com.deepakrohan.expense.dto.ExpenseDto;
import com.deepakrohan.expense.entity.Expense;
import com.deepakrohan.expense.mapper.ExpenseMapper;
import com.deepakrohan.expense.repo.ExpenseRepository;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.zip.DataFormatException;

@Service
@Slf4j
public class ExpenseService {

    private ExpenseMapper expenseMapper = Mappers.getMapper(ExpenseMapper.class);

    @Autowired
    private ExpenseRepository expenseRepository;

    @Cacheable(value = "itemCache")
    public List<ExpenseDto> findAllExpenses() {
        log.info("Getting all expenses...");
        List<ExpenseDto> expenses = expenseMapper.expensesListToExpenseDto(expenseRepository.findAll());
        return expenses;
    }

    public ExpenseDto saveExpense(ExpenseDto expenseDto) {
        Expense expense = expenseRepository.save(expenseMapper.expenseDtoToExpense(expenseDto));
        return expenseMapper.expenseToExpenseDto(expense);
    }

    public void deleteExpense(Long expenseId) throws DataFormatException {
        Expense expense = expenseRepository.findById(expenseId).orElseThrow(DataFormatException::new);
        expenseRepository.delete(expense);
    }

    public ExpenseDto updateExpense(ExpenseDto expenseDto) {
        Expense expense = expenseMapper.expenseDtoToExpense(expenseDto);
        expense = expenseRepository.save(expense);
        return expenseMapper.expenseToExpenseDto(expense);
    }
}
