package utilities;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReder {

	public Properties loadPropertiesFile() throws IOException {
	FileReader fileReader = new FileReader("C:\\Users\\PANKAJ\\git\\Selenium-Java-Framework1\\OrangeHRM\\src\\test\\resources\\configFiles\\config.properties");
	
	Properties properties = new Properties();
	properties.load(fileReader);
	return properties;
	
	}
	//System.out.println(properties.get("browser"));
	
	
}
