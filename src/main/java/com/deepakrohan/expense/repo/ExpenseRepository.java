package com.deepakrohan.expense.repo;

import com.deepakrohan.expense.entity.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends MongoRepository<Category, Double> {
}
