package ee.ut.math.tvt.salessystem.ui.model;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
 
import ee.ut.math.tvt.salessystem.domain.controller.SalesDomainController;
 
/**
 * Main model. Holds all the other models.
 */
public class SalesSystemModel {
    
    private static final Logger log = LogManager.getLogger(SalesSystemModel.class);

    // Warehouse model
    private StockTableModel warehouseTableModel;
    
    // Current shopping cart model
    private PurchaseInfoTableModel currentPurchaseTableModel;
    
    private HistoryTableModel historyTableModel;
    private HistoryInfoTableModel itemsInfoHistoryTableModel;

    private final SalesDomainController domainController;
 
    /**
     * Construct application model.
     * @param domainController Sales domain controller.
     */
    public SalesSystemModel(SalesDomainController domainController) {
        this.domainController = domainController;
        
        warehouseTableModel = new StockTableModel();
        currentPurchaseTableModel = new PurchaseInfoTableModel();
        
        historyTableModel = new HistoryTableModel(); 
        itemsInfoHistoryTableModel = new HistoryInfoTableModel();

        // populate stock model with data from the warehouse
        warehouseTableModel.populateWithData(domainController.loadWarehouseState());

    }

    public StockTableModel getWarehouseTableModel() {
        return warehouseTableModel;
    }

    public PurchaseInfoTableModel getCurrentPurchaseTableModel() {
        return currentPurchaseTableModel;
    }
    
    public HistoryTableModel getHistoryTableModel() {
        return historyTableModel;
    }
    
    public HistoryInfoTableModel getHistoryInfoTableModel() {
        return itemsInfoHistoryTableModel;
    }
    
}
