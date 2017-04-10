package com.revature.AOP;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Aspect module that addresses the Logging cross cutting concer
 */

@Aspect 
public class LoggingAspect {
	
	@Before("stub()") // before pointcut
	public void logNoArg(){
		System.out.println("Before no-arg method is invoked ");
	}
	
	/**
	 * 
	 * POINTCUTS BELOW
	 * 
	 */
	
	@Pointcut("exection(public void doWork())") // pointcut experssion
	public void stub(){}
}
