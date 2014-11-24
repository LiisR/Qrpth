package ee.ut.math.tvt;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;

public class SoldItemTest {

public StockItem item1;
public SoldItem soldItem1;
  
  /**
   * Methods with @Before annotations will be invoked before each test is run.
   */
  @Before
  public void setUp() {
    item1 = new StockItem();
    item1.setPrice(19.99);
  }

  @Test
  public void testGetSum() {
	  soldItem1 = new SoldItem(item1, 3);
	  assertEquals(59.97,soldItem1.getSum(),0);
  }
  
  // TODO
  @Test
  public void testGetSumWithZeroQuantity() {
	  soldItem1 = new SoldItem(item1,0);
	  assertEquals(0,soldItem1.getSum(),0);
  }


  
}