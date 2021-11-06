package com.deepakrohan.expense.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageDto implements Serializable {

    public static final Long serialVersionUID = 1L;

    private UUID id;
    private String message;
    private String email;


}
