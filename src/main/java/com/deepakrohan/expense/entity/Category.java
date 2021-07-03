package com.deepakrohan.expense.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "category")
public class Category {

    @Id
    private String id;
    private String expenseCat;
    private String expenseCatDesc;
    private List<ExpenseItem> listOfExpenses;
    private LocalDateTime timeCreated;

    public Category() {}

    public Category(String id, String expenseCat, String expenseCatDesc, List<ExpenseItem> listOfExpenses, LocalDateTime timeCreated) {
        this.id = id;
        this.expenseCat = expenseCat;
        this.expenseCatDesc = expenseCatDesc;
        this.listOfExpenses = listOfExpenses;
        this.timeCreated = timeCreated;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExpenseCat() {
        return expenseCat;
    }

    public void setExpenseCat(String expenseCat) {
        this.expenseCat = expenseCat;
    }

    public String getExpenseCatDesc() {
        return expenseCatDesc;
    }

    public void setExpenseCatDesc(String expenseCatDesc) {
        this.expenseCatDesc = expenseCatDesc;
    }

    public List<ExpenseItem> getListOfExpenses() {
        return listOfExpenses;
    }

    public void setListOfExpenses(List<ExpenseItem> listOfExpenses) {
        this.listOfExpenses = listOfExpenses;
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(LocalDateTime timeCreated) {
        this.timeCreated = timeCreated;
    }
}
