package org.shop.service;

import org.shop.model.Bill;

public interface DiscountService{
	/**
	 * create new bill if the order was not bill 
	 * or return the associated bill if the order was already billed
	 * @param orderId
	 * @return Bill
	 */
	public Bill generateBill(Long orderId);
}
