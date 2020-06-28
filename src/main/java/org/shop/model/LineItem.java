package org.shop.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import org.shop.model.key.LineItemKey;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "line_items", schema = "shop")
@Getter @Setter
public class LineItem {
	@EmbeddedId
	private LineItemKey id;
	
	@JsonBackReference
	@ManyToOne
    @MapsId("order_id")
    @JoinColumn(name = "order_id")
    Order order;
 
	@JsonManagedReference
	@ManyToOne
    @MapsId("product_id")
    @JoinColumn(name = "product_id")
    Product product;
	
	private Integer quantity;
	
	private BigDecimal unitPrice;
	
	/**
	 * return the total amount for a Line Item <br/>
	 * total amount = unitPrice * quantity
	 * @return
	 */
	public BigDecimal getLineAmount() {
		return unitPrice.multiply(new BigDecimal(quantity));
	}
	
	
}
