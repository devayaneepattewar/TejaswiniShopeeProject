package com.tejaswiniShopee.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tejaswiniShopee.demo.entity.Customer;
import com.tejaswiniShopee.demo.exception.ResourceNotFoundException;
import com.tejaswiniShopee.demo.repository.CustomerRepository;
import com.tejaswiniShopee.demo.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService{
	private CustomerRepository customerRepository;

	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Override
	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer getCustomerById(long id) throws ResourceNotFoundException {
		Optional<Customer> customer = customerRepository.findById(id);
		if (customer.isPresent()) {
			return customer.get();
		} else {
			throw new ResourceNotFoundException("Customer", "Id", id);
		}

	}

	@Override
	public Customer updateCustomer(Customer customer, long id) {
		Customer cust = new Customer();
		try {
			cust = customerRepository.findById(id).orElseThrow(
					()-> new ResourceNotFoundException("Customer","Id",id));
		
			}catch (ResourceNotFoundException e) {
				e.printStackTrace();
			}
		cust.setFirstName((customer).getFirstName());
		cust.setLastName(customer.getLastName());
		
		customerRepository.save(cust);
		return cust;
	}
	

	
	@Override
	public void deleteCustomer(long id) {
		customerRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Customer","Id",id));
		customerRepository.deleteById(id);
	}

	@Override
	public Customer getCustomerFullNameById(long id) {
		return customerRepository.findCustomerFullNameById(id);
	}

	@Override
	public List<Customer> getCustomerInDescOrder() {
		return customerRepository.findCustomerInDescOrder();
	}

	@Override
	public List<Customer> getCustomerByFirstNameAndLastName(String firstName, String lastName) {
		return customerRepository.findCustomerByFirstNameAndLastName(firstName,lastName);
	}

	

	

	
	


}
