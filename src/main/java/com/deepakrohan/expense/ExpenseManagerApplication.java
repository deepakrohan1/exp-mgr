package com.deepakrohan.expense;

import org.hibernate.validator.spi.messageinterpolation.LocaleResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.annotation.WebServlet;
import java.util.Locale;

@SpringBootApplication
public class ExpenseManagerApplication {
	@Bean
	public ServletRegistrationBean h2servletRegistration() {
		ServletRegistrationBean registration = new ServletRegistrationBean(new org.h2.server.web.WebServlet());
		registration.addUrlMappings("/console/*");
		return registration;
	}

	// TODO New property added spring.messages.basename=messages
//	@Bean
//	public ResourceBundleMessageSource bundleMessageSource() {
//		ResourceBundleMessageSource bundleMessageSource = new ResourceBundleMessageSource();
//		bundleMessageSource.setBasename("messages");
//		return bundleMessageSource;
//	}

	@Bean
	public AcceptHeaderLocaleResolver localeResolver() {
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}
	public static void main(String[] args) {
		SpringApplication.run(ExpenseManagerApplication.class, args);
	}

}
