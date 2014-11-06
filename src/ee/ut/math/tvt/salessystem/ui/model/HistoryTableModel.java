package ee.ut.math.tvt.salessystem.ui.model;


import java.util.List;

import ee.ut.math.tvt.salessystem.domain.data.DisplayableItem;
import ee.ut.math.tvt.salessystem.domain.data.HistoryItem;
import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.ui.model.PurchaseInfoTableModel;

public class HistoryTableModel extends SalesSystemTableModel<HistoryItem> {
	
	private List <HistoryItem> historyItemsList;
	
	public HistoryTableModel () {
		super(new String[] {"Date", "Time", "Sum"});
	}

    @Override
    protected Object getColumnValue(HistoryItem item, int columnIndex) {
            switch (columnIndex) {
            case 0:
                    return item.getDateAsStrig();
            case 1:
                    return item.getTimeAsString();
            case 2:
            		return item.getTotalPrice();
            }
            throw new IllegalArgumentException("Column index out of range");
    }
 
	public List<HistoryItem> getHistoryItemsList() {
		return historyItemsList;
	}

	public void setHistoryItemsList(List<HistoryItem> historyItemsList) {
		this.historyItemsList = historyItemsList;
	}
	
	public void addItem(final HistoryItem historyItem) {
        /**
         * XXX In case such stockItem already exists increase the quantity of the
         * existing stock.
         */
        
        rows.add((HistoryItem) historyItem);
        //log.debug("Added " + item.getName() + " quantity of " + item.getQuantity());
        fireTableDataChanged();
    }
	

}
