package ee.ut.math.tvt.salessystem.domain.data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Already bought StockItem. SoldItem duplicates name and price for preserving history. 
 */

public class HistoryItem implements Cloneable, DisplayableItem{

	    private Long id;
	    
	    private List<SoldItem> soldItem;
	    
	    private double TotalPrice;
	    private double index;
	    
	    private String name;
	    
	    private String DateAsStrig;
	    private String TimeAsString;
	    
	    
	    
	    public HistoryItem(List<SoldItem> soldItem, int index) {
	        this.soldItem = soldItem;
	        this.index = index;
	        
	        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	        DateFormat timeFormat = new SimpleDateFormat("h:mm a");
	        
	        Date purTime = new Date();
	        DateAsStrig = dateFormat.format(purTime);
	        TimeAsString = timeFormat.format(purTime);
	        
	    }
	    
	    public Long getId() {
			return id; 
		}



		public void setId(Long id) {
			this.id = id;
		}



		public List<SoldItem> getSoldItem() {
			return soldItem;
		}



		public void setSoldItem(List<SoldItem> soldItem) {
			this.soldItem = soldItem;
		}



		public double getTotalPrice() {
			return TotalPrice;
		}



		public void setTotalPrice(double totalPrice) {
			TotalPrice = totalPrice;
		}



		public double getIndex() {
			return index;
		}



		public void setIndex(double index) {
			this.index = index;
		}



		public String getName() {
			return name;
		}



		public void setName(String name) {
			this.name = name;
		}


		public String getDateAsStrig() {
			return DateAsStrig;
		}



		public void setDateAsStrig(String dateAsStrig) {
			DateAsStrig = dateAsStrig;
		}



		public String getTimeAsString() {
			return TimeAsString;
		}



		public void setTimeAsString(String timeAsString) {
			TimeAsString = timeAsString;
		}



		


}