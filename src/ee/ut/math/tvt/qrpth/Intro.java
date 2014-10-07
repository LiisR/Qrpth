package ee.ut.math.tvt.qrpth;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import java.net.URL;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import ee.ut.math.tvt.qrpth.IntroUI;

public class Intro {
	private static final Logger log = LogManager.getLogger(Intro.class);
	
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
		final IntroUI ui = new IntroUI();
		ui.setVisible(true);
		
		log.info("Team intro started");
	}
	
}
