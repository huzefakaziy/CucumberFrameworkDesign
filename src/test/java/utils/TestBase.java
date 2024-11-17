package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	private WebDriver driver;
	
	public WebDriver WebDiverManager() throws IOException
	{		
		FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\global.properties");
		Properties properties = new Properties();		
		properties.load(fileInputStream);
		//Java Ternary operator: variable = testCondition ? Value1 : Value2
		String browser = System.getProperty("browser")==null ? properties.getProperty("browser") : System.getProperty("browser");
		String Url = properties.getProperty("QAUrl");
				
		if(driver==null)
		{
			if(browser.equalsIgnoreCase("chrome"))
				driver = new ChromeDriver();
			else if(browser.equalsIgnoreCase("edge"))
				driver = new EdgeDriver();
			else 
				driver = new FirefoxDriver();
			System.out.println("-------------------------------------------------------Browser Launched Successfully-------------------------------------------------------");
			driver.manage().window().maximize();			
			driver.get(Url);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		return driver;
	}
	

}
