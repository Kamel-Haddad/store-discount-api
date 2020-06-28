package org.shop.service;

import java.util.Optional;

import org.shop.model.Order;
import org.shop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderRepository orderRepository;

	@Override
	public Optional<Order> getOrder(Long orderId) {
		
		return orderRepository.findById(orderId);
	}

	
	
}