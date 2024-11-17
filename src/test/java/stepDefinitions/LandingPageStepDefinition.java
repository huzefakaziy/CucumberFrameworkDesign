 package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinition {
	//Single Responsibility Principle Class
	
	public TestContextSetup testContextSetup; //Dependency Injection
	private LandingPage landingPage;
	
	//Passing data from one class to another: using Spring Framework, EJB, DI(PicoContainer)
	public LandingPageStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup = testContextSetup;
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
	}
	
	@Given("User is on GreenCart landing page")
	public void user_is_on_green_cart_landing_page() {
		Assert.assertTrue(landingPage.getLandingPageTitle().contains("GreenKart"));
		
	}

	@When("^User search with shortname (.+) and extract actual name of the product$")
	public void user_search_with_shortname_and_extract_actual_name_of_the_product(String shortName) throws InterruptedException 
	{		
		landingPage.searchItem(shortName);		
	    Thread.sleep(1000);
	    testContextSetup.landingPageproductName = landingPage.getProductName();
	    System.out.println(testContextSetup.landingPageproductName + " is extracted from the Home page");
	    
	}
	
	@And("Added {string} items of the selected product to Cart")
	public void Added_items_of_the_selected_product_to_Cart(String quantity)
	{		
		landingPage.increamentQuantityAndAddToCart(Integer.parseInt(quantity));		
	}

}
