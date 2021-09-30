package com.deepakrohan.expense.entity;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ExpenseItem {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Id
    private String id;
    private String expenseInBrief;
    private String expenseDescription;
    private LocalDateTime expenseDateTime;
    private BigDecimal amountSpent;
    private String categoryId;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }


    public ExpenseItem() { }

    public ExpenseItem(String expenseInBrief, String expenseDescription, LocalDateTime expenseDateTime, BigDecimal amountSpent) {
        this.expenseInBrief = expenseInBrief;
        this.expenseDescription = expenseDescription;
        this.expenseDateTime = expenseDateTime;
        this.amountSpent = amountSpent;
    }

    public String getExpenseInBrief() {
        return expenseInBrief;
    }

    public void setExpenseInBrief(String expenseInBrief) {
        this.expenseInBrief = expenseInBrief;
    }

    public String getExpenseDescription() {
        return expenseDescription;
    }

    public void setExpenseDescription(String expenseDescription) {
        this.expenseDescription = expenseDescription;
    }

    public LocalDateTime getExpenseDateTime() {
        return expenseDateTime;
    }

    public void setExpenseDateTime(LocalDateTime expenseDateTime) {
        this.expenseDateTime = expenseDateTime;
    }

    public BigDecimal getAmountSpent() {
        return amountSpent;
    }

    public void setAmountSpent(BigDecimal amountSpent) {
        this.amountSpent = amountSpent;
    }
}
