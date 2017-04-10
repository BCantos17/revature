package com.revature.springdata.tomcat.data;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.lang.String;
import com.revature.springdata.tomcat.data.Customer;

/**
 * Spring Data generates all the MongoDB JDBC code
 * @author bcant
 *
 */
public interface CustomerRepository extends MongoRepository<Customer, Integer>{

	<S extends Customer> S save(S customer);
	
	List<Customer> findAll();
	
	Customer findOne(Integer id);
	
	//Retrieve by Age
	List<Customer> findByAge(int age);
	
	List<Customer> findByLastname(String lastname);
}
