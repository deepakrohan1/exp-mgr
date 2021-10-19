package com.deepakrohan.expense.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "expenses")
public class Expense extends AuditFields {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expense_id")
    private Long expId;
    @Column(name = "expense_in_brief")
    private String expenseInBrief;
    @Column(name = "expense_description")
    private String expenseDescription;
    @Column(name = "amount_spent")
    private BigDecimal amountSpent;
    @Column(name = "lx_image_url")
    private String lxImageUrl;
    @Column(name = "sm_image_url")
    private String smImageUrl;
//    @Column(name = "category_id")
//    private Long categoryId;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


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