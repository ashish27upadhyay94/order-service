package com.order.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.order.service.dto.OrderDto;
import com.order.service.entity.Order;
import com.order.service.events.EventHelper;
import com.order.service.layer.OrderService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class OrdersController {
	
	@Autowired
	private OrderService orderService;

	@Autowired
	EventHelper eventHelper;

	@RequestMapping(value = "/create/order", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Order placeOrder(@RequestBody OrderDto order) {
		log.info("Request create order {}",order);
		Order response =orderService.createOrder(order);
		eventHelper.generateEvent(order);
		log.info("Response create order {}",response);
		return null;

	}
}
