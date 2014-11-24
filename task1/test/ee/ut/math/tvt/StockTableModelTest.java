package ee.ut.math.tvt;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.ui.model.StockTableModel;

public class StockTableModelTest {


  
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
  public void testValidateNameUniqueness() {
	  stModel.addItem(item1);
	  stModel.addItem(item1);
	  assertEquals("rumm",stModel.getItemById(1).getName());
  }
  
  // TODO
  @Test
  public void testHasEnoughInStock() {

	  assertEquals(true,item1.getQuantity()>0);
  }
  
  @Test
  public void testGetItemByIdWhenItemExists() {
	  	//sstModel = new SalesSystemTableModel();
	  stModel.addItem(item1);
	  assertEquals("rumm",stModel.getItemById(1).getName());
	  
  }
  
  @Test(expected = java.util.NoSuchElementException.class)
  public void testGetItemByIdWhenThrowsException() {
	  assertEquals("rumm",stModel.getItemById(1).getName());
	  
  }


  
}