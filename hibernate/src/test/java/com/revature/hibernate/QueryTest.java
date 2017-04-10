package com.revature.hibernate;

import org.junit.Ignore;
import org.junit.Test;

public class QueryTest {

	static TraineeDAO dao = new TraineeDAO();
	
	@Test
	@Ignore
	public void update(){
		Trainee obj = dao.get(109); // obj i snow "persisted"
		obj.setMajor("Nanotech");
		obj.setName("Danny J. Pickles");
		dao.update(obj);
	}
	
	@Test
	public void delete(){
		Trainee obj = dao.get(109);
		dao.delete(obj);
	}
	
	@Test
	@Ignore
	public void getAll(){
		for(Trainee t : dao.getAll())
			System.out.println(t);
		
		for(Trainee t : dao.findBy("cs"))
			System.out.println(t);
	}
	
	@Test
	@Ignore
	public void get(){
		System.out.println("GET: " + dao.get(1));
		System.out.println("GET: " + dao.get(9000));
	}
	
	@Test
	@Ignore
	public void load(){
		System.out.println("LOAD: " + dao.load(1));
		System.out.println("LOAD: " + dao.load(90000));
	}
	
	@Test
	@Ignore
	public void Test(){
		TraineeDAO dao = new TraineeDAO();
		System.out.println( dao.getById(60) );
	}
}
