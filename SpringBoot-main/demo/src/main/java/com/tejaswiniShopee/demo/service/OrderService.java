package com.tejaswiniShopee.demo.service;

import java.util.List;

import com.tejaswiniShopee.demo.entity.Order;

public interface OrderService {

	Order saveOrder(Order order);

	List<Order> getAllOrder();

	Order getOrderById(long id);

	Order updateOrder(Order order, long id);

	void deleteOrder(long id);

	

	

	

}
