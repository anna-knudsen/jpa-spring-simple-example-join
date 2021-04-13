package com.example.demo.jpa;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
	CustomerEntity findCustomerByCustomerId(int id);
	Set<OrderEntity>  findOrdersByCustomerId(int id);
}
