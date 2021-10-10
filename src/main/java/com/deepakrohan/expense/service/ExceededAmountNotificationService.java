package com.deepakrohan.expense.service;

import com.deepakrohan.expense.config.JmsMessageConverter;
import com.deepakrohan.events.ExceededCostNotificationEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ExceededAmountNotificationService {
    private JmsTemplate jmsTemplate;

    public ExceededAmountNotificationService(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void triggerNotification(ExceededCostNotificationEvent ex) {
        log.info("Trigger Notification for Queue {}", JmsMessageConverter.MESSAGE_QUEUE_NAME);
        jmsTemplate.convertAndSend(JmsMessageConverter.MESSAGE_QUEUE_NAME, ex);
    }

}
