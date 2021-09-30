package com.deepakrohan.expense.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class AuditFields {
    public Timestamp createdTime;
    @UpdateTimestamp
    public Timestamp updatedTime;
    @CreationTimestamp
    public String userCreated;
    public String dateCreated;

}
