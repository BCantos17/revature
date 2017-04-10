package com.revature.data;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class DAOImpl implements DAO, InitializingBean, DisposableBean, BeanNameAware, ApplicationContextAware{

	private String beanName;
	private ApplicationContext context;
	private String message;				// inject a value here 
	
	

	public void setMessage(String message) {
		this.message = message;
	}

	public DAOImpl() {
		System.out.println("Daoimpl Constructor");
	}
	
	public void deleteAll() {
		System.out.println("Deleting everything...");
	}

	/**
	 * Init-Method
	 */
	public void afterPropertiesSet() throws Exception {
		System.out.println("DAO Init-method");
	}

	/**
	 * Destroy-Method
	 * @throws Exception
	 */
	public void destroy() throws Exception {
		System.out.println("DAO destroy-method");
	}
	
	public void setBeanName(String beanName){
		this.beanName = beanName;
		System.out.println("Dao bean name is " +  beanName);
	}

	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
		System.out.println("DAO bean lives in " + context);
	}

}
