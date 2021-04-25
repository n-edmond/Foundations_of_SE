package question4;

import java.util.ArrayList;

abstract public class Sale4 {

	protected static double DISCOUNT_RATE = .05;
	protected int day;
	private ArrayList<Item> itemList = new ArrayList<Item>();
	
	//ADDED DAY SETTER
	public void setDay( int day_num) {
		this.day = day_num;
	}

	public void addItem(Item item) {
		itemList.add(item);
	}

	//MADE CHANGE TO THIS FUCNTION. MADE ABSTRACT
	public abstract double getDiscountRate();	

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
}
