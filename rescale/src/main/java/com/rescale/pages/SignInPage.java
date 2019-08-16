/* SignInPage - List all the SignInPage,
* - Functions, navigate to pages, log in action and excecutable btn actions
*/

package com.rescale.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SignInPage {
	
	
private WebDriver driver;	
private static final String EMAIL_TXT_BOX="//*[@class='active-input']";
private static final String PASSWORD_TXT_BOX="//input[@name='password']";
private static final String NEXT_BTN ="//*[@class='next-step ready']";
private static final String LOGIN_BTN="//*[@class='input-link']";
private static final String GREETING_TXT_SIGNIN_PAGE ="//*[@class='greeting']";
private static final String INVALID_LOGIN_ERROR_MSG="//*[@class='login-error alert alert-danger tc rs-alert']";


//Values
private static final String EMAIL_ID_VALUE ="pranavj.08@gmail.com";
private static final String PASSWORD_VALUE ="rescale@123";



public SignInPage(WebDriver driver) {
	this.driver=driver;
	
}

public String getSignInPageTitle() {
	String pageTitle = driver.getTitle();
	System.out.println("Sign in Page Title: "+pageTitle);
	return pageTitle;
}

public boolean verifySignInPageTitle() {
	String expectedTitle = "Sign in to Rescale"; 
	return getSignInPageTitle().contains(expectedTitle);
}

public boolean verifySignInPageText() {
	WebElement element = driver.findElement(By.xpath(GREETING_TXT_SIGNIN_PAGE));
	String pageText = element.getText();
	String expectedPageText ="Sign in to Rescale";
	return pageText.contains(expectedPageText);
}

public void enterEmailId() {
	WebElement emailTxtBox = driver.findElement(By.xpath(EMAIL_TXT_BOX));
	if(emailTxtBox.isDisplayed())
		emailTxtBox.sendKeys(EMAIL_ID_VALUE);
}

public void enterPassword() {
	WebElement passwordTxtBox = driver.findElement(By.xpath(PASSWORD_TXT_BOX));
	if(passwordTxtBox.isDisplayed())
		passwordTxtBox.sendKeys(PASSWORD_VALUE);
}

public void clickLogIn() {
	WebElement logIn_btn = driver.findElement(By.xpath(LOGIN_BTN));
	if(logIn_btn.isDisplayed())
		logIn_btn.submit();
	
}

public String getErrorMsg() {
	String str_errormsg = null;
	WebElement errormsg = driver.findElement(By.xpath(INVALID_LOGIN_ERROR_MSG));
	if(errormsg.isDisplayed()&&errormsg.isEnabled())
		str_errormsg = errormsg.getText();
	return str_errormsg;	
}

public boolean verifyLogOutPageText() {
	WebElement logoutmessage = driver.findElement(By.xpath("//*[@class='alert-info info']"));
	String txtmessage_logoutpage = logoutmessage.getText();
	System.out.println("Logout page text message: "+txtmessage_logoutpage);
	String logoutpagetext = "You have successfully logged out";
	return txtmessage_logoutpage.contains(logoutpagetext);
}
	
}
