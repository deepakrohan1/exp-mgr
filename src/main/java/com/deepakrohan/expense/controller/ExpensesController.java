package com.deepakrohan.expense.controller;

import com.deepakrohan.expense.dto.ExpenseDto;
import com.deepakrohan.expense.entity.ExpenseItem;
import com.deepakrohan.expense.service.ExpenseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ExpensesController {
    public  static Logger LOG = LoggerFactory.getLogger(ExpensesController.class);

    @Autowired
    private ExpenseService expenseService;

    public static final String EXPENSES = "/expenses";

    @GetMapping(EXPENSES)
    public ResponseEntity getAllExpenses() {
        LOG.info("Get Expenses Req");
        List<ExpenseItem> expenseItem = expenseService.findAllExpenses();
        return ResponseEntity.ok(expenseItem);
    }

    @GetMapping(EXPENSES + "/{categoryId}")
    public ResponseEntity getExpensesByCatId(@PathVariable("categoryId") String categoryId) {
        LOG.info("Get Expenses by Id");
        List<ExpenseItem> expenseItem = expenseService.findAllExpensesById(categoryId);
        return ResponseEntity.ok(expenseItem);
    }

    @PostMapping(EXPENSES)
    public ResponseEntity saveExpenses(@RequestBody ExpenseDto expenseDto) {
        LOG.info("Post req for Save");
        ExpenseItem expenseItem = expenseService.saveReq(expenseDto);
        return  ResponseEntity.status(HttpStatus.CREATED).body(expenseItem);
    }
}
