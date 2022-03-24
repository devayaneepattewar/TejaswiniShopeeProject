package com.tejaswiniShopee.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tejaswiniShopee.demo.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

	Address save(Address address);

	List<Address> findAll();

	Optional<Address> findById(Long id);

	
	void deleteById(long id);

	
}
