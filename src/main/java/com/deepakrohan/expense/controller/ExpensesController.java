package com.deepakrohan.expense.controller;

import java.util.List;
import java.util.zip.DataFormatException;

import javax.validation.Valid;

import com.deepakrohan.expense.dto.ExpenseDto;
import com.deepakrohan.expense.service.ExpenseService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ExpensesController {
    public  static Logger LOG = LoggerFactory.getLogger(ExpensesController.class);

    @Autowired
    private ExpenseService expenseService;

    public static final String EXPENSES = "/expenses";

    @GetMapping(EXPENSES)
    public ResponseEntity<List<ExpenseDto>> getExpenses() {
        LOG.info("Get all expenses");
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(expenseService.findAllExpenses());
    }

    /**
     * A place to put expenses into
     * @param expenseDto
     * @return expenseDto
     */
    @PostMapping(EXPENSES)
    public ResponseEntity<ExpenseDto> saveExpense(@RequestBody ExpenseDto expenseDto) {
        LOG.info("Post expense for save {}", expenseDto);
        ExpenseDto expenses = expenseService.saveExpense(expenseDto);
        return  ResponseEntity.status(HttpStatus.CREATED).body(expenses);
    }

    /**
     * Handle Delete of an expense
     * @param expenseId
     * @return
     */
    @DeleteMapping(EXPENSES + "/{expenseId}")
    public ResponseEntity deleteExpense(@PathVariable("expenseId") Long expenseId ) {
        LOG.info("Deleting expense with id {}", expenseId);
        try {
            expenseService.deleteExpense(expenseId);
        } catch (DataFormatException e) {
            LOG.error("Error deleting expense with id {}", expenseId, e);
            return  new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return (ResponseEntity) ResponseEntity.status(HttpStatus.OK);
    }

    /**
     * Update expense Id
     * @param expenseId
     * @param expenseDto
     * @return
     */
    @PutMapping(EXPENSES + "/{expenseId}")
    public ResponseEntity<ExpenseDto> putExpense(@RequestBody @Valid ExpenseDto expenseDto) {
        LOG.info("Updating expense as {}", expenseDto);
        ExpenseDto expenses = expenseService.updateExpense(expenseDto);
        return ResponseEntity.status(HttpStatus.OK).body(expenses);
    }
}
