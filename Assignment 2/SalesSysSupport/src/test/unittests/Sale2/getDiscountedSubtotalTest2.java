package test.unittests.Sale2;

import junit.framework.TestCase;
import question2.Item;
import question2.Sale2;

public class getDiscountedSubtotalTest2 extends TestCase {
	private Item item1 = new Item ("popcorn", 2.58, 1);
	private Item item2 = new Item ("icecream", 4.99, 2);
	private Item item3 = new Item ("apple", 1, 3);
	private Sale2 sale_senior = new Sale2(1);
	private Sale2 sale_pref_cust = new Sale2(2);
	private Sale2 standard_cust = new Sale2(0);
	private Sale2 invalid_disc_type = new Sale2(55);
	
	//tests that discount returns correct number value
		public void testGetDiscountedSubtotalSenior() {
			sale_senior.addItem(item1);
			sale_senior.addItem(item2);
			sale_senior.addItem(item3);
			double subtotal = sale_senior.getDiscountedSubTotal();
			double expected_subtotal = 13.23;
			assertEquals(expected_subtotal, subtotal);
		}
		public void testGetDiscountedSubtotalPrefCust() {
			sale_pref_cust.addItem(item1);
			sale_pref_cust.addItem(item2);
			sale_pref_cust.addItem(item3);
			double subtotal = sale_pref_cust.getDiscountedSubTotal();
			double expected_subtotal = 12.45;
			assertEquals(expected_subtotal, subtotal);
		}
		public void testGetDiscountedSubtotalStdCust() {
			standard_cust.addItem(item1);
			standard_cust.addItem(item2);
			standard_cust.addItem(item3);
			double subtotal = standard_cust.getDiscountedSubTotal();
			double expected_subtotal = 14.78;
			assertEquals(expected_subtotal, subtotal);
		}
		public void testGetDiscountedSubtotalInvalidDiscType() {
			invalid_disc_type.addItem(item1);
			invalid_disc_type.addItem(item2);
			invalid_disc_type.addItem(item3);
			double subtotal = invalid_disc_type.getDiscountedSubTotal();
			double expected_subtotal = 14.78;
			assertEquals(expected_subtotal, subtotal);
		}
		
		//tests that discount returns 0 if cart is empty
		public void testGetDiscountedSubtotalEmpty() {
			double subtotal = sale_senior.getDiscountedSubTotal();
			double expected_subtotal = 0.0;
			assertEquals(expected_subtotal, subtotal);
		}

}