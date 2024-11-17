package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	
	private WebDriver driver;
	
	public CheckoutPage(WebDriver driver)
	{
		this.driver = driver;
	}

	private By cartBag = By.cssSelector("img[alt='Cart']");
	private By checkOutButton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	private By promoBtn = By.cssSelector(".promoBtn");
	private By placeOrderBtn = By.xpath("//button[contains(text(),'Place Order')]");
	private By productName = By.cssSelector(".product-name");
	
	
	public void checkoutItems()
	{
		driver.findElement(cartBag).click();
		driver.findElement(checkOutButton).click();
	}
	
	public boolean verifyPromoBtn()
	{
		return driver.findElement(promoBtn).isDisplayed();
	}
	
	public boolean verifyPageOrderBtn()
	{
		return driver.findElement(placeOrderBtn).isDisplayed();
	}
	
	public String getProductName()
	{
		return driver.findElement(productName).getText().trim().split(" ")[0];
	}
	
	

}
