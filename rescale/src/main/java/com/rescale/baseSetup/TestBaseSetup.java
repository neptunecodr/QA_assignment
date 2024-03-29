/*
* TestBaseSetup - List all the reuseable paramters, Before class used for setup for browser selection and URL setup 
*prior to start of test cases
*
*/

package com.rescale.baseSetup;

import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestBaseSetup {
	

protected WebDriver driver;
protected static final String driverPath = System.getProperty("user.dir");

public WebDriver getDriver() {
	  return driver;
}

private void setDriver(String browserType, String appURL) {
	switch (browserType) {
	case "chrome":
		driver = initChromeDriver(appURL);
		break;
	case "firefox":
		driver = initFirefoxDriver(appURL);
		break;
	default:
		System.out.print("Browser :" + browserType + " is invalid, Launching Firefox as browser of choice.");
		driver = initFirefoxDriver(appURL);
	}
}


private static  WebDriver initChromeDriver(String appURL) {
	System.out.println("Launching the Chrome Browser: ");
	System.setProperty("webdriver.chrome.drive", driverPath + "drivers/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.navigate().to(appURL);
	return driver;
}

private static WebDriver initFirefoxDriver(String appURL) {
	System.out.println("Launching Firefox browser: ");
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.navigate().to(appURL);
	return driver;
}

@Parameters({"browserType","appURL"})
@BeforeClass
public void initialzeTestBaseSetup(String browserType, String appURL){
	try{
		setDriver(browserType, appURL);
	}catch(Exception e) {
	System.out.println("Error......."+ e.getStackTrace());
	
	}
}	

@AfterMethod
@AfterClass
public void tearDown() {
	driver.quit();
}

}
