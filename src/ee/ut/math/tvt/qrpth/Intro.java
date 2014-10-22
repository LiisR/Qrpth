package ee.ut.math.tvt.qrpth;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import ee.ut.math.tvt.qrpth.IntroUI;
import ee.ut.math.tvt.salessystem.domain.controller.SalesDomainController;
import ee.ut.math.tvt.salessystem.domain.controller.impl.SalesDomainControllerImpl;
import ee.ut.math.tvt.salessystem.ui.ConsoleUI;
import ee.ut.math.tvt.salessystem.ui.SalesSystemUI;

public class Intro {
	private static final Logger log = LogManager.getLogger(Intro.class);
	private static final String MODE = "console";


	
	@SuppressWarnings("resource")
	static InputStream getResource(String name) throws FileNotFoundException {
		return Intro.class.getResourceAsStream("/" + name);
	}
	
	public static Properties getProperties(String name) throws FileNotFoundException, IOException {
            Properties ret = new Properties();
            InputStream propfile = getResource(name + ".properties");
            ret.load(propfile);
            propfile.close();
            return ret;
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		final SalesDomainController domainController = new SalesDomainControllerImpl();
		
		
		if (args.length == 1 && args[0].equals(MODE)) {
			log.debug("Mode: " + MODE);

			ConsoleUI cui = new ConsoleUI(domainController);
			cui.run();
		} else {

			//final IntroUI ui = new IntroUI();
			//ui.setVisible(true);
			
			
			IntroUI introUI = new IntroUI();
			introUI.setVisible(true);
			introUI.setAlwaysOnTop(true);

			final SalesSystemUI ui = new SalesSystemUI(domainController);
			ui.setVisible(true);

			introUI.setAlwaysOnTop(false);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			introUI.setVisible(false);
			
		}
		
		
	}
	
}
