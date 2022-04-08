package com.tejaswiniShopee.demo;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.tejaswiniShopee.demo.entity.Customer;
import com.tejaswiniShopee.demo.repository.CustomerRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class customerRepositoryTests {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Test
	@Rollback(false)
	public void saveCustomerTest() {
		Customer customer = customerRepository.save(new Customer("Tejaswini","Pattewar",1890365993,"Ambajogai"));
	Assertions.assertThat(customer.getId()).isGreaterThan(0);
	}
	
	@Test
	public void getCustomerTest() {
		Customer customer = customerRepository.findById(2L).get();
		
		Assertions.assertThat(customer.getId()).isEqualTo(2L);
	}
	
	@Test
	public void getCustomerListTest() {
		List<Customer> customers = customerRepository.findAll();
		Assertions.assertThat(customers.size()).isGreaterThan(0);
	}
	
	@Test
	@Rollback(false)
	public void updateCustomerTest() {
		Customer customer = customerRepository.findById(3L).get();
		customer.setCity("Beed");
		Customer updated = customerRepository.save(customer);
		Assertions.assertThat(customer.getCity()).isEqualTo("Beed");
	}
	
	@Test
	public void deleteCustomerTest() {
		Customer cust = customerRepository.findById(3L).get();
		customerRepository.delete(cust);
		Customer customer = null;
		Optional<Customer> cust1 = customerRepository.findByCity("Beed");
		if(cust1.isPresent()) {
			customer = cust1.get();
		}
		
		Assertions.assertThat(customer).isNull();
	}
}
