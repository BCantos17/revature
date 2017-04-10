package com.revature.orm;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Card;

public class ContextualSessionTest {
	public static ApplicationContext ctxt;
	
	@BeforeClass
	public static void setup(){
		ctxt = new ClassPathXmlApplicationContext("beans.xml");
	}
	
	@Test
	public void create(){
		ctxt.getBean(DAO.class).insert(new Card("Spaces", 10));
	}
}
