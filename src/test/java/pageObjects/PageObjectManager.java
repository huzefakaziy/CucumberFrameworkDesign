package pageObjects;

import org.openqa.selenium.WebDriver;

//Factory Design Pattern Class to create objects for all the page object files
public class PageObjectManager {
	
	public WebDriver driver;
		
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public LandingPage getLandingPage()
	{ 
		return new LandingPage(driver);		
	}
	
	public OffersPage getOffersPage()
	{		
		return new OffersPage(driver);
	}
	
	public CheckoutPage getCheckoutPage()
	{
		return new CheckoutPage(driver);
	}

}
