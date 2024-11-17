package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

public class TestContextSetup {
	
	public WebDriver driver;
	public String landingPageproductName;
	public TestBase testBase;
	public PageObjectManager pageObjectManager; 
	public GenericUtils genericUtils;	
	
	public TestContextSetup() throws IOException
	{
		testBase = new TestBase();
		pageObjectManager = new PageObjectManager(testBase.WebDiverManager());
		genericUtils = new GenericUtils(testBase.WebDiverManager());
	}
}
