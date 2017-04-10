package com.revature.data;

import org.springframework.beans.factory.annotation.Autowired;

public class Facade {
	
	//@Autowired // can just use either this or the XML
	private DAO dao; // Spring says: here's your bean
	
	/**
	 * Constructor-Injection
	 * @param dao
	 */
	public Facade(DAO dao){
		System.out.println("Facade(DAO dao) constructor");
	}
	
	public Facade(){
		System.out.println("facade constructor");
	}
	
	/**
	 * Custom init-method
	 */
	public void initialize(){
		System.out.println("init method");
	}
	
	/**
	 * Custom destroy-method
	 */
	public void cleanup(){
		System.out.println("destroy method");
	}
	/**
	 * SETTER-INJECTION 
	 * Spring says: here's your bean
	 * @param dao
	 */
	public void setDao(DAO dao) {
		System.out.println("Facade setting dao");
		this.dao = dao;
	}

	public void deleteAll(){
		//open a session
		// start a tx
		dao.deleteAll();
		//commit
		//close session
	}
}
