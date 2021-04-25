package question5;

public class PrefCust extends Sale5 {
	
	public double getDiscountRate() {
	//left separated in case pref customer discount rate changes in the future
		DISCOUNT_RATE = .05;
		DISCOUNT_RATE += .15;
		DISCOUNT_RATE = Math.round(DISCOUNT_RATE * 100.0) / 100.0;
		return DISCOUNT_RATE;
	}
	
}