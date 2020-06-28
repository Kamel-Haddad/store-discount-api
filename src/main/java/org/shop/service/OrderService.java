package org.shop.service;

import java.util.Optional;

import org.shop.model.Order;

public interface OrderService {
	
	public Optional<Order> getOrder(Long orderId);

}
