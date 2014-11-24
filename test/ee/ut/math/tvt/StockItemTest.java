package ee.ut.math.tvt;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.StockItem;


public class StockItemTest {

	public StockItem item1, item2;
    /**
     * Methods with @Before annotations will be invoked before each test is run.
     */
    @Before
    public void setUp() {
        item1 = new StockItem();
        item1.setPrice(19.99);
    }

    // TODO
    @Test
    public void testClone() {
    	item2 = new StockItem();
    	item2 = (StockItem) item1.clone();
    	assertEquals(item2.getPrice(),item1.getPrice(),0);
    }


    // TODO
    @Test
    public void testGetColumn() {
    	item1.setQuantity(45);
    	assertEquals(45,item1.getColumn(3));
    }

    
}
