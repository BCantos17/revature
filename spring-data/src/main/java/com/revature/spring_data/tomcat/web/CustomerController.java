package com.revature.spring_data.tomcat.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.spring_data.tomcat.service.CustomerMongoService;
import com.revature.springdata.tomcat.data.Customer;

@RestController
public class CustomerController {
	private CustomerMongoService service;

	@Autowired
	public void setService(CustomerMongoService service) {this.service = service;}
	
	@RequestMapping(value="/customer/save", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	<S extends Customer> S save(@RequestBody S customer){
		return service.save(customer);
	}
	
	@RequestMapping(value="/customer", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	List<Customer> findAll(){
		return service.findAll();
	}
	
	@RequestMapping(value="/customer/{id}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	Customer findOne(@PathVariable Integer id){
		return service.findOne(id);
	}
	
	@RequestMapping(value="/customer/{age}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	List<Customer> findByAge(@PathVariable int age){
		return service.findByAge(age);
	}
	
}
