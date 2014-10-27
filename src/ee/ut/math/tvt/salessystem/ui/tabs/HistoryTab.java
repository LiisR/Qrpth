package ee.ut.math.tvt.salessystem.ui.tabs;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import ee.ut.math.tvt.salessystem.ui.model.SalesSystemModel;

/**
 * Encapsulates everything that has to do with the purchase tab (the tab
 * labelled "History" in the menu).
 */
public class HistoryTab {
	   private SalesSystemModel model;
	    JTable historyTable;
//konstruktor	   
	    public HistoryTab(SalesSystemModel model) {
	        this.model = model;
	    } 

   
    public Component draw() {
        JPanel panel = new JPanel();
        // TODO - Sales history tabel
        return panel;
    }
    
    JPanel mainPanel = new JPanel(new GridLayout(2,1));
  
   
  
   
    



   



}