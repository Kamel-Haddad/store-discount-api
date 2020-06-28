package org.shop.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Formatter;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.shop.model.Bill;
import org.shop.model.Discount;
import org.shop.model.Order;
import org.shop.model.User;
import org.shop.model.UserType;
import org.shop.repository.BillRepository;
import org.shop.repository.DiscountRepository;
import org.shop.repository.OrderRepository;
import org.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountServiceImpl implements DiscountService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private BillRepository billRepository;

	@Autowired
	private DiscountRepository discountRepository;

	public Bill generateBill(Long orderId) {
		Optional<Order> order = orderRepository.findById(orderId);
		if (order.isPresent()) {
			if (!(order.get().isBilled())) {
				User user = order.get().getUser();
				Bill bill = new Bill();
				bill.setOrder(order.get());
				bill.setBillingAddress("dummy address");
				bill.setShippingAddress("dummy address");
				
				Set<Discount> discounts = new HashSet<Discount>();

				Discount billDiscount = calcBillDiscount(order.get());
				discounts.add(billDiscount);
				
				Discount percentageBaseUserDiscount = calcPercentageBaseUserDiscount(user, order.get());
				if (percentageBaseUserDiscount != null) {
					bill.setTotalDiscount(
							billDiscount.getDiscountAmount().add(percentageBaseUserDiscount.getDiscountAmount()));
					discounts.add(percentageBaseUserDiscount);
				} else {
					bill.setTotalDiscount(billDiscount.getDiscountAmount());
				}
				bill.setTotalNonGroceriesAmount(order.get().calcTotalNonGroceriesAmount());
				
				bill.setTotalAmount(order.get().calcTotalAmount());
				
				bill.setDiscounts(discounts);

				bill = addBill(bill);			
				
				billDiscount.setBill(bill);
				addDiscount(billDiscount);
				
				percentageBaseUserDiscount.setBill(bill);
				addDiscount(percentageBaseUserDiscount);
				
				order.get().setBilled(true);
				updateOrder(order.get());

				return bill;
			}else {
				return billRepository.findByOrderOrderId(orderId).get(0);
			}
		}
		return null;

	}
	
	private Order updateOrder(Order order) {
		return orderRepository.save(order);
	}

	private Bill addBill(Bill bill) {
		return billRepository.save(bill);
	}

	private Discount addDiscount(Discount discount) {
		return discountRepository.save(discount);
	}

	private Discount calcBillDiscount(Order order) {
		Discount discount = new Discount();

		BigDecimal discountAmount = new BigDecimal(5.00)
				.multiply(new BigDecimal(order.calcTotalAmount().divide(new BigDecimal(100)).intValue()));
		discount.setDiscountAmount(discountAmount);

		String description = "For every $100 on the bill, there is $5 discount";
		discount.setDescription(description);

		return discount;
	}

	private Discount calcPercentageBaseUserDiscount(User user, Order order) {

		int discountPercentage = user.calcAppliedPercentageBaseUserDiscount();
		if (discountPercentage > 0) {
			Discount discount = new Discount();

			BigDecimal nonGroceriesAmount = order.calcTotalNonGroceriesAmount();
			BigDecimal discountAmount = new BigDecimal(discountPercentage / 100.00).multiply(nonGroceriesAmount)
					.setScale(2, RoundingMode.UP);
			discount.setDiscountAmount(discountAmount);

			StringBuilder sbuf = new StringBuilder();
			Formatter fmt = new Formatter(sbuf);
			if (user.getUserType() != UserType.CUSTOMER) {
				fmt.format("%s has a discount of %s%% on non-groceries items", user.getUserType().name(),
						discountPercentage);
			} else {
				fmt.format("two years older customer has a discount of %s%% on non-groceries items", discountPercentage);
			}
			String description = sbuf.toString();

			discount.setDescription(description);

			return discount;
		} else {
			return null;
		}

	}

}
