package org.shop.service;

public interface UserService {
	
	public int calcYearsSinceRegistration(Long userId);

	public int calcAppliedPercentageBaseUserDiscount(Long userId);

}
