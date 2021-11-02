package com.deepakrohan.expense.service;


import com.deepakrohan.expense.entity.Category;
import com.deepakrohan.expense.entity.Expense;
import com.deepakrohan.expense.repo.CategoryRepository;
import com.deepakrohan.expense.repo.ExpenseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlayService {
    public ExpenseRepository expenseRepository;
    public CategoryRepository categoryRepository;

    public PlayService(CategoryRepository categoryRepository, ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
        this.categoryRepository = categoryRepository;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public void playWithTransactional() throws RuntimeException {
        Category cat = categoryRepository.findById(1L).get();
        cat.setExpenseCat("New Name4");
        Category cat2 = categoryRepository.save(cat);
        if (cat2 != null) throw new RuntimeException();


        Expense exp = expenseRepository.findById(1L).get();
        exp.setCategory(cat);
        exp.setExpenseInBrief("New comment");
        expenseRepository.save(exp);
    }
}
