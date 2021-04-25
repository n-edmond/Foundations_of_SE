package production.business;

import java.util.ArrayList;

public class Sale {

	private static double DISCOUNT_RATE = 0.05;
	

	private ArrayList<Item> itemList = new ArrayList<Item>();

	public void addItem(Item item) {
		itemList.add(item);
	}

	public double getDiscountRate(){
		return DISCOUNT_RATE;
	}	

	//UNIT TESTING PART 1
	public double getDiscount(){
		return getSubTotal()*getDiscountRate();
	}	

	//UNIT TESTING PART 1
	public double getSubTotal() {
		double subTotal = 0.0;
		for (Item item: itemList) {
			subTotal += item.getItemTotal();
		}	
		return subTotal;
	}
	
	//UNIT TESTING PART 1
	public double getDiscountedSubTotal() {
		return getSubTotal() - getDiscount();
	}

}
