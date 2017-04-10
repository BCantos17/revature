package com.revature.soap_client;

import com.revature.soap_server.HelloWorld;
import com.revature.soap_server.HelloWorldImplService;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		HelloWorld sei = new HelloWorldImplService().getHelloWorldImplPort();
		sei.sayHi("Super Dan");
	}
}
