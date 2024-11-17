package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.CheckoutPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefinition {
	//Single Responsibility Principle Class
	
	public TestContextSetup testContextSetup; //Dependency Injection
	private CheckoutPage checkoutPage;
	
	//Passing data from one class to another: using Spring Framework, EJB, DI(PicoContainer)
	public CheckoutPageStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup = testContextSetup;
		this.checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
	}
	
	@Then("^User proceeds to Checkout and validate the (.+) items in Checkout page$")
	public void User_proceeds_to_Checkout_and_validate_the_items_in_Checkout_page(String productName)
	{
		checkoutPage.checkoutItems();		
		//Assertion to extract name from screen and compare with name		
		Assert.assertTrue(checkoutPage.getProductName().contains(productName));		
	}
	
	@And("Verify user has ability to enter promocode and place the order")
	public void Verify_user_has_ability_to_enter_promocode_and_place_the_order()
	{		
		Assert.assertTrue(checkoutPage.verifyPromoBtn());
		Assert.assertTrue(checkoutPage.verifyPageOrderBtn());
		
		
	}

}
