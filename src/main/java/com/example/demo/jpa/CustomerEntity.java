package com.example.demo.jpa;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.Set;

import javax.persistence.Column;

@Entity
@Table(name = "customers")
public class CustomerEntity {

	@Column(name = "customer_name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Id
	@Column(name = "customer_id")
	private int customerId;
	
	@OneToMany (fetch = FetchType.LAZY)
	@JoinColumn (name = "customer_id", referencedColumnName = "customer_id")
	private Set<OrderEntity> ordersList;

	public Set<OrderEntity> getOrdersList() {
		return ordersList;
	}

}