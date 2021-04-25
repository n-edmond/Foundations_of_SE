package test.unittests.Sale2;

import junit.framework.TestCase;
import question2.Item;
import question2.Sale2;

public class getDiscountTest2 extends TestCase {
	private Item item1 = new Item ("popcorn", 2.58, 1);
	private Item item2 = new Item ("icecream", 4.99, 2);
	private Item item3 = new Item ("apple", 1, 3);
	private Sale2 sale_senior = new Sale2(1);
	private Sale2 sale_pref_cust = new Sale2(2);
	private Sale2 standard_cust = new Sale2(0);
	private Sale2 invalid_disc_type = new Sale2(55);
	
	//tests that discount returns correct number value
	public void testGetDiscountSenior() {
		sale_senior.addItem(item1);
		sale_senior.addItem(item2);
		sale_senior.addItem(item3);
		
		double discount = sale_senior.getDiscount();
		double expected_discount = 2.33;
		//System.out.println(discount);
		assertEquals(expected_discount, discount);	
	}
	
	public void testGetDiscountPrefCust() {
		sale_pref_cust.addItem(item1);
		sale_pref_cust.addItem(item2);
		sale_pref_cust.addItem(item3);
		
		double discount = sale_pref_cust.getDiscount();
		double expected_discount = 3.11;
		//System.out.println(discount);
		assertEquals(expected_discount, discount);
	}
	
	public void testGetDiscountStd() {
		standard_cust.addItem(item1);
		standard_cust.addItem(item2);
		standard_cust.addItem(item3);
		
		double discount = standard_cust.getDiscount();
		double expected_discount = .78;
		//System.out.println(discount);
		assertEquals(expected_discount, discount);	
	}
	
	//tests that discount returns 0 if cart is empty
	public void testGetDiscountEmpty() {
		double discount = sale_senior.getDiscount();
		double expected_discount = 0.0;
		assertEquals(expected_discount, discount);
	}
	
	public void testGetDiscountInvalidDiscountType() {
		invalid_disc_type.addItem(item1);
		invalid_disc_type.addItem(item2);
		invalid_disc_type.addItem(item3);
		
		double discount = invalid_disc_type.getDiscount();
		double expected_discount = .78;
		//System.out.println(discount);
		assertEquals(expected_discount, discount);
	}
}