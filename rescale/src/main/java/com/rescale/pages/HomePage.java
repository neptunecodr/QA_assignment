/* HomePage - List all the FilesPage,
* - Function, navigate to pages, log out action and excecutable btn actions
*/
package com.rescale.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class HomePage {

protected WebDriver driver;
	
public HomePage(WebDriver driver) {
	   this.driver = driver;
}


public String getHomePageTitle() {
	String title_homepage = driver.getTitle();
	return title_homepage;
	
}

public boolean verifyHomePageTitle() {
	String expected_title_homepage="Welcome to the ScaleX Platform";
	return getHomePageTitle().contains(expected_title_homepage);	
}

public void getListOfNavigationPages() {
	
}

public void verifyNavigationPages_Titles() {
	
}

public void goToFilesPage() {
	driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
	WebElement filespage = driver.findElement(By.xpath("//a[@href='/files/']"));
	filespage.click();	
}

public void goToAccountSettings() {
	Actions action = new Actions(driver);
	WebElement selectFromDropdown = driver.findElement(By.xpath("//*[@class='dropdown-toggle']"));
	action.moveToElement(selectFromDropdown).moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Account Settings')]"))).click().build().perform();
	driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
}


public void logOut() {
	Actions action = new Actions(driver);
	WebElement selectFromDropdown = driver.findElement(By.xpath("//*[@class='dropdown-toggle']"));
	action.moveToElement(selectFromDropdown).moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Log out')]"))).click().build().perform();
	driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);	
}

}
