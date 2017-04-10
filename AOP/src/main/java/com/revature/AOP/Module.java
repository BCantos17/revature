package com.revature.AOP;

import org.springframework.stereotype.Service;

/**
 * 	Not concern with Logging at all.
 * @author bcant
 *
 */
@Service
public class Module {
	public void doWork(){
		System.out.println("public void doWork()");
	}
	
	public void doWork( String a){
		System.out.println("public void doWork( String a)");
	}
	
	public void doWork( String a, int b ){
		System.out.println("public void doWork( String a, int b )");
	}
	
	public void doWork( String a, String b){
		System.out.println("public void doWork( String a, String B)");
	}
	
}
