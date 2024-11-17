package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils {
	
	private WebDriver driver;
	
	public GenericUtils(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void switchWindowToChild()
	{	
		Set<String> WindowIDs = driver.getWindowHandles();
		Iterator<String> iterator = WindowIDs.iterator();
		iterator.next();		
		driver.switchTo().window(iterator.next());
	}

}
