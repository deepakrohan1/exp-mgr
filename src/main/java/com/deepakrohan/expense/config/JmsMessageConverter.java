package com.deepakrohan.expense.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

/**
 * JmsMessageConverter is a class to deal with queue name
 */

@Configuration
public class JmsMessageConverter {
    public static final String MESSAGE_QUEUE_NAME = "my-exp-notification";

    /**
     * A bean to manage the message converter. We are transmitting the message as type
     * TEXT
     * @return
     */
    @Bean
    public MessageConverter messageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
//        converter.setObjectMapper(mapper);
        return converter;
    }
}
