package ee.ut.math.tvt.salessystem.ui.panels;

import ee.ut.math.tvt.salessystem.domain.data.HistoryItem;
import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.ui.model.SalesSystemModel;
import ee.ut.math.tvt.salessystem.ui.tabs.PurchaseTab;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.NoSuchElementException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Purchase pane + shopping cart tabel UI.
 */
public class PurchaseItemPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    
    private static final Logger log = LogManager.getLogger(PurchaseTab.class);

    // Text field on the dialogPane
    private JTextField barCodeField;
    //private JComboBox barCodeBox; yleliigne??
    private JTextField quantityField;
    //private JTextField nameField;
    private JTextField priceField;

    private JButton addItemButton;
    private JComboBox combobox;
    
    //Conformation panel textfields
    private JTextField orderSumField;
    private JTextField paymentField;
    private JTextField changeField;
    
  //Conformation panel buttons
    private JButton confirmButton;
    private JButton cancelButton;


    // Warehouse model
    private SalesSystemModel model;
   
    /**
     * Constructs new purchase item panel.
     * 
     * @param model
     *            composite model of the warehouse and the shopping cart.
     */
    public PurchaseItemPanel(SalesSystemModel model) {
        this.model = model;

        setLayout(new GridBagLayout());

        add(drawDialogPane(), getDialogPaneConstraints());
        add(drawConformationPane(), getConformationPaneConstraints());
        add(drawBasketPane(), getBasketPaneConstraints());
        
        getComponents()[1].setVisible(false);
        

        setEnabled(false);
    }

    // shopping cart pane
    private JComponent drawBasketPane() {

        // Create the basketPane
        JPanel basketPane = new JPanel();
        basketPane.setLayout(new GridBagLayout());
        basketPane.setBorder(BorderFactory.createTitledBorder("Shopping cart"));

        // Create the table, put it inside a scollPane,
        // and add the scrollPane to the basketPanel.
        JTable table = new JTable(model.getCurrentPurchaseTableModel());
        JScrollPane scrollPane = new JScrollPane(table);

        basketPane.add(scrollPane, getBacketScrollPaneConstraints());

        return basketPane;
    }
//jcombobox

   
    // purchase dialog
   
	private JComponent drawDialogPane() {

        // Create the panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));
        panel.setBorder(BorderFactory.createTitledBorder("Product"));
        
        combobox = new JComboBox(model.getWarehouseTableModel().inventoryList().toArray());
        combobox.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                        fillDialogFields();
                }
        });


        // Initialize the textfields
        barCodeField = new JTextField();
      // barCodeBox = new JComboBox(); - yleliigne?
        quantityField = new JTextField("1");
        //nameField = new JTextField();
        priceField = new JTextField();
/*
        // Fill the dialog fields if the bar code text field loses focus
        barCodeField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
            }

            public void focusLost(FocusEvent e) {
                fillDialogFields();
            }
        }); 
        */

        barCodeField.setEditable(false);
        priceField.setEditable(false);

        // == Add components to the panel

        //-Jcombobox
        panel.add(new JLabel("Drop-down menu:"));
        panel.add(combobox);

        // bar code box
        //panel.add(new JLabel("Product:"));
//???
//        panel.add(barCodeBox); 


        // - bar code
        panel.add(new JLabel("Bar code:"));
        panel.add(barCodeField);
     
        // - amount
        panel.add(new JLabel("Amount:"));
        panel.add(quantityField);
        
        //name'i v2lja pole tarvis, kuna drop-down menyyst nimed n2htaval
