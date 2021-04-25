package question2;

import java.util.ArrayList;

public class Sale2 {

	//REMOVED DISCOUNT RATE INTILIZATIN TO .05
	private static double DISCOUNT_RATE;
	private ArrayList<Item> itemList = new ArrayList<Item>();
	//ADDED DISCOUNT TYPE INSTANCE VARIABLE
	private int discount_type;
	
	//ADDED CONSTRUCTOR
	public Sale2(int discount_num) {
		this.discount_type = discount_num;
	}

	public void addItem(Item item) {
		itemList.add(item);
	}

	//MADE CHANGE TO THIS FUCNTION. ADDED SWTICH STATMENT
	public double getDiscountRate(){
		//only valid choices are 0 (std), 1(senior), 2(pref cust)
		DISCOUNT_RATE = 0.05;
		switch (discount_type) {
		  case 0:
			  break;
		  case 1:
			  DISCOUNT_RATE += .10;
		    break;
		  case 2:
		    ;
		    DISCOUNT_RATE += .15;
		    break;
		  default:
		    System.out.println("Invalid Discout Type. Only standard discount will be applied");
		}
		return DISCOUNT_RATE; 
	}	

	//MADE CHANGE TO THIS FUNCTION. REFRACTORED
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
	
	//MADE CHANGE TO THIS FUNCTION. REFRACTORED
	public double getDiscountedSubTotal() {
		double sub_tot = getSubTotal();
		double discount_rate = getDiscount ();
		double disc_sub = sub_tot - discount_rate;
		//this should round the subtotal to 2 decimal places
		double rounded_disc = Math.round(disc_sub *100.0) / 100.0;
		return rounded_disc;
	}

}
