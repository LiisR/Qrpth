package ee.ut.math.tvt.qrpth;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Intro {
	@SuppressWarnings("resource")
	static InputStream getResource(String name) throws FileNotFoundException {
		InputStream stream = Intro.class.getResourceAsStream("/" + name);
		return stream == null ? new FileInputStream(name): stream;
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		
		InputStream propfile = getResource("version.properties");
		prop.load(propfile);
		propfile.close();
		
		System.out.println(prop.getProperty("build.major.number") + "." + 
				prop.getProperty("build.minor.number") + "." + prop.getProperty("build.revision.number"));
		
		System.out.println(prop.getProperty("build.number"));
	}
}
