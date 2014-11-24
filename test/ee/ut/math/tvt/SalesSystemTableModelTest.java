package ee.ut.math.tvt;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.ui.model.StockTableModel;

public class SalesSystemTableModelTest {


  
  /**
   * Methods with @Before annotations will be invoked before each test is run.
   */
	public StockTableModel stModel;
	public StockItem item1;
  @Before
  public void setUp() {
	stModel = new StockTableModel();
    item1 = new StockItem();
    item1.setPrice(5);
    item1.setDescription("desc");
    item1.setId((long) 1);
    item1.setName("rumm");
    item1.setQuantity(1);
    
  }
  
  
  @Test
  public void testGetItemByName() {
	  stModel.addItem(item1);
	  assertEquals(1,stModel.getItemByName("rumm").getId(),0);
	  
  }
  
  @Test(expected = java.util.NoSuchElementException.class)
  public void testGetItemByNameThrowsException() {
	  stModel.addItem(item1);
	  assertEquals(1,stModel.getItemByName("rumm1").getId(),0);
	  
  }


  
}