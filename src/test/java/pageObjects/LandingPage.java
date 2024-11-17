package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	
	private WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
	}

	private By search = By.xpath("//input[@type='search']");
	private By productName = By.cssSelector(".product-name");
	private By topDeals = By.cssSelector("a[href='#/offers']");
	private By increment = By.cssSelector(".increment");
	private By addToCartBtn = By.cssSelector(".product-action button"); 
	
	public void searchItem(String shortName)
	{
		driver.findElement(search).sendKeys(shortName);
	}
	
	public String getProductName()
	{
		return driver.findElement(productName).getText().trim().split(" ")[0];		
	}
	
	public void selectTopDealsPage()
	{
		driver.findElement(topDeals).click();
	}
	
	public String getLandingPageTitle()
	{
		return driver.getTitle();
	}
	
	public void increamentQuantityAndAddToCart(int quantity)
	{
		for(int i=1; i<quantity; i++)
		{
			driver.findElement(increment).click();
		}
		driver.findElement(addToCartBtn).click();
	}
	

}
