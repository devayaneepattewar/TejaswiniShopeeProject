package com.tejaswiniShopee.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tejaswiniShopee.demo.entity.Customer;



public interface CustomerRepository extends JpaRepository<Customer,Long> {

	@Query("select new com.tejaswiniShopee.demo.entity.Customer(c.firstName,c.lastName) from com.tejaswiniShopee.demo.entity.Customer c where c.id = :id")
	Customer findCustomerFullNameById(@Param("id") long id);
	
	@Query("select c from com.tejaswiniShopee.demo.entity.Customer c ORDER BY c.firstName desc")
	List<Customer> findCustomerInDescOrder();

	
	
	List<Customer> findCustomerByFirstNameAndLastName(String firstName, String lastName);
}
