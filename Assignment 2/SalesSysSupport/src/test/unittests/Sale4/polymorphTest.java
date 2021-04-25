package test.unittests.Sale4;

import junit.framework.TestCase;
import question4.Item;
import question4.PrefCust;
import question4.Senior;


public class polymorphTest extends TestCase {
	private Item item1 = new Item ("popcorn", 2.58, 1);
	private Item item2 = new Item ("icecream", 4.99, 2);
	private Item item3 = new Item ("apple", 1, 3);
	private PrefCust prefcust = new PrefCust();
	private Senior senior = new Senior();
	
	
	public void testGetSeniorDiscVal() {
		//displays the senior discount rate
		senior.setDay(2);
		System.out.println(senior.getDiscountRate());
	}
	
	public void testSeniorDiscApplied(){
		senior.addItem(item1);
		senior.addItem(item2);
		senior.addItem(item3);
		senior.setDay(2);
		//because this person is a senior and it is tuesday the discount should be applied to the cart
		double discount = senior.getDiscount();
		//this is what the discount should amount to
		double expected_discount = 2.33;
		//System.out.println(discount);
		//this will check if they are equivalent
		assertEquals(expected_discount, discount);
	}
	
	public void testSeniorDiscNotAppliedNotSenior() {
		prefcust.addItem(item1);
		prefcust.addItem(item2);
		prefcust.addItem(item3);
		prefcust.setDay(2);
		
		//because this person is not a senior, even though it is tuesday, they should only get their pref_cust discount
		double discount = prefcust.getDiscount();
		double expected_discount = 3.11;
		System.out.println(discount);
		assertEquals(expected_discount, discount);
	}

	//DOESNT WORK
	public void testSeniorDiscNotApplied() {
		senior.addItem(item1);
		senior.addItem(item2);
		senior.addItem(item3);
		senior.setDay(1);
		
		double discount = senior.getDiscount();
		double expected_discount = .78;
		System.out.println(discount);
		assertEquals(expected_discount, discount);
	}
	

}
