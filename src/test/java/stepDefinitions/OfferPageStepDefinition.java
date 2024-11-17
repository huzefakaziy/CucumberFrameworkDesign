package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import utils.TestContextSetup;

public class OfferPageStepDefinition {
	
	//Single Responsibility Principle
	public TestContextSetup testContextSetup; 
	private String offerPageProductname;
	
	
	public OfferPageStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup = testContextSetup;
	}
	
	

	@Then("^User searched for (.+) shortname in offers page$")
	public void user_searched_for_same_shortname_in_offers_page(String shortName) throws InterruptedException {
				
		switchToOffersPage();		
		OffersPage offersPage = testContextSetup.pageObjectManager.getOffersPage();
		offersPage.searchItem(shortName);		
		Thread.sleep(1000);
		offerPageProductname = offersPage.getProductName();
	   
	}
	
	public void switchToOffersPage()
	{			
		if(!testContextSetup.pageObjectManager.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers"))
		{
			LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
			landingPage.selectTopDealsPage();		
			testContextSetup.genericUtils.switchWindowToChild();
		}
	}
	
	@Then("Validate product name in offers page matches with landing page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() {	   
		System.out.println("*********************************************************************************************************************************");
		System.out.println("testContextSetup.landingPageproductName: " + testContextSetup.landingPageproductName);
		System.out.println("offerPageProductname: " + offerPageProductname);
		System.out.println("*********************************************************************************************************************************");
		Assert.assertEquals(offerPageProductname, testContextSetup.landingPageproductName);		
	}

}
