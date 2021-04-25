package test.unittests.Sale;

import junit.framework.TestCase;
import production.business.Item;
import production.business.Sale;

public class getDiscountedSubtotalTest extends TestCase {
	private Item item1 = new Item ("popcorn", 2.58, 1);
	private Item item2 = new Item ("icecream", 4.99, 2);
	private Item item3 = new Item ("apple", 1, 3);
	private Sale sale = new Sale();
	
	//tests that discount returns correct number value
		public void testGetDiscountedSubtotal() {
			sale.addItem(item1);
			sale.addItem(item2);
			sale.addItem(item3);
			double subtotal = sale.getDiscountedSubTotal();
			double expected_subtotal = 14.782;
			assertEquals(expected_subtotal, subtotal);
		}
		
		//tests that discount returns 0 if cart is empty
		public void testGetDiscountedSubtotalEmpty() {
			double subtotal = sale.getDiscountedSubTotal();
			double expected_subtotal = 0.0;
			assertEquals(expected_subtotal, subtotal);
		}

}