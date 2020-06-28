package org.shop.controller;

import java.util.Optional;

import org.shop.model.Bill;
import org.shop.model.LineItem;
import org.shop.model.Order;
import org.shop.service.DiscountService;
import org.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
@Api(value = "Order Controller", description = "Order Controller")

@CrossOrigin(origins = "*", allowedHeaders = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.PATCH, RequestMethod.DELETE })
@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	DiscountService discountService;
	
	@Autowired
	OrderService orderService;
	
	@GetMapping(value = "/{id}/bill", produces = "application/json")
	@ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody Bill generateBill(@PathVariable("id") Long id) {
        Bill bill = discountService.generateBill(id);
        return bill;
    }
	
	@GetMapping(value = "/{id}", produces = "application/json")
	@ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody Order getOrder(@PathVariable("id") Long id) {
        Optional<Order> order = orderService.getOrder(id);
        if(order.isPresent()) {
	        return order.get();
        }
        return null;
    }

}
