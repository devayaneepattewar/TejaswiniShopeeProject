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
import org.springframework.web.bind.annotation.RestController;

import com.tejaswiniShopee.demo.entity.Order;
import com.tejaswiniShopee.demo.service.OrderService;

@RestController
@RequestMapping("/api/order")

public class OrderController {

private OrderService orderService;
	
	public OrderController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}
	@PostMapping
	public ResponseEntity<Order> saveOrder(@RequestBody Order order){
		return new ResponseEntity<Order>(orderService.saveOrder(order),HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Order> getAllOrder()
	{
		return orderService.getAllOrder();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Order>getOrderById(@PathVariable("id") long id){
		return new ResponseEntity<Order>(orderService.getOrderById(id),HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Order>
	updateOrder(@PathVariable("id") long id, @RequestBody Order order){
		return new ResponseEntity<Order>(orderService.updateOrder(order,id),HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String>deleteOrder(@PathVariable("id")long id){
		orderService.deleteOrder(id);
		return new ResponseEntity<String>("Order record deleted Successfully",HttpStatus.OK);
	}

}
