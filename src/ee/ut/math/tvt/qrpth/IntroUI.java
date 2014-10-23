package ee.ut.math.tvt.qrpth;

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

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
* Graphical user interface of the sales system.
*/

public class IntroUI extends JFrame {
	 
	  private static final long serialVersionUID = 1L;

	  private Logger log = LogManager.getLogger(IntroUI.class);
 
	  /**
	   * Constructs sales system GUI.
	   * @param domainController Sales domain controller.
	   */
	  public IntroUI() {
	    
	    setTitle("Intro of Qrpth");

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
                  Properties verinfo = null;
                try {
                    verinfo = Intro.getProperties("version");
                } catch (Exception e) {
                    this.log.fatal("Failed to read `version.properties`", e);
                    System.exit(1);
                }
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                try {
                    InputStream res = Intro.getResource("image/pilt.png");
                    byte[] buffer = new byte[1024];
                    int length = 0;
                    while ((length = res.read(buffer)) != -1) {
                        baos.write(buffer, 0, length);
                    }
                } catch (Exception e) {
                    this.log.fatal("Failed to read `image/pilt.png`", e);
                    System.exit(1);
                }
                
		  ImageIcon icon = new ImageIcon(baos.toByteArray());
		  JLabel text = new JLabel("<html><b>Team name:</b> Qrpth <br>"+
		  		  "<b>Team leader:</b> <br>"+ 
				  "<b>Team leader email:</b> <br>"+ 
				  "<b>Team members:</b> Liis Reisberg, Anne-Mai Ilumäe, Andreas Ots, Robert Laur <br>"+
				  "<b>Software version number: "+verinfo.getProperty("build.number") + "</b>"+ 
				  "</html>",icon,JLabel.LEFT);
		  
		  getContentPane().add(text);
		  }
	}




