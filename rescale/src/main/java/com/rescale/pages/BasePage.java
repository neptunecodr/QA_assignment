/*
* Base Page - contains all the base URL page function / action functions
*/

package com.rescale.pages;

import org.openqa.selenium.WebDriver;

public class BasePage {

	
	protected WebDriver driver;
	
	
	public BasePage(WebDriver driver) {
		this.driver = driver;	
	}
	
	
	public String clickBasePageTitle() {
		String title = driver.getTitle();
		return title;	
	}
	
	public boolean verifyBasePageTitle() {
		String expectedPageTitle ="Sign in to Rescale";
		return clickBasePageTitle().contains(expectedPageTitle);
	}
	
	public void clickLoginBtn(){
		System.out.println("clicking on login button");
	}
}
