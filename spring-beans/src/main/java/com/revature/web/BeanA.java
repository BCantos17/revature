package com.revature.web;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/*
 * DAO class
 * @Respository declares this as a spring bean
 */
@Repository(value="beanA")
@Scope(value="prototype")
public class BeanA implements InitializingBean{

	public BeanA(){
		System.out.println("Bean A");
	}

	public void afterPropertiesSet() throws Exception {
		
	}
	
}
