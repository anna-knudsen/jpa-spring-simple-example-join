package com.example.demo.controller;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.jpa.CustomerEntity;
import com.example.demo.jpa.CustomerRepository;
import com.example.demo.jpa.OrderEntity;

@RestController
@RequestMapping("orders")
public class Controller {
	
	private final Logger LOGGER = LoggerFactory.getLogger(Controller.class);
	
	private final CustomerRepository repository;
	public Controller(CustomerRepository repository) {
		this.repository = repository;
	}

	@GetMapping("{id}")
	public Set<OrderEntity> getOrdersForCustomer(@PathVariable int id) {
		CustomerEntity customerEntity = repository.findCustomerByCustomerId(id);
		
		return customerEntity.getOrdersList();
	}
}