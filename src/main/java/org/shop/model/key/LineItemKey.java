package org.shop.model.key;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter @Setter @EqualsAndHashCode
public class LineItemKey implements Serializable {
    
	private static final long serialVersionUID = 7539635464088238567L;

	@Column(name = "order_id")
    Long orderId;
 
    @Column(name = "product_id")
    Long productId;
 
   
}

