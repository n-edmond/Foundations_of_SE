package question3;

import java.util.ArrayList;

public class Sale3 {

	private static double DISCOUNT_RATE;
	private ArrayList<Item> itemList = new ArrayList<Item>();
	private int discount_type;
	//ADDED DAY INSTANCE VARIABLE
	private int day;
	
	//ADDED DAY TO CONSTRUCTOR
	public Sale3(int discount_num, int day_num) {
		this.discount_type = discount_num;
		this.day = day_num;
	}

	public void addItem(Item item) {
		itemList.add(item);
	}

	//MADE CHANGE TO THIS FUCNTION. ADDED IF STATEMENT
	public double getDiscountRate(){
		//only valid choices are 0 (std), 1(senior), 2(pref cust)
		DISCOUNT_RATE = 0.05;
		switch (discount_type) {
		  case 0:
			  break;
		  case 1:
			  //checks if the senior discount should be applied. Note that 2 represents Tuesdays
			  if (seniorDiscCheck()) {
				  DISCOUNT_RATE += .10; 
			  }
			  
		    break;
		  case 2:
		    ;
		    DISCOUNT_RATE += .15;
		    break;
		  default:
		    System.out.println("Invalid Discout Type. Only standard discount will be applied");
		}
		DISCOUNT_RATE = Math.round(DISCOUNT_RATE * 100.0) / 100.0;
		return DISCOUNT_RATE; 
	}	

	public double getDiscount(){
		double sub_tot = getSubTotal();
		double discount_rate = getDiscountRate();
		double discount = sub_tot * discount_rate;
		//this should round the discount to 2 decimal places
		double rounded_discount = Math.round(discount * 100.0) / 100.0;
		return rounded_discount;
	}	

	
	public double getSubTotal() {
		double subTotal = 0.0;
		for (Item item: itemList) {
			subTotal += item.getItemTotal();
		}	
		return subTotal;
	}
	
	public double getDiscountedSubTotal() {
		double sub_tot = getSubTotal();
		double discount_rate = getDiscount ();
		double disc_sub = sub_tot - discount_rate;
		//this should round the subtotal to 2 decimal places
		double rounded_disc = Math.round(disc_sub *100.0) / 100.0;
		return rounded_disc;
	}
	
	//ADDED THIS FUNCTION
	public boolean seniorDiscCheck() {
		//if the day is 2 (which represents a tuesday, return that the senior discount is applied
		if (day == 2 && discount_type == 1) {
			return true;
		}
		//return false otherwise
		return false;
	}

}
