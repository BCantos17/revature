package com.revature.spring_data.tomcat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.revature.springdata.tomcat.data.Customer;
import com.revature.springdata.tomcat.data.CustomerRepository;

@Service
public class CustomerMongoService {
	private CustomerRepository repository;
	
	@Autowired
	public void setRepository(CustomerRepository repository){
		this.repository = repository;
	}
	
	public <S extends Customer> S save(S customer){
		return repository.save(customer);
	}
	
	public List<Customer> findAll(){
		return repository.findAll();
	}
	
	public Customer findOne(Integer id){
		return repository.findOne(id);
	}
	
	public List<Customer> findByAge(int age){
		return repository.findByAge(age);
	}
	
}
