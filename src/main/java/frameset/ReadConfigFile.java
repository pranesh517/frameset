package frameset;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigFile {
	
	public static Properties readConfigurationFile() throws IOException{
		String classPth = System.getProperty("user.dir");
		File file = new File(classPth+"/src/test/resources/config.properties");
		FileInputStream fileInputStream = new FileInputStream(file);
		Properties properties = new Properties();
		properties.load(fileInputStream);
		return properties;
	}

}
