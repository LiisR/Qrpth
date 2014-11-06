package ee.ut.math.tvt.salessystem.domain.data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



/**
 * Already bought StockItem. SoldItem duplicates name and price for preserving history. 
 */

@Entity
@Table(name = "HISTORYITEM")
public class HistoryItem implements Cloneable, DisplayableItem{

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	
		@OneToMany
		  @JoinTable(name="SOLD_AND_HISTORY",
		      joinColumns=@JoinColumn(name="HISTORY_ID", referencedColumnName="HISTORY_ID"),
		      inverseJoinColumns=@JoinColumn(name="SOLDITEM_ID", referencedColumnName="SOLDITEM_ID"))
		
	    private List<SoldItem> soldItem;
	     
	    @Column(name = "TOTALPRICE")
	    private double TotalPrice;
	    
	    
	    @Column(name = "DATE")
	    private String DateAsStrig;
	    
	    @Column(name = "TIME")
	    private String TimeAsString;
	    
	    public HistoryItem(List<SoldItem> soldItem, long id) {
	        this.soldItem = soldItem;
	        
	        this.id = id;
	        
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

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return null;
		}



		


}