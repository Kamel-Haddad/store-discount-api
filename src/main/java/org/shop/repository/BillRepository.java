package org.shop.repository;

import java.util.List;

import org.shop.model.Bill;
import org.shop.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends CrudRepository<Bill, Long> {
	List<Bill> findByOrderOrderId(Long orderId);
}
