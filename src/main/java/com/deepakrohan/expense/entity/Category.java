package com.deepakrohan.expense.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDateTime;
import java.util.List;

//@AllArgsConstructor
//@NoArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String expenseCat;
    private String expenseCatDesc;
    private List<ExpenseItem> listOfExpenses;
    private LocalDateTime timeCreated;
}

