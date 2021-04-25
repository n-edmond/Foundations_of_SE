package production.business;

/*
 * Complete the Item class (and the Sales class if you don�t use Java). 
 * The instance variables of Item should at least include title, original unit price, 
 * and quantity (4 points). Also write a xUnit test class for each of the methods getDiscount, 
 * getSubTotal, getDiscountedSubTotal so that the Sale class is fully tested (3 points).
 * Provide a description about how you created the Item class and ensured that it is fully
 * tested (2 points). Attach a screenshot of your test execution (1 point).
 */

public class Item {
	private String title;
	private double org_unit_price;
	private int qty;
	
	public Item(String tit, double org_u_p, int q) {
		this.title = tit.toLowerCase();
		this.org_unit_price = org_u_p;
		this.qty = q;
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
	
	public double getItemTotal() {
		double price = getOrgUnitPrice();
		int quant = getQty();
		double total = price * quant;
		return total;
	}
	
	public static boolean isTitleValid(String title){
		// check if title is valid
		
		//if there is no title, it is not valid
		if(title.length()==0) {
			return false;
		}
				
		//iterate through title
		for(int i = 0; i < title.length(); i++) {
			//if a character in the string is a number return that it is not valid
			if (Character.isDigit(title.charAt(i))) {
				return false;
			}
		}
		//return true otherwise
		return true;
	}
}