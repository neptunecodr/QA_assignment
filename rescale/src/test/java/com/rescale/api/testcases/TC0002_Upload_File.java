
/* 
*  FilesPage:  uploadFilesAPI- post api call to upload a file to remote bucket.
*/


package com.rescale.api.testcases;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.rescale.baseSetup.APITestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC0002_Upload_File extends APITestBase {
	private static final String filePath = System.getProperty("user.dir");
	protected File uploadNewFile_single= new  File(filePath+"/upload_file1.txt");
	
	
@BeforeClass
void getAllFiles() throws InterruptedException {
	logger.info("*********** Started TC0001_Get_All_Files *********** ");
	System.out.println(uploadNewFile_single);
	
	RestAssured.baseURI = "https://platform.rescale.com/api/v2";
	String basePath="/files/contents/";
	System.out.println(API_KEY);
	Map<String,Object> headerMap = new HashMap<String,Object>();
	headerMap.put("Authorization", API_KEY);
	headerMap.put("ContentType", "form-data");
	httpRequest = RestAssured.given().
			headers(headerMap).body(uploadNewFile_single);
			//multiPart("restAPI.log",uploadNewFile_single);
	response = httpRequest.request(Method.POST,basePath);
	//response = httpRequest.request(Method.GET,"/storage-devices/");
		
	Thread.sleep(3000);
}
		
@Test
public void verifyUploadFile_StatusCode() throws InterruptedException {
logger.info("*********** checking Status Code for upload file -'single file' TC0001_Get_All_Files *********** ");
	
	int statusCode = response.getStatusCode();
	logger.info("Status Code is ==>" + statusCode); //204
	try{
		Assert.assertEquals(statusCode, 201);
		}catch(AssertionError e){
		  // Log error;
		   //Takescreenshot;
			Thread.sleep(200);
			//System.out.println("get all files api request failed......");	
			logger.info("upload file returned invalid statuscode ");
			logger.info("uploading file Failed ");
		}	
}

@AfterClass
void tearDown() {
	logger.info("*********** finish TC0001_Get_All_Files *********** ");	
}

}
