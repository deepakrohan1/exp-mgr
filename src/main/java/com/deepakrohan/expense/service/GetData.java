package com.deepakrohan.expense.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class GetData {

    @Autowired
    WebClient.Builder webBuilder;



    public String someData() {
        return webBuilder.build()
                .get()
                .uri("")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
