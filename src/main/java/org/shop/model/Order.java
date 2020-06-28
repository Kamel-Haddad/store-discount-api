package org.shop.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orders", schema = "shop")
@Getter @Setter
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long orderId;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "order")
    Set<LineItem> lineItems;
	
	@JsonManagedReference
	@ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;
	
	private Timestamp orderDate;
	
	private boolean billed;
	
	
	/**
	 * calculate the total amount of non groceries items
	 */
	public BigDecimal calcTotalNonGroceriesAmount() {
		
		BigDecimal amount = new BigDecimal(0);
		for (LineItem lineItem : lineItems) {
			if(lineItem.product.getProductType()==ProductType.OTHERS) {
				amount = amount.add(lineItem.getLineAmount());
			}
		}
		return amount;
		
	}
	
	/**
	 * calculate the total amount of the order
	 */
	public BigDecimal calcTotalAmount() {
		BigDecimal amount = new BigDecimal(0);
		for (LineItem lineItem : lineItems) {
			amount = amount.add(lineItem.getLineAmount());
		}
		return amount;
	}

}
