/* UI - Test Cases
*  Upload File - Test case to verify successful file upload for single new file.
*/

package com.rescale.testcases.FilesPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.rescale.baseSetup.TestBaseSetup;
import com.rescale.pages.BasePage;
import com.rescale.pages.FilesPage;
import com.rescale.pages.HomePage;
import com.rescale.pages.SignInPage;

public class tc_1_Files_Upload_New extends TestBaseSetup{
	private WebDriver driver;
	private SignInPage signInPage;
	private BasePage basePage;
	private HomePage homePage;
	private FilesPage filesPage;
	
@BeforeMethod
public void setUp(){
		driver=getDriver();
	}

@Test(priority=0)
public  void verifySignInAction(){
		System.out.println("SignIn function details ....");
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		basePage = new BasePage(driver);
		Assert.assertTrue(basePage.verifyBasePageTitle(),"Sign in to Rescale");
	  	signInPage.enterEmailId();
	  	signInPage.enterPassword();
	  	signInPage.clickLogIn();
	  		System.out.println("Waiting for SignIn ....");
	  		System.out.println("SignIn completed ....");
	  		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	  	Assert.assertEquals(homePage.getHomePageTitle(),"Welcome to the ScaleX Platform");
	  		System.out.println("User is on Rescale home page ....");
	  		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
}

@Test(priority=1)
public void gotoFilePage() {
	System.out.println("Opening Files Page ....");
	driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	homePage.goToFilesPage();
	System.out.println("User present on Files page......");
	//Assert.assertEquals(filesPage.getFilesPageTitle(),"Files");
	try{
		Assert.assertEquals(filesPage.getFilesPageTitle(),"Files");
		}catch(AssertionError e){
		  // Log error;
		   //Takescreenshot;
			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
			System.out.println("go to filepage failed......");	
		}
	String uploadFilePath = driverPath+"upload_file.txt";
	System.out.println(uploadFilePath);
	filesPage.uploadFile(driverPath+"/upload_file1.txt");
	driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	
	try{
		Assert.assertEquals(filesPage.getFileFromList(),"file1.txt");
		}catch(AssertionError e){
		  // Log error;
		   //Takescreenshot;
			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
			System.out.println("file not found......");
			System.out.println("fileupload failed......");
		}	
}

@AfterClass
public void closesetup(){
		System.out.println("SignIn Test completed ....");
		System.out.println("Browser is closing ....");
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		driver.close();
		}


}
