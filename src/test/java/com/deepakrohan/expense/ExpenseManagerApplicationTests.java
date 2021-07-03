package com.deepakrohan.expense;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ExpenseManagerApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testWork() {
		String s = "^[0-9]{8}$";
		System.out.println("12345".matches(s));
		System.out.println("12345789".matches(s));
		System.out.println("123457890".matches(s));
		System.out.println("AAABBBCCC".matches(s));
		System.out.println("00000ABCDE".matches(s));

	}
}
