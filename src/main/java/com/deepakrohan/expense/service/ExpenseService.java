package com.deepakrohan.expense.service;

import com.deepakrohan.expense.dto.ExpenseDto;
import com.deepakrohan.expense.entity.ExpenseItem;
import com.deepakrohan.expense.repo.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

//    public List<ExpenseItem> findAllExpenses() {
//        return expenseRepository.findAll();
//    }

//    public ExpenseItem saveReq(ExpenseDto expenseDto) {
//        ExpenseItem expenseItem = new ExpenseItem();
//        expenseItem.setExpenseInBrief(expenseDto.getExpenseName());
//        expenseItem.setExpenseDescription(expenseDto.getExpenseDesc());
//        expenseItem.setAmountSpent(expenseDto.getAmountSpent());
//        expenseItem.setCategoryId(expenseDto.getCategoryId());
//        expenseItem.setExpenseDateTime(LocalDateTime.now());
//        return expenseRepository.save(expenseItem);
//    }

//    public List<ExpenseItem> findAllExpensesById(String categoryId) {
//        return expenseRepository.findByCategoryId(categoryId);
//    }
}
