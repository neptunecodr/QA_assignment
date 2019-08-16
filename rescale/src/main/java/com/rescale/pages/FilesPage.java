/* Files Page - List all the FilesPage,
* - Function, file actions and excecutable btn actions
*/

package com.rescale.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FilesPage {
	
protected WebDriver driver;

	
public FilesPage(WebDriver driver) {
		   this.driver = driver;
}


public String getFilesPageTitle() {
	WebElement txt_filespage = driver.findElement(By.xpath("//*[@class='pull-left']"));
	String title_filespage = txt_filespage.getText();
	System.out.println("File Page Title: "+title_filespage);
	return title_filespage;
}

public boolean verifyFilesPageTitle() {
	String expected_title_filespage = "Files";
	return getFilesPageTitle().contains(expected_title_filespage);	
}

/*public String getUploadFilePath() {
	String workingDir_path2 = System.getProperty("user.dir");
	String path_uploadfile = driver.get(workingDir_path2 + "/upload_file1.txt");
	System.out.println("Relative upload file path: "+path_uploadfile);
	return path_uploadfile ;
}*/

public void uploadFile(String  path_uploadfile) {
	WebElement uploadFile_btn = driver.findElement(By.xpath("//*[@id=\"filesPageDropZone\"]"));
	WebDriverWait wait = new WebDriverWait(driver, 2000);
	uploadFile_btn.sendKeys(path_uploadfile);
	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
}

public String getFileFromList() {
	String filename_fileslist = null;
	return filename_fileslist;	
}

public boolean verifyFilePresent() {
	return false;
	
}


public void selectFile() {
	
}
public void selectMultipleFiles() {
	
}

public void editFileName() {
	
}

public void getFilesActions() {
	
}

public void deleteFile() {
	
}

public void deleteMultipleFiles() {
	
}

public void moveFile() {
	
}

public void moveMulitpleFiles() {
	
}

public void downloadSelectedFile() {
	
}

public void downloadSelectedMultipleFiles() {
	
}


public void selectInputFile() {
	
}

public void selectInputFilesMulitple() {
	
}

public void selectTags() {
	
}


public void selectFolder() {
	
}


public void listBySize() {
	
}

public void listByCreatedDate() {
	
}

}
