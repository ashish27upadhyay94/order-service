package com.order.service.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.order.service.entity.Order;
import com.order.service.repository.OrderRepository;

@Repository
public class OrderDao {
	@Autowired
	private OrderRepository orderRepository;

	public Order createOrder(Order order) {
		return orderRepository.save(order);
	}
}
