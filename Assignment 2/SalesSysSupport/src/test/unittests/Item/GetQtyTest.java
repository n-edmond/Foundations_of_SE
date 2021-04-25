package test.unittests.Item;

import junit.framework.TestCase;
import production.business.Item;



public class GetQtyTest extends TestCase {
	private Item items = new Item ("popcorn", 2.58, 3);
	
	public void testGetUnitPrice() {
		int qty = items.getQty();
		int expected_qty = 3;
		assertEquals(expected_qty, qty);
	}
}
