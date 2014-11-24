package ee.ut.math.tvt;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.HistoryItem;
import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.ui.model.HistoryTableModel;

public class HistoryTableModelTest {

	public StockItem item1;
	public SoldItem soldItem1;
	public HistoryItem historyItem1;
	public List<SoldItem> soldItemList;
	public HistoryTableModel htModel;
  
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
  public void testGetColumnValue() {
	  //TODO
	  /*
	  htModel = new HistoryTableModel();
	  htModel.addItem(historyItem1);
	  public List hilist = new List<>();
	  assertEquals(0,htModel.viewItem(historyItem1),0);  
	  */
  }
  
  
}
