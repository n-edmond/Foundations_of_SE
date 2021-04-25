package question5;

public class Senior extends Sale5 {
	
	public double getDiscountRate() {
		//if the day is 2 (which represents a tuesday, return that the senior discount is applied
		if (day == 2) {
			//left separated in case senior discount rate changes in the future
			DISCOUNT_RATE = .05;
			DISCOUNT_RATE += .10;
			DISCOUNT_RATE = Math.round(DISCOUNT_RATE * 100.0) / 100.0;
		}
		return DISCOUNT_RATE;
	}
}