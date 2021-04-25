package question5;

public class Item5 {
	private String title;
	private double org_unit_price;
	private int qty;
	private boolean receive_discount_flag;
	
	/*
	 * Constructor
	 * param item_name is the name of the item, org_price is original unit price, discount is the bool flag
	 */
	public Item5(String item_name, double org_price, int quantity, boolean discount) {
		this.title = item_name.toLowerCase();
		this.org_unit_price = org_price;
		this.qty = quantity;
		this.receive_discount_flag = discount;
	}
	
	//GETTERS
	public String getTitle() {
		return title;	
	}
		
	public double getOrgUnitPrice() {
		return org_unit_price;
	}

		
	public int getQty() {
		return qty;	
	}
		
	/* NEW FUNCTION ADDED
	 * function reduces price of original item
	 * return reduced price
	 */
	public double halfOffPrice() {
		double half_off = org_unit_price / 2.0;
		return half_off;
	}

	/*
	 * function gets the total price of the item
	 * return total cost
	 */
	public double getItemTotal() {
		double total = qty * org_unit_price;
		return total;
	}
	
	/* NEW FUNCTION ADDED
	 * function checks if this particular item is flagged to receive the bogo discount
	 * return true if set to receive discount, else false
	 */
	public boolean recieveDiscountCheck() {
		if (receive_discount_flag && qty > 1) {
			return true;
		}
		return false;
	}
}