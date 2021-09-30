package com.deepakrohan.expense.repo;

import com.deepakrohan.expense.entity.Category;
import com.deepakrohan.expense.entity.ExpenseItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseItem, Long> {
//    List<ExpenseItem> findByCategoryId(String categoryId);
}
