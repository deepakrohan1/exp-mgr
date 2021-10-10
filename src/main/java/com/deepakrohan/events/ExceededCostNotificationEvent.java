package com.deepakrohan.events;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExceededCostNotificationEvent {
    private UUID id;
    private String email;
    private BigDecimal amount;
    private String messageContent;
}
