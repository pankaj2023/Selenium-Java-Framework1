package base;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import utilities.PropertiesFileReder;

public class TestBase {
	

	public static Properties properties;
	public static WebDriver driver;
	
	PropertiesFileReder propertiesFileReder = new PropertiesFileReder();
	
	@BeforeTest
	public void setUp() throws IOException {
		if(driver == null )
		{
			properties = propertiesFileReder.loadPropertiesFile();
			if(properties.getProperty("browser").equalsIgnoreCase("chrome")) {
				 

				System.setProperty("webdriver.chrome.driver", "E:\\chrome\\chromedriver-win64\\chromedriver.exe");
				ChromeOptions co = new ChromeOptions();
				co.setBinary("E:\\chrome\\chrome-win64\\chrome.exe");
				driver = new ChromeDriver(co);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.manage().window().maximize();
				driver.get(properties.getProperty("testUrl"));
				
			}
		}
		
	}
	
	@AfterTest
	public void tearDown() {
		
		driver.quit();
	}
}
