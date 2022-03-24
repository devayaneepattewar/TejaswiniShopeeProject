package com.tejaswiniShopee.demo.entity;

import javax.persistence.*;

@Entity(name = "addressTbl")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long id;
	@Column(name = "house_name")
	private String houseName;
	@Column(name = "house_number")
	private String houseNumber;
	@Column(name = "colony")
	private String colony;
	@Column(name = "landmark")
	private String landmark;
	@Column(name = "city")
	private String city;
	@Column(name = "district ")
	private String district;
	@Column(name = "state")
	private String state;
	@Column(name = "pincode")
	private int pincode;
	
	@ManyToOne
	@JoinTable(name="customer_address",joinColumns= {@JoinColumn(name="address_id")},inverseJoinColumns= {@JoinColumn(name="customer_id")})
	private Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getHouseName() {
		return houseName;
	}
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	public String getColony() {
		return colony;
	}
	public void setColony(String colony) {
		this.colony = colony;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public Address(long id, String houseName, String colony, String landmark, String city, String district,
			String state, int pincode) {
		super();
		this.id = id;
		this.houseName = houseName;
		this.colony = colony;
		this.landmark = landmark;
		this.city = city;
		this.district = district;
		this.state = state;
		this.pincode = pincode;
	}
	public Address() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", houseName=" + houseName + ", colony=" + colony + ", landmark=" + landmark
				+ ", city=" + city + ", district=" + district + ", state=" + state + ", pincode=" + pincode + "]";
	}
	
	public String getFirstName() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setFirstName(String fname) {
		// TODO Auto-generated method stub
		
	}
	public Object getLastName() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getEmail() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setLastName(Object lastName) {
		// TODO Auto-generated method stub
		
	}
	public void setEmail(Object email) {
		// TODO Auto-generated method stub
		
	}

	
	
}

