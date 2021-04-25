package test.unittests.Item;

import junit.framework.TestCase;
import production.business.Item;

//DONE
public class GetOrgUnitPriceTest extends TestCase {
	private Item items = new Item ("popcorn", 2.58, 3);
	
	public void testGetUnitPrice() {
		double total = items.getOrgUnitPrice();
		double expected_total = 2.58;
		assertEquals(expected_total, total);
	}
}
