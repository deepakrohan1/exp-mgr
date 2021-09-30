package com.deepakrohan.expense.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
@Entity(name = "categories")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    @NotEmpty
    @Length(min = 5, max = 25)
    @Column(name = "category_name")
    private String expenseCat;
    @Column(name = "category_description")
    private String expenseCatDesc;
    @Column(name = "category_added")
    private LocalDateTime timeCategoryCreated;
    @Column(name = "category_limit")
    private BigDecimal amtCategoryAlloted;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    public Timestamp createdTime;
    @UpdateTimestamp
    @Column(name = "updated_at")
    public Timestamp updatedTime;
    @Column(name = "created_by")
    public String userCreated;
    @Column(name = "updated_by")
    public String dateCreated;

}

