package com.revature.hibernate;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.revature.beans.Child;
import com.revature.beans.Parent;
import com.revature.beans.Phone;
import com.revature.beans.Toy;

public class FamilyTest {
	private SessionFactory sf = new Configuration().configure().buildSessionFactory();
	
	@Test
	public void testMapping(){
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		Phone phone1 = new Phone("555-1234");
		Phone phone2 = new Phone("555-5678");
				
		Parent dad = new Parent("Dan Pickles", phone1 );
		Parent mom = new Parent("Donna Pickles", phone2 );
		Set<Parent> couple = new HashSet<Parent>();
		couple.add(dad); couple.add(mom);
		
		Child son = new Child("Howard Johnson", couple);
		Child daughter = new Child("Randolph Scott", couple);
		
		dad.getKids().add(son); dad.getKids().add(daughter);
		mom.getKids().add(son); mom.getKids().add(daughter);
		
		session.save(dad); session.save(mom);
		// buy kids toys
		Toy woody = new Toy("Woody", true, son);
		Toy buzz = new Toy("Buss Lightbeer", false, daughter);
	}
}
