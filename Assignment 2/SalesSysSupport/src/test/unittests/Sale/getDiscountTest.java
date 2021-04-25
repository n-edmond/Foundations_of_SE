package test.unittests.Sale;

import junit.framework.TestCase;
import production.business.Item;
import production.business.Sale;

public class getDiscountTest extends TestCase {
	private Item item1 = new Item ("popcorn", 2.58, 1);
	private Item item2 = new Item ("icecream", 4.99, 2);
	private Item item3 = new Item ("apple", 1, 3);
	private Sale sale = new Sale();
	
	//tests that discount returns correct number value
	public void testGetDiscount() {
		sale.addItem(item1);
		sale.addItem(item2);
		sale.addItem(item3);
		double discount = sale.getDiscount();
		double expected_discount = .778;
		assertEquals(expected_discount, discount);
	}
	
	//tests that discount returns 0 if cart is empty
	public void testGetDiscountEmpty() {
		double discount = sale.getDiscount();
		double expected_discount = 0.0;
		assertEquals(expected_discount, discount);
	}
}
