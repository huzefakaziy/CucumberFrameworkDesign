package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class Hooks {

	TestContextSetup testContextSetup;
	WebDriver driver;
	public Hooks(TestContextSetup testContextSetup) throws IOException
	{
		this.testContextSetup = testContextSetup;
		this.driver = testContextSetup.testBase.WebDiverManager();
	}

		
	@AfterStep()
	public void AddScreenshot(Scenario scenario) throws IOException
	{
		if(scenario.isFailed())
		{
			File Screenshotfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			byte[] fileByte = FileUtils.readFileToByteArray(Screenshotfile);
			scenario.attach(fileByte, "image/png", "Screenshot");
		}
	}
	
	@Before(order=1)
	public void initializeTest()
	{
		
	}
	
	@Before(order=2)
	public void initializeTest2()
	{
		
	}
	
	@Before("@submitOrderTest")
	public void preRequisiteTest()
	{
		
	}
	
	@After
	public void tearDown() throws IOException
	{		
		//TestBase.driver.quit();
		//TestBase.WebDiverManager().quit();
		//testContextSetup.testBase.WebDiverManager().quit();
		driver.quit();

		System.out.println("-------------------------------------------------------Browser Closed Successfully-------------------------------------------------------");
	}
}
