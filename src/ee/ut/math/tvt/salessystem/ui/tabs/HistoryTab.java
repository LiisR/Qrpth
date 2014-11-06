package ee.ut.math.tvt.salessystem.ui.tabs;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;

import ee.ut.math.tvt.salessystem.domain.data.HistoryItem;
import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.ui.model.SalesSystemModel;

/**
 * Encapsulates everything that has to do with the purchase tab (the tab
 * labelled "History" in the menu).
 */
public class HistoryTab {
	
	   private SalesSystemModel model;
	   private Long id;
	    
//konstruktor	   
	    public HistoryTab(SalesSystemModel model) {
	        this.model = model;
	    } 

	 // TODO - Sales history tabel
    public Component draw() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        GridBagLayout gb = new GridBagLayout();
        GridBagConstraints gc = new GridBagConstraints();
        panel.setLayout(gb);

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.NORTH;
        gc.gridwidth = GridBagConstraints.REMAINDER;
        gc.weightx = 1.0d;
        gc.weighty = 0d;

        panel.add(drawHistoryMenuPane(), gc);

        gc.weighty = 1.0;
        gc.fill = GridBagConstraints.BOTH;
        panel.add(drawHistoryMainPane(), gc);
        
        return panel;
    }
    
    private Component drawHistoryMenuPane() {
        final JPanel panel = new JPanel();

        GridBagConstraints gc = new GridBagConstraints();
        GridBagLayout gb = new GridBagLayout();

        panel.setLayout(gb);

        gc.anchor = GridBagConstraints.NORTHWEST;
        gc.weightx = 0;
        
        gc.gridwidth = GridBagConstraints.RELATIVE;
        gc.weightx = 1.0;

        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        return panel;
        
    }
    
    private Component drawHistoryMainPane() {
        JPanel panel = new JPanel();

        JTable table = new JTable(model.getHistoryTableModel()); 

        JTableHeader header = table.getTableHeader();
        header.setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(table);

        GridBagConstraints gc = new GridBagConstraints();
        GridBagLayout gb = new GridBagLayout();
        gc.fill = GridBagConstraints.BOTH;
        gc.weightx = 1.0;
        gc.weighty = 1.0;

        panel.setLayout(gb);
        panel.add(scrollPane, gc);

        panel.setBorder(BorderFactory.createTitledBorder("History status"));
        
        //clicks detection on the HistoryMainPane
        table.addMouseListener(new MouseAdapter(){
	    	  public void mouseClicked(MouseEvent e){
	    		  if(e.getClickCount() > 0){ 
	    			  
	    			  //HistoryItem historyItem = model.getHistoryTableModel().getItemById((long)table.getValueAt(table.getSelectedRow(), 0));
	    			  
	    			  
	    			  JDialog dialog = new JDialog((Dialog)null, "Product information", true);
	    			  
	    	          dialog.add(drawProductInfoPopup());
	    	          dialog.setSize(600, 400);
	    	          Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	    	          dialog.setLocation((screen.width - 360) / 2, (screen.height - 240) / 2);
	    	          dialog.setVisible(true);
	    			  
	    			  
	    		  }
	    	  }
	      });
        
        return panel;
      }
    
    
    private Component drawProductInfoPopup() {
        JPanel panel = new JPanel();
        
        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Shopping cart"));
        
        
        //JTable table = new JTable(model.getCurrentPurchaseTableModel());
        
        JTable table = new JTable(model.getCurrentPurchaseTableModel());
        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(scrollPane, getProductInfoPopupConstraints());

        return panel;
    }
    
    
    
    
    private GridBagConstraints getProductInfoPopupConstraints() {
        GridBagConstraints gc = new GridBagConstraints();

        gc.fill = GridBagConstraints.BOTH;
        gc.weightx = 1.0;
        gc.weighty = 1.0;

        return gc;
    }

}