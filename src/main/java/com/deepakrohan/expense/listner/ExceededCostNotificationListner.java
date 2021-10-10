package com.deepakrohan.expense.listner;


import com.deepakrohan.events.ExceededCostNotificationEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;

import javax.jms.Message;

//@Component
@Slf4j
public class ExceededCostNotificationListner {

//    @JmsListener(destination = JmsMessageConverter.MESSAGE_QUEUE_NAME)
    public void listeningToQueue (@Payload ExceededCostNotificationEvent exceededCostNotificationEvent,
                                  @Headers MessageHeaders headers, Message message) {
        log.info ("received..");
        log.info ("Message received: {}", message);
        System.out.println(exceededCostNotificationEvent.toString());

    }

}
