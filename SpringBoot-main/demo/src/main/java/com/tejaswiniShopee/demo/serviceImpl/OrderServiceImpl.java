package com.tejaswiniShopee.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tejaswiniShopee.demo.entity.Order;
import com.tejaswiniShopee.demo.exception.ResourceNotFoundException;
import com.tejaswiniShopee.demo.repository.OrderRepository;
import com.tejaswiniShopee.demo.service.OrderService;

@Service

public class OrderServiceImpl implements OrderService {

	private OrderRepository orderRepository;

	public OrderServiceImpl(OrderRepository orderRepository) {
		super();
		this.orderRepository = orderRepository;
	}

	@Override
	public Order saveOrder(Order order) {
		return orderRepository.save(order);

	}

	@Override
	public List<Order> getAllOrder() {
		return orderRepository.findAll();

	}

	@Override
	public Order getOrderById(long id) {
		Optional<Order> order = orderRepository.findById(id);
		if (order.isPresent()) {
			return order.get();
		} else {

			throw new ResourceNotFoundException("Order", "Id", id);
		}

	}

	@Override
	public Order updateOrder(Order order, long id) {
		Order orderobj = new Order();
		try {

			orderobj = orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order", "Id", id));
		} catch (Exception e) {

			e.printStackTrace();
		}

		orderRepository.save(orderobj);
		return orderobj;
	}

	@Override
	public void deleteOrder(long id) {
		orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order", "Id", id));

		orderRepository.deleteById(id);

	}

}
