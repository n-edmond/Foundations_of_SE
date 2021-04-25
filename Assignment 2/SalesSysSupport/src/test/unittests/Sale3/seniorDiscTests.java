package test.unittests.Sale3;

import junit.framework.TestCase;
import question3.Item;
import question3.Sale3;

//DONE
public class seniorDiscTests extends TestCase {
	private Item item1 = new Item ("popcorn", 2.58, 1);
	private Item item2 = new Item ("icecream", 4.99, 2);
	private Item item3 = new Item ("apple", 1, 3);
	private Sale3 sale_senior = new Sale3(1,2);
	private Sale3 wrong_day_senior = new Sale3(1,3);
	private Sale3 pref_cust = new Sale3(2,2);
	

	//WORKS
	public void testGetSeniorDiscVal() {
		//displays the senior discount rate
		System.out.println(sale_senior.getDiscountRate());
	}
	
	public void testSeniorDiscApplied(){
		sale_senior.addItem(item1);
		sale_senior.addItem(item2);
		sale_senior.addItem(item3);
		//because this person is a senior and it is tuesday the discount should be applied to the cart
		double discount = sale_senior.getDiscount();
		//this is what the discount should amount to
		double expected_discount = 2.33;
		System.out.println(discount);
		//this will check if they are equivalent
		assertEquals(expected_discount, discount);
	}
	
	public void testSeniorDiscNotAppliedNotSenior() {
		pref_cust.addItem(item1);
		pref_cust.addItem(item2);
		pref_cust.addItem(item3);
		
		//because this person is not a senior, even though it is tuesday, they should only get their standard discount
		double discount = pref_cust.getDiscount();
		double expected_discount = 3.11;
		System.out.println(discount);
		assertEquals(expected_discount, discount);
	}

	//WORKS
	public void testSeniorDiscNotApplied() {
		wrong_day_senior.addItem(item1);
		wrong_day_senior.addItem(item2);
		wrong_day_senior.addItem(item3);
		
		double discount = wrong_day_senior.getDiscount();
		double expected_discount = .78;
		System.out.println(discount);
		assertEquals(expected_discount, discount);
	}
	

}
