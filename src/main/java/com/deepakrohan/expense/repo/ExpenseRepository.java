package com.deepakrohan.expense.repo;

import com.deepakrohan.expense.entity.Category;
import com.deepakrohan.expense.entity.ExpenseItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends MongoRepository<ExpenseItem, String> {
    @Query("{'categoryId': ?0}")
    List<ExpenseItem> findByCategoryId(String categoryId);
}
