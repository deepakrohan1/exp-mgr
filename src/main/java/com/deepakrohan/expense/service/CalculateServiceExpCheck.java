package com.deepakrohan.expense.service;

import com.deepakrohan.expense.dto.CategoryDto;
import com.deepakrohan.expense.entity.Expense;
import com.deepakrohan.expense.messaging.SQSProducerService;
import com.deepakrohan.expense.repo.CategoryRepository;
import com.deepakrohan.expense.repo.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class CalculateServiceExpCheck {

    @Autowired
    private SQSProducerService sqsProducerService;

    private ExpenseRepository expenseRepository;
    private CategoryRepository categoryRepository;
    private ExceededAmountNotificationService exceededAmountNotificationService;

    public void isExpAddedExceedingCategoryAmount(Expense exp) {

    }

    @Async
    public void calculateIfExpExceedsPrice(CategoryDto categoryDto) {
        BigDecimal amountLimit = categoryDto.getAmount();
        BigDecimal expTot = categoryDto.getExpenses().getTotal();
        if (expTot.compareTo(amountLimit) >= 0) {
            triggerMessage("Hi User, Your amount has exceeded the limit assigned for Category");
        }

    }

    @Async
    public void triggerMessage(String message) {
        Map<String, Object> headers = new HashMap<>();
        sqsProducerService.send(message, headers);
    }


}
