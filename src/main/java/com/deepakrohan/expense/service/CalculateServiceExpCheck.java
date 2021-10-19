package com.deepakrohan.expense.service;

import com.deepakrohan.events.ExceededCostNotificationEvent;
import com.deepakrohan.expense.entity.Category;
import com.deepakrohan.expense.entity.Expense;
import com.deepakrohan.expense.repo.CategoryRepository;
import com.deepakrohan.expense.repo.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CalculateServiceExpCheck {

    private ExpenseRepository expenseRepository;
    private CategoryRepository categoryRepository;
    private ExceededAmountNotificationService exceededAmountNotificationService;

    public boolean isExpAddedExceedingCategoryAmount(Expense exp) {
        log.info("Expense exceeded check... ");
//        Category cat = categoryRepository.findById(exp.getCategoryId().longValue())
//                .orElseThrow(() -> new CategoryNotFoundException("CategoryNotFound with ID: " +exp.getCategoryId()));
        Category cat = new Category();
        List<Expense> allExpenses = expenseRepository.findByCategoryId(cat.getId());

        Double amount = allExpenses.stream().mapToDouble((exp1) -> exp1.getAmountSpent().doubleValue()).sum();

        if (amount > cat.getAmtCategoryAlloted().doubleValue()) {
            exceededAmountNotificationService.triggerNotification(ExceededCostNotificationEvent.builder()
                    .email("someuser@fm.com")
                    .amount(new BigDecimal(amount)) //TODO Fix this.
                    .messageContent("Exceeded Amt")
                    .build());
        }

        return true;

    }

}