/*
        // - name
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
*/
        // - price
        panel.add(new JLabel("Price:"));
        panel.add(priceField);

        // Create and add the button
        addItemButton = new JButton("Add to cart");
        addItemButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addItemEventHandler();
            }
        });

        panel.add(addItemButton);

        return panel;
    }
	
	 // purchase conformation pane
	private JComponent drawConformationPane() {

        // Create the conformationPane
        JPanel confPanel = new JPanel();
        confPanel.setLayout(new GridLayout(4, 2));
        confPanel.setBorder(BorderFactory.createTitledBorder("Purchase conformation"));

     // Initialize the textfields
        orderSumField = new JTextField();
        paymentField = new JTextField();
        changeField = new JTextField();
        
        orderSumField.setEditable(false);
        changeField.setEditable(false);
        
        // == Add components to the panel
        // - total sum of the order
        confPanel.add(new JLabel("Sum of the order:"));
        confPanel.add(orderSumField);
        
        // - the payment amount
        confPanel.add(new JLabel("Payment amount:"));
        confPanel.add(paymentField);
        
        paymentField.getDocument().addDocumentListener(new DocumentListener() {
        	public void changedUpdate(DocumentEvent e) {
        		}
        	public void insertUpdate(DocumentEvent arg0) {
        		calcChange();
        		}
        	public void removeUpdate(DocumentEvent arg0) {
        		calcChange();
        		}
        	});
        
        // - the change amount
        confPanel.add(new JLabel("Change amount:"));
        confPanel.add(changeField);
        
        // Create and add the accept button
        confirmButton = new JButton("Accept");
        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               acceptPurchaseEventHandler();
            }
        });
        
     // Create and add the cancel the payment button
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               getComponents()[1].setVisible(false);
               paymentField.setText("");
            }
        });

        confPanel.add(confirmButton);
        confPanel.add(cancelButton);
        
        confirmButton.setEnabled(false);
        cancelButton.setEnabled(true);

        return confPanel;
    }
	
	
	public void calcChange(){
		try {
			double payment = Double.parseDouble(paymentField.getText());
			double orderSum = Double.parseDouble(orderSumField.getText());
			if (payment >= orderSum) {
				changeField.setText((new Double((double) Math.round((payment-orderSum) * 100) / 100)).toString());
				confirmButton.setEnabled(true);
				} 
			else {
				confirmButton.setEnabled(false);
				changeField.setText("");
				}
			} 
		catch (NumberFormatException ex) {
			confirmButton.setEnabled(false);
			changeField.setText("");
			}
		
	}
	
	public void setOrderSumField(double sum){
		orderSumField.setText(new Double(sum).toString());
	}
	
	
	
	
	public void acceptPurchaseEventHandler(){
		log.info("Payment started");
		
		// Save items as HistoryItem		
		List<SoldItem> purchaseItems = model.getCurrentPurchaseTableModel().getTableRows();
		
		int count = model.getHistoryTableModel().getRowCount();
		HistoryItem historyItem = new HistoryItem(purchaseItems,count); //if more than one purchase then we have to check the id
		historyItem.setTotalPrice(Double.parseDouble(orderSumField.getText()));
		model.getHistoryTableModel().addItem(historyItem);
		
		
														
		// End sale
		log.info("Sale completed");
		getComponents()[1].setVisible(false);
		paymentField.setText("");
	}
	
	public JButton getConfirmButton() {
		return confirmButton;
		}
 

    // Fill dialog with data from the "database".
    public void fillDialogFields() {
        StockItem myygiasi = getStockItemByName();

        if (myygiasi != null) {
        	//nimi tuleb Comboboxist
           // nameField.setText(stockItem.getName());
        		barCodeField.setText(Long.toString(myygiasi.getId()));
            String priceString = String.valueOf(myygiasi.getPrice());
            priceField.setText(priceString);
        } else {
            reset();
        }
    }

    // Search the warehouse for a StockItem with the bar code entered
    // to the barCode textfield.
    private StockItem getStockItemByBarcode() {
        try {
            int code = Integer.parseInt(barCodeField.getText());
            return model.getWarehouseTableModel().getItemById(code);
        } catch (NumberFormatException e) {
            return null;
        } catch (NoSuchElementException e) {
            return null;
        }
    }

   //comboboxi s6na v6rdlemine warehousemodelist getStockItemByName
    private StockItem getStockItemByName() {
        try {
        	String name = (String)combobox.getSelectedItem();
        	return model.getWarehouseTableModel().getItemByName(name);
        } 
       catch (NoSuchElementException e) {
            return null;
        }
    }

    /**
     * Add new item to the cart.
     */
    public void addItemEventHandler() {
        // add chosen item to the shopping cart.
        StockItem stockItem = getStockItemByName();
        if (stockItem != null) {
            int quantity;
            try {
                quantity = Integer.parseInt(quantityField.getText());
            } catch (NumberFormatException ex) {
                quantity = 1;
            }
            if(quantity <= stockItem.getQuantity()){
            	model.getCurrentPurchaseTableModel()
                	.addItem(new SoldItem(stockItem, quantity));
            }else{
            	JOptionPane.showMessageDialog(null, "Can not add item to cart. Warehouse has less items.","Error", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    /**
     * Sets whether or not this component is enabled.
     */
    @Override
    public void setEnabled(boolean enabled) {

    	this.combobox.setEnabled(enabled);

    	//this.barCodeBox.setEnabled(enabled);

        this.addItemButton.setEnabled(enabled);
        this.quantityField.setEnabled(enabled);
    }

    /**
     * Reset dialog fields.
     */
    public void reset() {
        barCodeField.setText("");
        quantityField.setText("1");
        //nameField.setText("");
        priceField.setText("");
    }
    
    private StockItem getItemByName() {
    	try {
    		String name = (String)combobox.getSelectedItem();
    		return model.getWarehouseTableModel().getItemByName(name);
    	}
    	catch (NoSuchElementException e) {
    		return null;
    	}
    	
    }

    /*
     * === Ideally, UI's layout and behavior should be kept as separated as
     * possible. If you work on the behavior of the application, you don't want
     * the layout details to get on your way all the time, and vice versa. This
     * separation leads to cleaner, more readable and better maintainable code.
     * 
     * In a Swing application, the layout is also defined as Java code and this
     * separation is more difficult to make. One thing that can still be done is
     * moving the layout-defining code out into separate methods, leaving the
     * more important methods unburdened of the messy layout code. This is done
     * in the following methods.
     */

    // Formatting constraints for the dialogPane
    private GridBagConstraints getDialogPaneConstraints() {
        GridBagConstraints gc = new GridBagConstraints();

        gc.anchor = GridBagConstraints.WEST;
        gc.weightx = 0.2;
        gc.weighty = 0d;
        gc.gridwidth = 1; 
        gc.fill = GridBagConstraints.NONE;

        return gc;
    }

    // Formatting constraints for the basketPane
    private GridBagConstraints getBasketPaneConstraints() {
        GridBagConstraints gc = new GridBagConstraints();

        gc.anchor = GridBagConstraints.WEST;
        gc.weightx = 0.2;
        gc.weighty = 1.0;
        gc.gridx = 0;	
        gc.gridy = 1;	
        gc.gridwidth = GridBagConstraints.REMAINDER;
        gc.fill = GridBagConstraints.BOTH;

        return gc;
    }

    private GridBagConstraints getBacketScrollPaneConstraints() {
        GridBagConstraints gc = new GridBagConstraints();

        gc.fill = GridBagConstraints.BOTH;
        gc.weightx = 1.0;
        gc.weighty = 1.0;

        return gc;
    }
    
 // Formatting constraints for the conformationPane
    private GridBagConstraints getConformationPaneConstraints() {
        GridBagConstraints gc = new GridBagConstraints();

        gc.anchor = GridBagConstraints.CENTER;
        gc.weightx = 0.2;
        gc.weighty = 0d;
        gc.gridwidth = GridBagConstraints.REMAINDER;
        gc.fill = GridBagConstraints.NONE;

        return gc;
    }

}
