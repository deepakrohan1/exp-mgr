package com.deepakrohan.expense.controller;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.text.NumberFormat;
import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ExpensesController.class)
public class ExpensesControllerTest {

    @Autowired
    public MockMvc mockMvc;

    @Autowired
    NumberFormat nf;

    @Autowired
    ApplicationContext ac;

    @Before
    public void preSetup() {
        int count = ac.getBeanDefinitionCount();
        System.out.println(String.format("Number of Beans %d" , count));
        String[] names = ac.getBeanDefinitionNames();
        Arrays.stream(names)
                .sorted()
                .forEach(System.out::println);
    }

    @Test
    public void test_expensesControllerGetMethod() throws Exception {
        mockMvc.perform( MockMvcRequestBuilders
                .get("/v1/expenses")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void numberFormatterTest() {
        double amount = 1324334.1232233;
        System.out.println(nf.format(amount));
    }

}