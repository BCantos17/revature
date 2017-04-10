package com.revature.AOP;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {
	private static ApplicationContext context;

	@BeforeClass
	public static void setup(){
		context = new ClassPathXmlApplicationContext("aop2.xml");
	}
	
	@Test
	public void hello(){
		context.getBean("module", Module.class);
	}
}
