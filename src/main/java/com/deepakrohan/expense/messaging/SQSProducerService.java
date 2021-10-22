package com.deepakrohan.expense.messaging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class SQSProducerService {
    private final QueueMessagingTemplate queueMessagingTemplate;

    @Value("${orders.queue.name}")
    private String ordersQ;

    @Autowired
    public SQSProducerService(QueueMessagingTemplate queueMessagingTemplate) {
        this.queueMessagingTemplate = queueMessagingTemplate;
    }


    public <T> void send(T message, Map<String, Object> headers) {
        if (message == null) {
            log.warn("SQS Producer cant produce 'null' value");
            return;
        }

        log.debug(" Messgae {} " + message);
        log.debug(" Queue name {} " + ordersQ);
        queueMessagingTemplate.convertAndSend(ordersQ, message, headers);
    }
}
