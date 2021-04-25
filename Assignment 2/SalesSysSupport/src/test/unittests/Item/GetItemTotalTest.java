package test.unittests.Item;

import junit.framework.TestCase;
import production.business.Item;


//DONE
public class GetItemTotalTest extends TestCase {
	private Item items = new Item ("popcorn", 2.58, 3);
	
	public void testGetItemTotal(){
		double total = items.getItemTotal();
		double expected_total = 7.74;
		assertEquals(expected_total, total);
		
		}
	
}
