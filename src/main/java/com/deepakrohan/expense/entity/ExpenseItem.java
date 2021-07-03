package com.deepakrohan.expense.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document
public class ExpenseItem {
    private String expenseInBrief;
    private String expenseDescription;
    private LocalDateTime expenseDateTime;
    private BigDecimal amountSpent;

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
