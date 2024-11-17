package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
	
	private WebDriver driver;

	public OffersPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	private By search = By.xpath("//input[@type='search']");
	private By productname = By.cssSelector("tbody tr td:nth-child(1)");
	
	public void searchItem(String shortName)
	{
		driver.findElement(search).sendKeys(shortName);
	}
	
	public String getProductName()
	{
		return driver.findElement(productname).getText().trim();
	}
}
