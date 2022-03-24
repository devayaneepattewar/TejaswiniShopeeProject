package com.tejaswiniShopee.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity(name="productTbl")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long id;
	@Column(name="product_name")
	private String productName;
	@Column(name="category")
	private String Category;
	@Column(name="price")
	private int price;
	@Column(name="quantity")
	private int quantity;
	
	@ManyToMany
	@JoinTable(name="customer_product",joinColumns= {@JoinColumn(name="product_id")},inverseJoinColumns= {@JoinColumn(name="customer_id")})
	private List<Customer>customer;
	/*@ManyToOne
	@JoinTable(name="customer_address",joinColumns= {@JoinColumn(name="address_id")},inverseJoinColumns= {@JoinColumn(name="customer_id")})
	private Customer customer;*/
	
	
	public List<Customer> getCustomer() {
		return customer;
	}
	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", Category=" + Category + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
