package ee.ut.math.tvt.salessystem.ui.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ee.ut.math.tvt.salessystem.domain.data.SoldItem;

public class HistoryInfoTableModel extends SalesSystemTableModel<SoldItem> {
	private static final long serialVersionUID = 1L;

	private static final Logger log = LogManager.getLogger(PurchaseInfoTableModel.class);
	
	public HistoryInfoTableModel() {
		super(new String[] { "Id", "Name", "Price", "Quantity", "Sum"});
	}

	@Override
	protected Object getColumnValue(SoldItem item, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return item.getId();
		case 1:
			return item.getName();
		case 2:
			return item.getPrice();
		case 3:
			return item.getQuantity();
		case 4:
			return item.getSum();
		}
		throw new IllegalArgumentException("Column index out of range");
	}

}
