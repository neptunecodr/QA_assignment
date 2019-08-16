package com.rescale.testcases.LoginPage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.rescale.baseSetup.TestBaseSetup;
import com.rescale.pages.BasePage;
import com.rescale.pages.HomePage;
import com.rescale.pages.SignInPage;


public class TC_002_SignInAction extends TestBaseSetup {
private WebDriver driver;
private SignInPage signInPage;
private BasePage basePage;
private HomePage homePage;

	public TC_002_SignInAction(SignInPage signInPage) {
		this.signInPage = signInPage;
	}

@BeforeMethod
@BeforeClass
public void setUp(){
	driver=getDriver();
}

@Test
public  void verifySignInAction(){
	System.out.println("SignIn function details ....");
	basePage = new BasePage(driver);
	Assert.assertTrue(basePage.verifyBasePageTitle(),"Sign in to Rescale");
  	signInPage.enterEmailId();
  	signInPage.enterPassword();
  	signInPage.clickLogIn();
  	System.out.println("Waiting for SignIn ....");
  	System.out.println("SignIn completed ....");
  	Assert.assertEquals(homePage.getHomePageTitle(),"Welcome to the ScaleX Platform");
  	System.out.println("User is on Rescale home page ....");
}
@AfterClass
public void closesetup(){
	System.out.println("SignIn Test completed ....");
	System.out.println("Browser is closing ....");
	driver.close();
}

}
