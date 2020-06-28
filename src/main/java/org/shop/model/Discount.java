package org.shop.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "discounts", schema = "shop")
@Getter @Setter
public class Discount {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@SequenceGenerator(name= "VOCABULARY_SEQUENCE", sequenceName = "VOCABULARY_SEQUENCE_ID", initialValue=1, allocationSize = 1)
	//@GeneratedValue(strategy=GenerationType.AUTO, generator="VOCABULARY_SEQUENCE")
	private Long discountId;
	
	@JsonBackReference
	@ManyToOne
    @JoinColumn(name = "bill_id")
    private Bill bill;
	
	private String description;
	
	private BigDecimal discountAmount; 

}
