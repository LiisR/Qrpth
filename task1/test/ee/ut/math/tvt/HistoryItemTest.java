package ee.ut.math.tvt;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.HistoryItem;
import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;

public class HistoryItemTest {

	public StockItem item1;
	public SoldItem soldItem1;
	public HistoryItem historyItem1;
	public List<SoldItem> soldItemList;
  
  /**
   * Methods with @Before annotations will be invoked before each test is run.
   */
  @Before
  public void setUp() {
	    item1 = new StockItem();
	    item1.setPrice(19.99);
	    item1.setDescription("asd");
	    item1.setId((long) 22);
	    item1.setName("kurk");
	    item1.setQuantity(2);
	    soldItem1 = new SoldItem(item1, 3);
		historyItem1 = new HistoryItem();
  }

  @Test
  public void testAddSoldItem() {
	  /*
	  soldItemList.add(soldItem1);
	  historyItem1.setSoldItem(soldItemList);
	  assertEquals(historyItem1.getSoldItem(),soldItemList);
	  */
  }
  
  @Test
  public void testGetSumWithNoItems() {
	  assertEquals(0,historyItem1.getTotalPrice(),0);  
  }

  @Test
  public void testGetSumWithOneItem() {
	  historyItem1.setSoldItem(soldItemList);
	  assertEquals(19.99,historyItem1.getTotalPrice(),0);
  }
  
  @Test
  public void testGetSumWithMultipleItems() {}
  

  
}
