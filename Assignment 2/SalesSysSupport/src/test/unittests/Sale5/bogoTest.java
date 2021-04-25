package test.unittests.Sale5;

import junit.framework.TestCase;
import question5.Item5;
import question5.Senior;


public class bogoTest extends TestCase {
	private Item5 item1 = new Item5 ("popcorn", 2.58, 20, false);
	private Item5 item2 = new Item5 ("icecream", 4.99, 3, true);
	private Item5 item3 = new Item5 ("apple", 1, 1, true);
	private Item5 item4 = new Item5 ("rice", 3.25, 3, true);
	private Senior senior = new Senior();
	
	public void testBogoSmallCart(){
		senior.setDay(1);
		senior.addItem(item2);
		double bogo = senior.getSubTotal();
		System.out.println(bogo);
		double expected_bogo = 9.98;
		assertEquals(expected_bogo, bogo);
	}
	
	public void testBogoLargeCart() {
		senior.setDay(1);
		senior.addItem(item2);
		senior.addItem(item4);
		double bogo = senior.getSubTotal();
		System.out.println(bogo);
		//(bogo for icecream will cost 9.98) + (bogo for rice will cost 6.50)
		double expected_bogo = 16.48;
		assertEquals(expected_bogo, bogo);
	}
	
	public void testBogoOnlyAppItems() {
		senior.setDay(1);
		senior.addItem(item2);
		senior.addItem(item1);
		double bogo = senior.getSubTotal();
		System.out.println(bogo);
		
		//(bogo for icecream = 9.98) + (std price for popcorn = 51.60)
		double expected_bogo = 61.58;
		assertEquals(expected_bogo, bogo);
	}
	
	public void testBogoNotAppliedWrongQty() {
		assertFalse(item3.recieveDiscountCheck());
		System.out.println("Discount not granted. Must have at least 2 of the same items. testBogoNotAppliedWrongQty()");
		
	}
	
	public void testBogoNotAppliedFlagNotSet() {
		assertFalse(item1.recieveDiscountCheck());
		System.out.println("Discount not applicable for this item. testBogoNotAppliedFlagNotSet()");
		
	}
	
	public void testBogoNotAppliedSubtotal() {
		senior.setDay(1);
		senior.addItem(item1);
		double price = senior.getSubTotal();
		System.out.println(price);
		double expected_price = 51.60;
		assertEquals(expected_price, price);
	}
	
}