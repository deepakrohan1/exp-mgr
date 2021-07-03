package com.deepakrohan.expense.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class ExpensesController {

    public static final String EXPENSES = "/expenses";

    @GetMapping(EXPENSES)
    public ResponseEntity getAllExpenses() {
        return ResponseEntity.ok().build();
    }
}
