package ee.ut.math.tvt.qrpth;

import com.jgoodies.looks.windows.WindowsLookAndFeel;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

//import org.apache.log4j.Logger;

/**
* Graphical user interface of the sales system.
*/

public class IntroUI extends JFrame {
	 
	  private static final long serialVersionUID = 1L;

	  //private static final Logger log = Logger.getLogger(IntroUI.class);

	  /**
	   * Constructs sales system GUI.
	   * @param domainController Sales domain controller.
	   */
	  public IntroUI() {
	    
	    setTitle("Intro of Qrpth");

	    // set L&F to the nice Windows style
	    try {
	      UIManager.setLookAndFeel(new WindowsLookAndFeel());

	    } catch (UnsupportedLookAndFeelException e1) {
	      //log.warn(e1.getMessage());
	    }

	    drawWidgets();
	    
	    // size & location
	    int width = 800;
	    int height = 400;
	    setSize(width, height);
	    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	    setLocation((screen.width - width) / 2, (screen.height - height) / 2);
	    
	    

	    addWindowListener(new WindowAdapter() {
	      @Override
	      public void windowClosing(WindowEvent e) {
	        System.exit(0);
	      }
	    });
	  }

	  private void drawWidgets() {
		  ImageIcon icon = new ImageIcon("image/pilt.png");
		  JLabel text = new JLabel("<html><b>Team name:</b> Qrpth <br>"+
		  		  "<b>Team leader:</b> <br>"+ 
				  "<b>Team leader email:</b> <br>"+ 
				  "<b>Team members:</b> Liis Reisberg, Anne-Mai Ilumäe, Andreas Ots, Robert Laur <br>"+
				  "<b>Software version number: Eclipse Kepler, jdk 1.7.0_51 </b>"+ 
				  "</html>",icon,JLabel.LEFT);
		  
		  getContentPane().add(text);
		  }
	}




