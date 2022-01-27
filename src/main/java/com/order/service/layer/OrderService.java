package com.order.service.layer;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.order.service.dao.OrderDao;
import com.order.service.dto.OrderDto;
import com.order.service.entity.Order;
import com.order.service.enums.OrderStatus;
import com.order.service.events.EventHelper;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class OrderService {
	@Autowired
	private OrderDao dao;

	@Autowired
	EventHelper eventHelper;

	@Transactional(readOnly = false)
	public Order createOrder(OrderDto order) {
		Order response = dao.createOrder(populateEntity(order));
		return response;
	}

	private Order populateEntity(OrderDto order) {
		Optional<OrderDto> orderDto = Optional.of(order);
		Order orderEntity = new Order();
		orderDto.ifPresent(dto -> {
			orderEntity.setOrderStatus(OrderStatus.SUCCESS);
			orderEntity.setPrice(dto.getPrice());
			orderEntity.setProductId(dto.getProductId());
			orderEntity.setQuantity(dto.getQuantity());
			orderEntity.setUserId(dto.getUserId());
		});
		return orderEntity;

	}
}
