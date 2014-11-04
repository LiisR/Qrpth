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
	    
	    private double price;
	    private double index;
	    
	    private String date;
	    private String time;
	    
	    
	    public HistoryItem(List<SoldItem> soldItem, int index) {
	        this.soldItem = soldItem;
	        this.index = index;
	        
	        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	        DateFormat timeFormat = new SimpleDateFormat("h:mm a");
	        
	        Date purTime = new Date();
	        date = dateFormat.format(purTime);
	        time = timeFormat.format(purTime);
	        
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


		public double getPrice() {
			return price;
		}


		public void setPrice(double price) {
			this.price = price;
		}


		public double getIndex() {
			return index;
		}


		public void setIndex(double index) {
			this.index = index;
		}


		public String getDate() {
			return date;
		}


		public void setDate(String date) {
			this.date = date;
		}


		public String getTime() {
			return time;
		}


		public void setTime(String time) {
			this.time = time;
		}


		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return null;
		}


}
