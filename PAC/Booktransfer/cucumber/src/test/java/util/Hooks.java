package util;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import helpers.SharedDriver;

public class Hooks{
    
	private WebDriver driver;
	

	public Hooks(SharedDriver sharedDriver){
		this.driver = sharedDriver.getDriver();
	}
    
    @Before
    public void openBrowser() throws Exception {
    	System.out.println("Before Called in Hooks....");
    }

     
    @After
    public void embedScreenshot(Scenario scenario) {
		System.out.println("After Called in Hooks");
		if (scenario.isFailed()) {
			try {
				scenario.write("Current Page URL is " + driver.getCurrentUrl());
				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			} catch (WebDriverException somePlatformsDontSupportScreenshots) {
				System.err.println(somePlatformsDontSupportScreenshots.getMessage());
			}

		}
		driver.quit();
    }
    
}