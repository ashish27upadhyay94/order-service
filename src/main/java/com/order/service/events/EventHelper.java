package com.order.service.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

import com.order.service.dto.OrderDto;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class EventHelper {

	@Autowired
	private StreamBridge streamBridge;
	public void generateEvent(OrderDto orderEvent) {
		streamBridge.send("order-out-0", orderEvent);
		log.info("event send create order, event: {}",orderEvent);
	}

}
