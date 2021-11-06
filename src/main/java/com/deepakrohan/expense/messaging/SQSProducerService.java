package com.deepakrohan.expense.messaging;

import com.deepakrohan.expense.dto.MessageDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

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


    public void send(String message, Map<String, Object> headers) {
        if (message == null) {
            log.warn("SQS Producer cant produce 'null' value");
            return;
        }

        MessageDto messageDto = MessageDto
                .builder()
                .email("deepakrohan@hotmail.com")
                .message(message)
                .id(UUID.randomUUID())
                .build();
        log.debug(" Message {} " + message);
        log.debug(" Queue name {} " + ordersQ);
        queueMessagingTemplate.convertAndSend(ordersQ, messageDto, headers);
    }
}
