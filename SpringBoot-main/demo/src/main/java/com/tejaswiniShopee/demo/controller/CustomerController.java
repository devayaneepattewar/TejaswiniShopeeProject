package com.tejaswiniShopee.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tejaswiniShopee.demo.entity.Customer;
import com.tejaswiniShopee.demo.service.CustomerService;
@RestController()
@RequestMapping("api/customer")

public class CustomerController {
	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	@PostMapping
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<Customer>(customerService.saveCustomer(customer), HttpStatus.CREATED);
	}

	@GetMapping
	public List<Customer> getAllCustomer() {
		return customerService.getAllCustomer();
	}

	@GetMapping("{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") long id) {
		return new ResponseEntity(customerService.getCustomerById(id), HttpStatus.OK);
	}
	
	@GetMapping("/customerFullNameById/{id}")
	public Customer getCustomerFullNameById(@PathVariable("id") long id){
		return customerService.getCustomerFullNameById(id);
	}

	@GetMapping("/CustomerInDescOrder")
	public List<Customer> getCustomerInDescOrder(){
		return customerService.getCustomerInDescOrder();
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer){
		return new ResponseEntity<Customer>(customerService.updateCustomer(customer, id),HttpStatus.OK);
	}
	
	//employeeByFirstName/john/lastname/deo
	@GetMapping("/employeeByFirstNameAndLastName")
	public List<Customer> getcustomerByFirstNameAndLastName(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName)
	{
		return customerService.getCustomerByFirstNameAndLastName(firstName, lastName);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") long id){
		customerService.deleteCustomer(id);
		return new ResponseEntity<String>("Employee record deleted",HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
