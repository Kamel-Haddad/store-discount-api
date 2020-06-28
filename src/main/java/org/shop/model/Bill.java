package org.shop.model;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "bills", schema = "shop")
@Getter @Setter
public class Bill {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long billId;
	
	@OneToOne
	@JoinColumn(name="order_id", nullable=false)
    private Order order;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "bill")
    Set<Discount> discounts;
	
	private String billingAddress;
	private String shippingAddress;
	
	
	private BigDecimal totalDiscount;
	private BigDecimal totalAmount;
	private BigDecimal totalNonGroceriesAmount;
	
	
	public BigDecimal getPayableAmount() {
		if (totalDiscount!=null && totalAmount!=null) {
			return totalAmount.subtract(totalDiscount);
		}
		return null;
	}
	

}
