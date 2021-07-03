package com.deepakrohan.expense.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.NumberFormat;
import java.util.Locale;

@Configuration
public class FormatterConfig {

    @Bean
    public NumberFormat defaultNumberFormat() {
        return NumberFormat.getCurrencyInstance(Locale.getDefault());
    }
}
