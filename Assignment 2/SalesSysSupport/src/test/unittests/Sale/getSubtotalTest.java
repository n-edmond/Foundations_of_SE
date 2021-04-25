package test.unittests.Sale;

import junit.framework.TestCase;
import production.business.Item;
import production.business.Sale;

public class getSubtotalTest extends TestCase {
	private Item item1 = new Item ("popcorn", 2.58, 1);
	private Item item2 = new Item ("icecream", 4.99, 2);
	private Item item3 = new Item ("apple", 1, 3);
	private Sale sale = new Sale();
	
	//tests that the GetSubtotal function is adding items into the list correctly
	public void testGetSubtotal() {
		sale.addItem(item1);
		sale.addItem(item2);
		sale.addItem(item3);
		double output = sale.getSubTotal();
		double expected_output = 15.56;
		assertEquals(expected_output, output);
	}
	
	//tests that getSubtotal returns 0 if nothing is in the list
	public void testGetSubtotalEmptyList() {
		double output = sale.getSubTotal();
		double expected_output = 0.0;
		assertEquals(expected_output, output);
	}
	
	
}
