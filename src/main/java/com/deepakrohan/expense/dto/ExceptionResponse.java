package com.deepakrohan.expense.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ExceptionResponse {
    private LocalDateTime timeOfException;
    private String exception;
    private String description;
}
