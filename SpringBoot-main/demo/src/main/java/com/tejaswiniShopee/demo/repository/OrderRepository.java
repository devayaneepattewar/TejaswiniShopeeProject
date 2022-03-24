package com.tejaswiniShopee.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tejaswiniShopee.demo.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Long>{

	Order save(Order order);

	List<Order> findAll();

	Optional<Order> findById(long id);

	void deleteById(long id);

	
}
