package org.shop.repository;

import java.util.List;

import org.shop.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
    List<Order> findByUserUserId(Long userId);
}