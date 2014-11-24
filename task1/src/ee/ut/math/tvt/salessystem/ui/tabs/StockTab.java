package ee.ut.math.tvt.salessystem.ui.tabs;

import ee.ut.math.tvt.salessystem.ui.model.SalesSystemModel;
import ee.ut.math.tvt.salessystem.util.HibernateUtil;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;

import java.text.DecimalFormat;

import javax.swing.text.NumberFormatter;

import org.hibernate.Session;

public class StockTab {

  private JButton addItem;

  private SalesSystemModel model;

  public StockTab(SalesSystemModel model) {
    this.model = model;
  }

  // warehouse stock tab - consists of a menu and a table
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

    panel.add(drawStockMenuPane(), gc);

    gc.weighty = 1.0;
    gc.fill = GridBagConstraints.BOTH;
    panel.add(drawStockMainPane(), gc);
    return panel;
  }

  // warehouse menu
  private Component drawStockMenuPane() {
    final JPanel panel = new JPanel();

    GridBagConstraints gc = new GridBagConstraints();
    GridBagLayout gb = new GridBagLayout();

    panel.setLayout(gb);

    gc.anchor = GridBagConstraints.NORTHWEST;
    gc.weightx = 0;

    addItem = new JButton("Add");
    addItem.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            JDialog dialog = new JDialog((Dialog)null, "Add product", true);
            dialog.add(drawAddPopup());
            dialog.setSize(360, 240);
            Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
            dialog.setLocation((screen.width - 360) / 2, (screen.height - 240) / 2);
            dialog.setVisible(true);
        }
    });
    gc.gridwidth = GridBagConstraints.RELATIVE;
    gc.weightx = 1.0;
    panel.add(addItem, gc);

    panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    return panel;
  }


  // table of the wareshouse stock
  private Component drawStockMainPane() {
    JPanel panel = new JPanel();

    JTable table = new JTable(model.getWarehouseTableModel());

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

    panel.setBorder(BorderFactory.createTitledBorder("Warehouse status"));
    return panel;
  }

  private Component drawAddPopup() {
      JPanel panel = new JPanel();

      GridBagConstraints gc = new GridBagConstraints();
      GridBagLayout gb = new GridBagLayout();

      panel.setLayout(gb);

      final JLabel[] labels = {
          new JLabel("Barcode: "),
          new JLabel("Name: "),
          new JLabel("Price: "),
          new JLabel("Quantity: "),
      };

      final JTextField[] textFields = {
          new JFormattedTextField(),
          new JTextField(10),
          new JFormattedTextField(),
          new JFormattedTextField(),
      };
// Te ei maksa mulle piisavalt.
//      ((JFormattedTextField) textFields[0]).setValue(new Long(0));
//      ((JFormattedTextField) textFields[2]).setValue(new Double(0.0));
//      ((JFormattedTextField) textFields[3]).setValue(new Integer(0));

      int numLabels = labels.length;
      
      for (int i = 0; i < numLabels; i++) {
          labels[i].setLabelFor(textFields[i]);

          gc.gridwidth = GridBagConstraints.RELATIVE; //next-to-last
          gc.fill = GridBagConstraints.NONE;      //reset to default
          gc.weightx = 0.0;                       //reset to default
          panel.add(labels[i], gc);
          
          gc.gridwidth = GridBagConstraints.REMAINDER;     //end row
          gc.fill = GridBagConstraints.HORIZONTAL;
          gc.weightx = 1.0;
          panel.add(textFields[i], gc);
      }

      JButton smurfAbstractSmurfAddSmurfSmurfFactoryAbstractFactory = new JButton("Add");
      smurfAbstractSmurfAddSmurfSmurfFactoryAbstractFactory.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
        	  Session stockSession = HibernateUtil.currentSession(); //
        	  stockSession.beginTransaction();
      		  
        	  StockItem newItem = new StockItem(
                      Long.parseLong(textFields[0].getText()),
                      textFields[1].getText(),
                      "",
                      Double.parseDouble(textFields[2].getText()),
                      Integer.parseInt(textFields[3].getText())
                  );
              model.getWarehouseTableModel().addItem(newItem);
              
              //add stockItem/newItem to database
              stockSession.persist(newItem);
      		
      		//end session
              stockSession.getTransaction().commit();
              
          }
      });
      panel.add(smurfAbstractSmurfAddSmurfSmurfFactoryAbstractFactory);

      return panel;
  }
}
