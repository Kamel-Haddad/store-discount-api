package org.shop.model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.shop.util.TimeUtil;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users", schema = "shop")
@Getter @Setter
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userId;
	
	@Enumerated(EnumType.STRING)
	private UserType userType;
	
	@JsonBackReference
	@OneToMany(mappedBy = "user")
    Set<Order> orders;
	
	private String firstName;
	
	private String lastName;
	
	private Timestamp registrationDate;
	
	
	/**
	 * calculate since how many years the user was registered 
	 * @param user
	 * @return
	 */
	public long calcYearsSinceRegistrationDate() {
		return TimeUtil.yearsSince(registrationDate);
		
	}
	/**
	 * calculate the applied percentage base user discount
	 * @param user
	 * @return
	 */

	public int calcAppliedPercentageBaseUserDiscount() {
		
		switch (userType) {
		case EMPLOYEE:
			return 30;
		case AFFILIATE:
			return 10;
		case CUSTOMER:
			if (calcYearsSinceRegistrationDate()>2) {
				return 5;
			}else {
				return 0;
			}
		default:
			return 0;
		}
	}
	
}
