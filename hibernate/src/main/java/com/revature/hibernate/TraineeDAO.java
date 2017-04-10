package com.revature.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class TraineeDAO {
	private SessionFactory sf = new Configuration().configure().buildSessionFactory();
	
	public List<Trainee> criteria(){
		/*
		 * Programmatically build queries. 0SQL, 0HQL.. call methods
		 */
		
		Criteria criteria = sf.openSession().createCriteria(Trainee.class);
		// adding restictions to the resultset
		
		// Where Trainee_id between 1 and 5
		criteria.add(Restrictions.between("id", 1, 5)); 
		// And major is not null
		criteria.add(Restrictions.isNotNull("major"));
		// And trainee_name like %Dan%
		criteria.add(Restrictions.like("name", "%Dan%"));
		// Order y trainee Id
		criteria.addOrder(Order.desc("name"));
		
		return criteria.list();
		
		/**
		 * Restrictions == WHERE clause
		 * Projections === Aggregate function
		 * 
		 * return session.createCriteria(Trainee.class)
		 * 			add(Restrictions.between("id", 1, 5)); 
		 * 			add(Restrictions.isNotNull("major"));
		 * 			add(Restrictions.like("name", "%Dan%"));
		 * 			addOrder(Order.desc("name"));
		 * 			.list()
		 */
		
		/**
		 * getAll()
		 * 	return session.createCriteria(Trainee.class).list()
		 */
	}
	
	public void update( Trainee trainee ){
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		/* Can use HQL to only update specific fields or a record 
		 * He didnt do it because he was too lazy
		 * query.executeUpdate()
		 */
		session.saveOrUpdate(trainee);
		tx.commit();
	}
	
	public void delete( Trainee trainee ){
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(trainee);
		tx.commit();
	}
	
	public Trainee load( int id ){
		return (Trainee) sf.openSession().load(Trainee.class, id);
	}
	
	public List<Trainee> getAll(){
		Session session = sf.openSession();
		Query query = session.createQuery("from com.revature.hibernate.Trainee");
		return query.list();
	}
	
	public List<Trainee> findBy( String major ){
		Session session = sf.openSession();
		String HQL = "from Trainee where major = :q";
		Query query = session.createQuery( HQL );
		query.setString("q", major);
		return query.list();
	}
	
	public Trainee get( int id ){
		return (Trainee) sf.openSession().get(Trainee.class, id);
	}
	
	public Trainee getById(int id){
		Session session = sf.openSession();
		// HQL -> Hibernate Qery Langauge 
		// Object-oriented SQL
		// #1 benefit == decoupled DAO from DB. no reliance on SQL dialects
		//String HQL = "Select * FROM TRAINEE WHERE TRAINEE_ID = ?";
		String HQL = "FROM com.revature.hibernate.Trainee "
				+ "WHERE TRAINEE_ID = :pk";
		Query query= session.createQuery(HQL);
		query.setInteger("pk", id);
		Trainee trainee = (Trainee) query.uniqueResult();
		return trainee;
	}
	
	
	public void insert(Trainee trainee){
		// dont do this... use singleton session factory
		
		SessionFactory sf = new Configuration()
				.configure("hibernate.cfg.xml").buildSessionFactory();
		// open a session... always use session per http request
		Session session = sf.openSession();
		// begin transaction
		Transaction tx =  session.beginTransaction();
		session.save(trainee);
		// commit
		tx.commit();
		// always close session
		session.close();
	}
}