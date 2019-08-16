package com.rescale.testcases.LoginPage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.rescale.baseSetup.TestBaseSetup;
import com.rescale.pages.BasePage;



public class tc_001_BasePageTest extends TestBaseSetup {
	
	private WebDriver driver;
	//private SignInPage signInPage;
	private BasePage basePage;
	
	@Parameters({"browserType"})
	@BeforeClass
	public void setUp(String browserType){
		driver = getDriver();	
	}
	
	@Test
	public void verifyBasePage(){
		System.out.println("BasePage Test starting ....");
		basePage = new BasePage(driver);
		Assert.assertTrue(basePage.verifyBasePageTitle(),"Sign in to Rescale");
		
	}
	
	@AfterClass
	public void endVerifybasePage(){
		driver.close();
		System.out.println("BasePage Test completed ....");	
	}
	
	

}
