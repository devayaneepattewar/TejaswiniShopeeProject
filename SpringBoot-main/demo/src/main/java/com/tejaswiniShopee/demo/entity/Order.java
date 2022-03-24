package com.tejaswiniShopee.demo.entity;

import javax.persistence.Entity;

import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="orderTbl")

public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@ManyToMany
	@JoinTable(name="product_order",joinColumns= {@JoinColumn(name="order_id")},inverseJoinColumns= {@JoinColumn(name="product_id")})
	private List<Product>product;
	
	@ManyToOne
	@JoinTable(name="customer_order",joinColumns= {@JoinColumn(name="order_id")},inverseJoinColumns= {@JoinColumn(name="customer_id")})
	private Customer customer;
	

}
