package org.shop.model;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "products", schema = "shop")
@Getter @Setter
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long productId;
	
	
	@JsonBackReference
	@OneToMany(mappedBy = "product")
    Set<LineItem> lineItems;
	
	private String name;	
	
	private BigDecimal unitPrice;
	
	@Enumerated(EnumType.STRING)
	private ProductType productType;
	
}
