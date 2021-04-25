package question5;

import java.util.ArrayList;


abstract public class Sale5 {

	protected static double DISCOUNT_RATE = .05;
	protected int day;
	private ArrayList<Item5> itemList = new ArrayList<Item5>();
	
	
	public void setDay( int day_num) {
		this.day = day_num;
	}

	public void addItem(Item5 item) {
		itemList.add(item);
	}
	
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
		for (Item5 item: itemList) {
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
	
	//NEW FUNCTION. BUY ONE GET ONE
	public double bogo() {
		double bogo_discount = 0.0;
		double discounted_qty;
		double new_price;
		double half_off;
		double old_price;
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).recieveDiscountCheck()) {
				
				old_price = itemList.get(i).getItemTotal();
				half_off = itemList.get(i).halfOffPrice();
				discounted_qty = itemList.get(i).getQty() - 1;
				new_price = discounted_qty * half_off;
				bogo_discount = old_price - new_price;
				
			}
		}
		return bogo_discount;
	}
}
