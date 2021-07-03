package com.deepakrohan.expense.repo;

import com.deepakrohan.expense.entity.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {
}
