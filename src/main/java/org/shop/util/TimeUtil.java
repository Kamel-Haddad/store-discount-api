package org.shop.util;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.util.Date;
/**
 * 
 * @author Kamel Haddad
 *
 */
public class TimeUtil {
	
	public static long yearsSince(Timestamp timestamp) {
		return yearsBetween(timestamp, currentTimestamp());
	}
	
	public static long yearsBetween(Timestamp timestamp1,Timestamp timestamp2) {
		long milliseconds = timestamp2.getTime() - timestamp1.getTime();
		return ((long) milliseconds / 1000)/3600/24/365;
	}
	
	public static Timestamp currentTimestamp() {
		Date date = new Date();
        return new Timestamp(date.getTime());
	}
	
	
	public static void main(String argv[]) {
		System.out.println(new BigDecimal(55.22).divide(new BigDecimal(100.0)).intValue());
		System.out.println((new BigDecimal(30/100.00).multiply(new BigDecimal(400.40))).setScale(2,RoundingMode.UP));
		System.out.println(new BigDecimal(30).divide( new BigDecimal(100)).multiply(new BigDecimal(400.40)));
		System.out.println((new BigDecimal(5.00).multiply(new BigDecimal( new BigDecimal(990.55).divide(new BigDecimal(100)).intValue()))).setScale(2).toString());		
		
	}
}



	
